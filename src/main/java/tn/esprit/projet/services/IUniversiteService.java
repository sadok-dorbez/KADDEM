package tn.esprit.projet.services;

import tn.esprit.projet.entities.DetailEquipe;
import tn.esprit.projet.entities.Universite;

import java.util.List;

public interface IUniversiteService {

    List<Universite> getAllUniv();
    Universite addUniv(Universite U);
    Universite updateUni(Universite U);
    void deleteUni(long id);
    Universite getUnid(long id);
    public void assignDepartToUni(Long idU,Long dep);
}
