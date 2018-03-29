package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "itemsubtypes")
public class ItemSubtype {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

}
