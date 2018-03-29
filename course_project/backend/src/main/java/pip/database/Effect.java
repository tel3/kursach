package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "effects")
public class Effect {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

}
