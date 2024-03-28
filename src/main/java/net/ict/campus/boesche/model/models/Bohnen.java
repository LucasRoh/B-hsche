package net.ict.campus.boesche.model.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Bohnen")
public class Bohnen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bohnen;
    @NotNull
    @NotBlank
    //Many to One weil Tabelle Fremdschlüssel hat
    @ManyToOne
    @JoinColumn(name = "ability_id")
    private Abilities abilities;
    @NotBlank
    @NotNull
    private String name;

    @OneToMany(mappedBy = "bohnen_ID")
    //Verhindert den Loop
    @JsonBackReference
    //Ist eine Setliste, da in der Theorie eine Ability zu mehreren Bohnen gehören kann.
    private Set<Froesche> froesche = new HashSet<>();

    public Integer getId_bohnen() {
        return id_bohnen;
    }

    public void setId_bohnen(Integer id_bohnen) {
        this.id_bohnen = id_bohnen;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
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
