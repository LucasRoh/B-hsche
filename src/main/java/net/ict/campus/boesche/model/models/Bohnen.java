package net.ict.campus.boesche.model.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
