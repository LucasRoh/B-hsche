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
    private Integer id;
    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "abilityId")
    private Abilities abilityId;
    @NotBlank
    @NotNull
    private String name;

    @OneToMany
    //Verhindert den Loop
    @JsonBackReference
    //Ist eine Setliste, da in der Theorie eine Bohne zu mehreren Froesche gehören kann.
    private Set<Froesche> froesche = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Abilities getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Abilities abilityId) {
        this.abilityId = abilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
