package pip.database;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cells")
public class Cell {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "locations_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "celltypes_id")
    private CellType type;

}
