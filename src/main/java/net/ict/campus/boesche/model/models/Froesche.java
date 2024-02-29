package net.ict.campus.boesche.model.models;

import javax.persistence.*;

@Entity
@Table(name="Froesche")
public class Froesche {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Integer id;
private String Name;
}
