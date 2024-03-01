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
    private Integer ID_Fraktion;

    private String name;

    @OneToMany
    //Verhindert den Loop
    @JsonBackReference
    //Ist eine Setliste, da in der Theorie eine Fraktion zu mehreren Froesche gehören kann.
    private Set<Froesche> froesche = new HashSet<>();

    public Fraktion() {
    }

    public Integer getID_Fraktion() {
        return ID_Fraktion;
    }

    public void setID_Fraktion(Integer ID_Fraktion) {
        this.ID_Fraktion = ID_Fraktion;
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
