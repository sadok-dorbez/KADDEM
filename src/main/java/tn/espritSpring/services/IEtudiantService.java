package tn.espritSpring.services;

import tn.espritSpring.DAO.entites.Etudinat;

import java.util.List;

public interface IEtudiantService {


    void assignContratToEtudiant (Integer idEtudiant ,Integer idContart  );

  public  Etudinat addAndAssignEtudiantToEquipeAndContract(Integer idEtudiant, Integer idContart, Integer idEquipe);

   public List<Etudinat> getAllEtudiant() ;
   public Etudinat addEtudiant(Etudinat etudinat);

   public Etudinat updateEtudiant(Etudinat etudinat);

    void deleteEtudiant(Integer idEtudiant);

    Etudinat retrieveEtudiant(Integer idEtudiant);

   public Etudinat getEtudiantById(Integer idEtudiant) ;


   List<Etudinat> retriveEtudiantByDepartementName (String nomDepart);

    void assignEtudiantToEquipe(Integer idEtudiant, Integer idEquipe);

    public String generecarteetudpdf(Integer idEtudiant);

 void getlistetudiantExcel();

 void notifierEtudiant(Integer idEtudiant) ;

}
