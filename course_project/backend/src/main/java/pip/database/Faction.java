package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "factions")
public class Faction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "locations_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "actors_id")
    private Actor initialleader;

}
