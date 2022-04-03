package com.jcg.hibernate.crud.operations.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Criminoso_699742_701298")
public class Criminoso implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome")
    private String nome;


    @OneToMany(mappedBy = "criminoso", cascade = CascadeType.MERGE)
    private List<CriminosoCrime> criminosoCrimes;
}
