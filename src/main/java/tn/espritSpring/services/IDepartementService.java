package tn.espritSpring.services;


import org.springframework.http.ResponseEntity;
import tn.espritSpring.DAO.entites.Departement;
import tn.espritSpring.DAO.entites.Option;

import java.util.List;

public interface IDepartementService {


    List<Departement> getAlldep();
    Departement addep(Departement D);
    Departement updatedep(Departement D);
    void deletedep(long id);
    Departement getdepbyid(long id);

    List<Departement> retrieveDepartementByOptionEtudiant(Option op);

     List<Departement>findDepartementsBynomUniversite(String nomUni);

  //  int getDepartementsize();
    long nbTotalEtudiant(Long idEtudiant);
         Departement createUniver(Long idUniv,Departement d);
    ResponseEntity<List<Departement>> deleteAllDepartmentOfUniversite(Long idUniv);
    ResponseEntity<List<Departement>> getAllDepartmentOfUniversite(Long idUni);
    List<String> getNomsdepartbyidUniv(String  nomUni);



}
