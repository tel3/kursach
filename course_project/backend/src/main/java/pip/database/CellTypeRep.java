package pip.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellTypeRep extends CrudRepository<CellType, Long> {
}