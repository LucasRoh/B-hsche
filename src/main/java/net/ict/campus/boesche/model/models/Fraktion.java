package net.ict.campus.boesche.model.models;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table ( name = "Fraktion")
public class Fraktion {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
private String Name;

}
