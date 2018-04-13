package pip.database;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    private String tag;

    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime dateTime;


    public Article(){
        dateTime = LocalDateTime.now();
    }

    public Article(String name, String author, String tag){
        this.name = name;
        this.author = author;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
