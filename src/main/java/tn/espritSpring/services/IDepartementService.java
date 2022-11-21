package tn.espritSpring.services;

import tn.espritSpring.DAO.entites.Departement;

import java.util.List;

public interface IDepartementService {


    void assignEtudiantToDepartement (Integer idDepart , Integer idEtudiant);

    void assignDepartementToUniversite(Integer idUniv, Integer idDepart);

    List<Departement> getAllDepartement() ;
    Departement addDepartement(Departement d);
    Departement updateDepartement (Departement d );

    Departement retrieveDepartement (Integer idDepart);

     void deleteDepartement(Integer idDepart);
    Departement getDepartementById(Integer idDepart) ;




}
