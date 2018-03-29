package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "perks")
public class Perk {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "effects_id")
    private Effect effect;

    private Integer levelreq;

    @ManyToOne
    @JoinColumn(name = "skills_id")
    private Skill skilltree;

}
