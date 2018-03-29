package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Character gender;

    @ManyToOne
    @JoinColumn(name = "races_id")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "factions_id")
    private Faction faction;

    private Boolean hostility;

    private Boolean interactivity;

    private Boolean uniqueness;

}
