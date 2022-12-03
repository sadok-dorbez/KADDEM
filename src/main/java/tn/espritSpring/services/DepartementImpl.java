package tn.espritSpring.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.espritSpring.DAO.entites.Departement;
import tn.espritSpring.DAO.entites.Etudinat;
import tn.espritSpring.DAO.entites.Universite;
import tn.espritSpring.repositories.IDepartementRepository;
import tn.espritSpring.repositories.IEquipeRepository;
import tn.espritSpring.repositories.IEtudinatRepository;
import tn.espritSpring.repositories.IUniversiteRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartementImpl implements IDepartementService{


    private final IDepartementRepository departementRepository;

    private final IUniversiteRepository universiteRepository ;
    private final IEtudinatRepository etudinatRepository;


    @Override
    public void assignEtudiantToDepartement(Integer idDepart, Integer idEtudiant) {
        Etudinat etudiant=etudinatRepository.findById(idEtudiant).orElse(null);
        Departement departement=getDepartementById(idDepart);
        etudiant.setDepartement(departement);
      etudinatRepository.save(etudiant);
    }


    @Override
    public void assignDepartementToUniversite(Integer idUniv, Integer idDepart){

        Departement departement=departementRepository.findById(idDepart).orElse(null);
        Universite universite=universiteRepository.findById(idUniv).orElse(null);
        universite.getDepartements().add(departement);
        universiteRepository.save(universite);


    }

    @Override
    public List<Departement> getAllDepartement() {
        return (List<Departement>) departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public void deleteDepartement(Integer idDepart) {
        departementRepository.deleteById(idDepart);
    }

    @Override
    public Departement getDepartementById(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }


    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        Departement d = departementRepository.findById(idDepart).orElse(null);
        return d;
    }


}
