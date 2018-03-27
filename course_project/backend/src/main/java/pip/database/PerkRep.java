package pip.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerkRep extends CrudRepository<Perk, Long> {
}
