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

  List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th);
  List<Equipe> findEquipeByEtudinatsIdEtudiant(Integer id);
  List<Equipe> findByEtudinatsIdEtudiantAndDetailEquipeThematiqueNotNull(Integer idEtudiant);
  List<Equipe> findByEtudinatsIdEtudiantAndEtudinatsDepartementIdDepart(Integer idEtudiant, Integer idDepart);
  List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique);
}