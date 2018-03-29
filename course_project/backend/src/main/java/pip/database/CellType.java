package pip.database;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "celltypes")
public class CellType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

}
