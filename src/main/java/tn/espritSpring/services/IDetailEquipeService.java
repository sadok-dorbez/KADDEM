package tn.espritSpring.services;

import tn.espritSpring.DAO.entites.DetailEquipe;
import tn.espritSpring.DAO.entites.Etudinat;

import java.util.List;

public interface IDetailEquipeService {
    void assignDetailEquipeToEquipe (Integer idDetailEquipe , Integer idEquipe  );
    List<DetailEquipe> getAllDetailEquipe() ;
    DetailEquipe addDetailEquipe(DetailEquipe d);
    DetailEquipe updateDetailEquipe (DetailEquipe d );
    void deleteDetailEquipe(Integer idDetailEquipe);
    DetailEquipe getDetailEquipeById(Integer idDetailEquipe) ;
    DetailEquipe update(DetailEquipe detailEquipe);
    List<DetailEquipe> findByThematiqueLike (String thematique);
}