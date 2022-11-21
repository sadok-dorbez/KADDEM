package tn.espritSpring.services;

import tn.espritSpring.DAO.entites.Equipe;
import tn.espritSpring.DAO.entites.Niveau;

import java.util.List;

public interface IEquipeService {



  public   List<Equipe> getAllEquipe() ;
  public  Equipe addEquipe(Equipe e);
   public Equipe updateEquipe (Equipe e );

     void deleteEquipe(Integer idEquipe);
   public Equipe getEquipeById(Integer idEquipe) ;


}
