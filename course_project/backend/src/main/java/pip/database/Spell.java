package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "spells")
public class Spell {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer basecost;

    @ManyToOne
    @JoinColumn(name = "schools_id")
    private School school;

    private Integer level;

    @ManyToOne
    @JoinColumn(name = "effects_id")
    private Effect effects;
}
