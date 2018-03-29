package pip.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRep extends CrudRepository<Article, Long> {
    List<Article> findByTag(@Param("tag") String tag);
}
