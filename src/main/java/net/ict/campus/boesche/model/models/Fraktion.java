package net.ict.campus.boesche.model.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fraktion")
public class Fraktion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Fraktion;

    private String name;

    @OneToMany
    //Verhindert den Loop
    @JsonBackReference
    //Ist eine Setliste, da in der Theorie eine Fraktion zu mehreren Froesche gehören kann.
    private Set<Froesche> froesche = new HashSet<>();

    public Integer getId_Fraktion() {
        return Id_Fraktion;
    }

    public void setId_Fraktion(Integer id_Fraktion) {
        Id_Fraktion = id_Fraktion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Froesche> getFroesche() {
        return froesche;
    }

    public void setFroesche(Set<Froesche> froesche) {
        this.froesche = froesche;
    }
}
