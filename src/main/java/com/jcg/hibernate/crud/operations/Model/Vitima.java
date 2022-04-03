package com.jcg.hibernate.crud.operations.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Vitima_699742_701298")
public class Vitima implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "vitima", cascade = CascadeType.MERGE)
    private List<VitimaCrime> vitimaCrimes;
}
