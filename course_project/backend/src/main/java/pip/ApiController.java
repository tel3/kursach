package pip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pip.database.Article;
import pip.database.ArticleRep;
import pip.database.User;
import pip.database.UserRep;

import java.util.*;

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
            return ResponseEntity.ok().body(article.getId());
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

    @GetMapping("/article/delete/{id}")
    @ResponseBody
    public ResponseEntity<Article> deleteArticle(@PathVariable("id") Long articleId){
        Article article = articleRep.findOne(articleId);
        if (article == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        articleRep.delete(articleId);

        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/article/tag/{tag}")
    @ResponseBody
    public ResponseEntity<Iterable<ArticleRepresent>> getArticlesByTag(@PathVariable("tag") String tag){  //empty json
        List<Article> articles = articleRep.findByTag(tag);
        if (articles.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        List<ArticleRepresent> articleRepresents = new ArrayList<>();
        for (Article article : articles) {
            ArticleRepresent articleRepresent = new ArticleRepresent(article.getName(), article.getAuthor(), article.getTag());
            articleRepresent.setContent(new String(article.getContent()));
            articleRepresent.setDateTime(article.getDateTime());
            articleRepresents.add(articleRepresent);

        }
        return ResponseEntity.ok().body(articleRepresents);
    }

    @GetMapping("/tags")
    @ResponseBody
    public ResponseEntity<Set<String>> getTags(){
        List<Article> articles = (ArrayList)articleRep.findAll();
        if (articles.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Set<String> tags = new HashSet<>();
        for (Article article : articles) {
            tags.add(article.getTag());
        }

        return ResponseEntity.ok().body(tags);
    }

    @GetMapping("/digest")
    @ResponseBody
    public ResponseEntity <Iterable<Article>> getDigest(){
        List<Article> articles = (ArrayList)articleRep.findAll();
        if (articles.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Collections.sort(articles, new Comparator<Article>() {
            public int compare(Article o1, Article o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        });

        articles = articles.subList(0, 5);

        return ResponseEntity.ok().body(articles);
    }

    @PostMapping(path = "/user/add")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ResponseEntity addNewUser (@RequestParam String password, @RequestParam String email){

        if (emailExist(email)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("USER");
        userRep.save(user);

        return ResponseEntity.ok().body(null);
    }

    private boolean emailExist(String email) {
        User user = userRep.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    @GetMapping(path="/user/{id}")
    public @ResponseBody ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = userRep.findOne(id);

        if (user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok().body(user);
    }

    @GetMapping(path = "/user/{email}")
    public @ResponseBody ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
        User user = userRep.findByEmail(email);

        if (user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok().body(user);
    }
}
