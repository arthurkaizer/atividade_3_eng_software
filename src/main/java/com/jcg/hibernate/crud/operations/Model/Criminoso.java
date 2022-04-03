package com.jcg.hibernate.crud.operations.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Criminoso_699742_701298")
public class Criminoso implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CriminosoCrime> getCriminosoCrimes() {
        return criminosoCrimes;
    }

    public void setCriminosoCrimes(List<CriminosoCrime> criminosoCrimes) {
        this.criminosoCrimes = criminosoCrimes;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome")
    private String nome;


    @OneToMany(mappedBy = "criminoso", cascade = CascadeType.MERGE)
    private List<CriminosoCrime> criminosoCrimes;
}
