package com.jcg.hibernate.crud.operations.Controller;

import com.jcg.hibernate.crud.operations.Model.Arma;
import com.jcg.hibernate.crud.operations.dbOperations.DbOperations_Arma;

import java.util.List;

public class ArmaCT {
    public List<Arma> getArmas(){
        return DbOperations_Arma.displayRecords();
    }


    public void createArma(String tipo,String nome){
        Arma arma = new Arma(0,tipo);
        DbOperations_Arma.createRecord(arma);
    }
    public Arma select(String nome){
        return DbOperations_Arma.getByName(nome);
    }
    public void delete(Arma cbusca) {
        DbOperations_Arma.deleteRecord(cbusca.getId());
    }

    public void update(Arma arma) {
        DbOperations_Arma.updateRecord(arma);
    }
}
