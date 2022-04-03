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

}
