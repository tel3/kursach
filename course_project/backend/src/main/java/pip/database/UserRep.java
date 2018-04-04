package pip.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends CrudRepository<User, Long> {
    User findByEmail(@Param("email") String email);
}
