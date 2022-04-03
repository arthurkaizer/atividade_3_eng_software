package com.jcg.hibernate.crud.operations.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Crime_689386_698159")
public class Crime implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="descricao")
    private String descricao;

    @OneToMany(mappedBy = "crime")
    private List<CriminosoCrime> criminosoCrimes;

    @OneToMany(mappedBy = "crime")
    private List<VitimaCrime> vitimaCrimes;

    @OneToMany(mappedBy = "crime")
    private List<ArmaCrime> armaCrimes;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
