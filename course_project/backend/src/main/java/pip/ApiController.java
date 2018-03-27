package pip;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import pip.database.Article;
import pip.database.ArticleRep;
import pip.database.ItemType;
import pip.database.ItemTypeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ArticleRep articleRep;

    @Autowired
    public ApiController(ArticleRep articleRep){
        this.articleRep = articleRep;
    }


    @GetMapping(value = "/greeting/{name}")
    public @ResponseBody String getGreeting(@PathVariable String name){
        String result = "Hello, " + name;
        return result;
    }

    @PostMapping(value = "/upload_article")
    public String handleArticleUpload(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
                                    @RequestParam("author") String author, @RequestParam("tag") String tag){
        if(!file.isEmpty()){
            try {
                byte[] bytes = IOUtils.toByteArray(file.getInputStream());
                Article article = new Article(name, author, tag);
                article.setContent(bytes);
                articleRep.save(article);
                return "redirect:/api";
            } catch (Exception e){
                return "You failed to upload article" + " => " + e.getMessage();
            }
        } else {
            return "redirect:/api";
        }
    }

    @GetMapping("/article/id/{id}")
    public ResponseEntity<Article> downloadArticle(@PathVariable("id") Long articleId){
        Article article = articleRep.findOne(articleId);
        if (article == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(article);
    }

    @GetMapping("/article/tag/{tag}")
    public Iterable<Article> getArticlesByTag(String tag){
        return articleRep.findByTag(tag);
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
