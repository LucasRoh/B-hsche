package net.ict.campus.boesche.model.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Fraktion")
public class Fraktion {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
private String Name;

    @OneToMany
    //Verhindert den Loop
    @JsonBackReference
    //Ist eine Setliste, da in der Theorie eine Fraktion zu mehreren Froesche gehören kann.
    private Set<Froesche> froesche = new HashSet<>();

}
