package com.jcg.hibernate.crud.operations.Controller;

import com.jcg.hibernate.crud.operations.Model.Crime;
import com.jcg.hibernate.crud.operations.dbOperations.DbOperations_Crime;

import java.util.List;

public class CrimeCT {
    public Crime select(int id){
        return DbOperations_Crime.findCrimeById(id);
    }

    public List<Crime> getCrimes() {
        return DbOperations_Crime.displayCrimes();
    }

    public void postCrime(Crime c) {
        DbOperations_Crime.createCrime(c);
    }

    public Crime select(String descricaoDigitada) {
        return DbOperations_Crime.getByDescricao(descricaoDigitada);
    }

    public void delete(Crime cbusca) {
        DbOperations_Crime.deleteCrime(cbusca.getId());
    }

    public void update(Crime crime) {
        DbOperations_Crime.updateCrime(crime);
    }
}
