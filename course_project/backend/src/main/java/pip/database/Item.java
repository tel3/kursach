package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "itemtypes_id")
    public ItemType itemtype;

    @ManyToOne
    @JoinColumn(name = "itemsubtypes_id")
    public ItemSubtype itemsubtype;

    public Integer damage;

    public Integer armor;

    public Integer weight;

    public Integer price;

    @ManyToOne
    @JoinColumn(name = "perks_id")
    public Perk perk;

    @ManyToOne
    @JoinColumn(name = "bodyparts_id")
    public BodyPart bodypart;

    @ManyToOne
    @JoinColumn(name = "items_id")
    public Item upgrade;

    @ManyToOne
    @JoinColumn(name = "effects_id")
    public Effect effect;

}
