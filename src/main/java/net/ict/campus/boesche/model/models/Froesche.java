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

    private String image;
    @ManyToOne
    @JoinColumn(name = "bohnen_id")
    private Bohnen bohnen_ID;



    public Integer getId() {
        return id;
    }

    public String getName() {
        return Name;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}



