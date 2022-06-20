package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;

public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {

    //@Modifying
   // @Transactional
    //@Query("DELETE from Departement e where e.id =:depId")
    // public void deleteDepartementById(int depId);
    @Query("select e from Entreprise e where e.name=:nom")
    public Entreprise findByName(String nom);
}
