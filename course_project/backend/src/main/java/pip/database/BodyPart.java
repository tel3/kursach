package pip.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bodyparts")
public class BodyPart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

}
