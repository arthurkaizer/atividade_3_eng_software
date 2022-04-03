package com.jcg.hibernate.crud.operations.Model;

import com.jcg.hibernate.crud.operations.Model.IdsCompostos.ArmaCrimeID;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@IdClass(ArmaCrimeID.class)
@Table(name = "Arma_Crime_699742_701298")
public class ArmaCrime implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "crimeId")
    private Crime crime;

    @Id
    @ManyToOne
    @JoinColumn(name = "armaId")
    private Arma arma;
}
