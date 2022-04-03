package com.jcg.hibernate.crud.operations.Model;
import com.jcg.hibernate.crud.operations.Model.IdsCompostos.VitimaCrimeID;

import javax.persistence.*;

@Entity
@IdClass(VitimaCrimeID.class)
@Table(name="Vitima_Crime_699742_701298")
public class VitimaCrime {
    @Id
    @ManyToOne
    @JoinColumn(name="crime_id")
    private Crime crime;

    @Id
    @ManyToOne
    @JoinColumn(name="vitima_id")
    private Vitima vitima;
}
