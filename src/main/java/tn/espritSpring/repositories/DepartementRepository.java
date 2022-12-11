package tn.espritSpring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.espritSpring.DAO.entites.Departement;
import tn.espritSpring.DAO.entites.Option;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Long> {

    @Query("SELECT dep FROM Departement dep,Universite univ inner JOIN  univ.departement d ON d.idDepart=dep.idDepart and  univ.nomUni=:nomUni  ")
    List findDepartementsBynomUniversite(@Param("nomUni") String nomUni);
    //

    @Query("SELECT  departement FROM Departement  departement  , Etudinat e where departement.idDepart=e.departement.idDepart and e.option = :op")
    List<Departement> retrieveDepartementByOptionEtudiant(@Param("op") Option op);

    @Query("SELECT dep FROM Departement dep,Universite univ inner JOIN  univ.departement d ON d.idDepart=dep.idDepart and  univ.idUni=:idUni")
    List retrievenomDepartementsByIDUniversite(@Param("idUni") Long idUni);
}
