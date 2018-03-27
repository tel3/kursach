package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "effects")
public class Effect {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String description;

}
