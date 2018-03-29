package pip.database;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "itemtypes")
public class ItemType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

}
