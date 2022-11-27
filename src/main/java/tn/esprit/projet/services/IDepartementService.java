package tn.esprit.projet.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Option;

import java.util.List;
import java.util.Set;

public interface IDepartementService {


    List<Departement> getAlldep();
    Departement addep(Departement D);
    Departement updatedep(Departement D);
    void deletedep(long id);



    Departement getdepbyid(long id);

    List<Departement> retrieveDepartementByOptionEtudiant( Option op);
    Set<Departement> retrieveDepartementsByUniversite(Long idUniversite);
}
