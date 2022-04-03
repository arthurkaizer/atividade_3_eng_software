package com.jcg.hibernate.crud.operations.Controller;

import com.jcg.hibernate.crud.operations.Model.Criminoso;
import com.jcg.hibernate.crud.operations.Model.Vitima;
import com.jcg.hibernate.crud.operations.dbOperations.DbOperations_Criminoso;
import com.jcg.hibernate.crud.operations.dbOperations.DbOperations_Vitima;

import java.util.List;

public class CriminosoCT {
    public void postCriminoso(Criminoso criminoso){
        DbOperations_Criminoso.createRecord(criminoso);
    }

    public List<Vitima> getVitimas(){
        return DbOperations_Vitima.displayRecords();
    }

    public  List<Criminoso> getCriminosos(){
        List<Criminoso> criminosos = DbOperations_Criminoso.displayRecords();
        return criminosos;
    }

    public Criminoso select(String nomeDigitado) {

        return DbOperations_Criminoso.getByName(nomeDigitado);
    }

    public void delete(Criminoso cbusca) {
        DbOperations_Criminoso.deleteRecord(cbusca.getId());
    }

    public void update(Criminoso criminoso) {
        DbOperations_Criminoso.updateRecord(criminoso);
    }

}
