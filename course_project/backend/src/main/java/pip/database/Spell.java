package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "spells")
public class Spell {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

    public Integer basecost;

    @ManyToOne
    @JoinColumn(name = "schools_id")
    public School school;

    public Integer level;

    @ManyToOne
    @JoinColumn(name = "effects_id")
    public Effect effects;
}
