package net.ict.campus.boesche.model.models;

import javax.persistence.*;

@Entity
@Table(name="Fraktion")
public class Fraktion {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
private String Name;

}
