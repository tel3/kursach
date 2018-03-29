package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "abilities")
public class Ability {
    @Id

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String acquisition;

    private Integer cooldown;

    @ManyToOne
    @JoinColumn(name = "abilitytypes_id")
    private AbilityType type;

    @ManyToOne
    @JoinColumn(name = "effects_id")
    private Effect effect;

}
