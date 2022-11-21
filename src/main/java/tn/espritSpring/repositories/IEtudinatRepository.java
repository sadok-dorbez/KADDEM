package tn.espritSpring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.espritSpring.DAO.entites.Etudinat;
import tn.espritSpring.DAO.entites.Option;
import tn.espritSpring.DAO.entites.Specialite;

import java.sql.Date;
import java.util.List;

public interface IEtudinatRepository extends CrudRepository<Etudinat , Integer> {

    @Query("select e from Etudinat e where e.option = :option")
    List<Etudinat> retriveEtudiantByOption(@Param("option") Option op);


    @Query("select e from Etudinat e where e.departement.nomDepart =: nomDepart")
    List<Etudinat> retriveEtudiantByDepartement (@Param("nomDepart") String nomDepart);



    @Query("select e from Etudinat e inner join e.departement ee where ee.nomDepart = :name")
    List<Etudinat> retriveEtudiantByDepartementName (@Param("name") String nomDepartement);

}
