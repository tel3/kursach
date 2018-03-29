package pip;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import pip.database.Article;
import pip.database.ArticleRep;
import pip.database.ItemType;
import pip.database.ItemTypeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ArticleRep articleRep;

    @Autowired
    public ApiController(ArticleRep articleRep){
        this.articleRep = articleRep;
    }

    @PostMapping(value = "/article/upload_article")
    public ResponseEntity uploadArticle(@RequestParam("file") byte[] file, @RequestParam("name") String name,
                                @RequestParam("author") String author, @RequestParam("tag") String tag){
        try {
//            byte[] bytes = IOUtils.toByteArray(file);
            Article article = new Article(name, author, tag);
            article.setContent(file);
            articleRep.save(article);
            return ResponseEntity.ok().body(null);
        }
        catch (Exception e){
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

//    private final ItemTypeRep itemTypeRep;
//
//    @Autowired
//    public ApiController(ItemTypeRep itemTypeRep) {
//        this.itemTypeRep = itemTypeRep;
//    }
//
//    @GetMapping("/itemType")
//    public Iterable<ItemType> getItemTypes() {
//        return itemTypeRep.findAll();
//    }
//
//    @GetMapping("/itemTypes/{id}")
//    public ResponseEntity<ItemType> getItemTypeById (@PathVariable(value = "id") Long itemTypeId){
//        ItemType itemType = itemTypeRep.findOne(itemTypeId);
//        if (itemType == null){
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok().body(itemType);
//    }


}
