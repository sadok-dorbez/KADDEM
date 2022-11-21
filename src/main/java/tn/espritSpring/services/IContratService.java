package tn.espritSpring.services;

import tn.espritSpring.DAO.entites.Contart;

import java.util.Date;
import java.util.List;

public interface IContratService {



   public List<Contart> getAllContrat() ;
  public  Contart addContrat(Contart c);
  public  Contart updateContrat (Contart c );
    void deleteContrat(Integer idContart);
  public  Contart getContratById(Integer idContart) ;

  public Integer nbContratsValides(Date startDate, Date endDate);



}
