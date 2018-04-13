package pip;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import pip.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);

    private final ArticleRep articleRep;
    private final UserRep userRep;

    @Autowired
    public ApiController(ArticleRep articleRep, UserRep userRep){
        this.articleRep = articleRep;
        this.userRep = userRep;
    }

    @PostMapping(value = "/article/upload_article")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity uploadArticle(@RequestParam("file") String file, @RequestParam("name") String name,
                                @RequestParam("author") String author, @RequestParam("tag") String tag){
        try {
            byte[] bytes = file.getBytes();
            Article article = new Article(name, author, tag);
            article.setContent(bytes);
            articleRep.save(article);
            LOG.info("article uploaded!");
            return ResponseEntity.ok().body(null);
        }
        catch (Exception e){
            LOG.info(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You failed to upload article" + " => " + e.getMessage());
        }
    }

    @GetMapping("/article/id/{id}")
    @ResponseBody
    public ResponseEntity<Article> downloadArticle(@PathVariable("id") Long articleId){
        Article article = articleRep.findOne(articleId);
        if (article == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        ArticleRepresent articleRepresent = new ArticleRepresent(article.getName(), article.getAuthor(), article.getTag());
        articleRepresent.setContent(new String(article.getContent()));
        articleRepresent.setDateTime(article.getDateTime());
        return ResponseEntity.ok().body(article);
    }

    @GetMapping("/article/tag/{tag}")
    @ResponseBody
    public ResponseEntity<Iterable<Article>> getArticlesByTag(@PathVariable("tag") String tag){  //empty json
        List<Article> articles = articleRep.findByTag(tag);
        if (articles.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(articles);
    }

    @PostMapping(path = "/user")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody long addNewUser (@RequestParam String password, @RequestParam String email) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("USER");
        userRep.save(user);

        return user.getId();
    }

    @GetMapping(path="/user/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") long id) {
        return userRep.findOne(id);
    }

    @GetMapping(path = "/user/{email}")
    public @ResponseBody User getUserByEmail(@PathVariable("email") String email){
        return userRep.findByEmail(email);
    }
}
