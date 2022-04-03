package com.jcg.hibernate.crud.operations.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Arma_699742_701298")
public class Arma implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "tipo")
    private String tipo;

    @OneToMany(mappedBy = "arma")
    private List<ArmaCrime> armaCrimes;

    public Arma(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<ArmaCrime> getArmaCrimes() {
        return armaCrimes;
    }

    public void setArmaCrimes(List<ArmaCrime> armaCrimes) {
        this.armaCrimes = armaCrimes;
    }
}
