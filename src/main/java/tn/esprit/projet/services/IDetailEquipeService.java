package tn.esprit.projet.services;

import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.DetailEquipe;
import tn.esprit.projet.entities.Equipe;

import java.util.List;

public interface IDetailEquipeService {

    List<DetailEquipe> getAlldeqp();
    DetailEquipe adddeqp(DetailEquipe E);
    DetailEquipe updatedeqp(DetailEquipe E);
    void deletedeqp(long id);
    DetailEquipe getdeqpbyid(long id);
    List<DetailEquipe> findByThematiqueLike (String thematique);

}
