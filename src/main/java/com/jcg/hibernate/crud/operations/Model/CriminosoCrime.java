package com.jcg.hibernate.crud.operations.Model;
import com.jcg.hibernate.crud.operations.Model.IdsCompostos.CriminosoCrimeID;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(CriminosoCrimeID.class)
@Table(name = "Criminoso_Crime_699742_701298")
public class CriminosoCrime implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name="crime_id")
    private Crime crime;

    @Id
    @ManyToOne
    @JoinColumn(name="arma_id")
    private Arma arma;
}
