package net.ict.campus.boesche.model.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Froesche")
public class Froesche {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name = "ID_Frosch")
private Integer id;

    private String Name;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return Name;
    }
}
