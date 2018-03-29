package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "itemtypes_id")
    private ItemType itemtype;

    @ManyToOne
    @JoinColumn(name = "itemsubtypes_id")
    private ItemSubtype itemsubtype;

    private Integer damage;

    private Integer armor;

    private Integer weight;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "perks_id")
    private Perk perk;

    @ManyToOne
    @JoinColumn(name = "bodyparts_id")
    private BodyPart bodypart;

    @ManyToOne
    @JoinColumn(name = "items_id")
    private Item upgrade;

    @ManyToOne
    @JoinColumn(name = "effects_id")
    private Effect effect;

}
