package net.ict.campus.boesche.model.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Abilities")
public class Abilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ability;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private Integer schaden;
    //Beziehung
    @OneToMany
    //Verhindert den Loop
    @JsonBackReference
    //Ist eine Setliste, da in der Theorie eine Ability zu mehreren Bohnen gehören kann.
    private Set<Bohnen> bohnen = new HashSet<>();

    @OneToMany
    //Verhindert den Loop
    @JsonBackReference
    //Ist eine Setliste, da in der Theorie eine Ability zu mehreren Bohnen gehören kann.
    private Set<Froesche> frosche = new HashSet<>();

    public Integer getId_ability() {
        return id_ability;
    }

    public void setId_ability(Integer id_ability) {
        this.id_ability = id_ability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSchaden() {
        return schaden;
    }

    public void setSchaden(Integer schaden) {
        this.schaden = schaden;
    }
}
