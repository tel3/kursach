package pip.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyPartRep extends CrudRepository<BodyPart, Long> {
}
