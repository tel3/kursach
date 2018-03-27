package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "abilitytypes")
public class AbilityType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

}
