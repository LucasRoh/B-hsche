package net.ict.campus.boesche.model.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Bohnen")
public class Bohnen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bohnen;
    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "ability_id")
    private Abilities abilities;
    @NotBlank
    @NotNull
    private String name;

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
}
