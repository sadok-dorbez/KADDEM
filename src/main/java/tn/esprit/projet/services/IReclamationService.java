package tn.esprit.projet.services;

import tn.esprit.projet.entities.Reclamation;

import java.util.List;

public interface IReclamationService {
    List<Reclamation> retrieveAllReclamations();

    Reclamation addReclamation(Reclamation r);

    Reclamation updateReclamation(Reclamation r);

    Reclamation retrieveReclamation(Long id);
    void deleteReclamation(Long id);

}
