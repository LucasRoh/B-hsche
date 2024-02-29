package net.ict.campus.boesche.model.models;

import javax.persistence.*;

@Entity
@Table(name = "Bohnen")
public class Bohnen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PrimaryKey;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ForeignKey;

}
