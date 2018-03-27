package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "abilities")
public class Ability {
    @Id

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String acquisition;

    public Integer cooldown;

    @ManyToOne
    @JoinColumn(name = "abilitytypes_id")
    public AbilityType type;

    @ManyToOne
    @JoinColumn(name = "effects_id")
    public Effect effect;

}
