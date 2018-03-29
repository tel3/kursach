package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "effects_id")
    private Effect effect;
}
