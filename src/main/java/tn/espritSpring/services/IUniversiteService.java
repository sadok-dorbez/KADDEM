package tn.espritSpring.services;

import tn.espritSpring.DAO.entites.Universite;

import java.util.List;

public interface IUniversiteService {

    List<Universite> getAllUniv();
    Universite addUniv(Universite U);
    Universite updateUni(Universite U);
    void deleteUni(long id);
    Universite getUnid(long id);
    public void assignDepartToUni(Long idU,Long dep);
    //void getDepartmentTouniversite(Long idU,Long dep);
    long nbTotalDepartment(Long idUni);
    //List nbTotalDepartmentbynom(String nomUni);
    //List<Universite> getUniversitebyNomDepart( Long idDepart);
    ///Set<Universite> getUniversitesByDepartement (Long idDepartement);
}
