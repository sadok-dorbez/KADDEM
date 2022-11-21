package tn.espritSpring.services;

import tn.espritSpring.DAO.entites.Universite;

import java.util.List;

public interface IUniversiteService {



    public  List<Universite> getAllUniversite() ;
    public Universite addUniversite(Universite u);
    public Universite updateUniversite (Universite u );
     void deleteUniversite(Integer idUniv);
    public Universite getUniversiteById(Integer idUniv) ;
}
