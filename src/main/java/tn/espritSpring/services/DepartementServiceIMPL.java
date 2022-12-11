package tn.espritSpring.services;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.espritSpring.DAO.entites.Departement;
import tn.espritSpring.DAO.entites.Option;
import tn.espritSpring.DAO.entites.Universite;
import tn.espritSpring.repositories.DepartementRepository;
import tn.espritSpring.repositories.IEtudinatRepository;
import tn.espritSpring.repositories.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DepartementServiceIMPL implements IDepartementService {



    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;

    IEtudinatRepository etudinatRepository;
    @Override
    public List<Departement> getAlldep() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addep(Departement D) {
        return departementRepository.save(D);
    }

    @Override
    public Departement updatedep(Departement D) {
        return departementRepository.save(D);
    }

    @Override
    public void deletedep(long id) {
       departementRepository.deleteById(id);

    }


    @Override
    public Departement getdepbyid(long id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option op) {
        return departementRepository.retrieveDepartementByOptionEtudiant(op);
    }

    @Override
    public List<Departement> findDepartementsBynomUniversite(String nomUni) {
        return departementRepository.findDepartementsBynomUniversite(nomUni);
    }


//    @Scheduled(cron = "*/10 * * * * *" )
    /*public int getDepartementsize() {
       List<Departement> List=(java.util.List<Departement>)departementRepository.findAll();

        System.out.println("scheduled "+List.size());
        return  List.size();
    }*/

//nombre totale des etudiant by department
    @Override
    public long nbTotalEtudiant(Long idDepart){
            Long nbT;
            Departement departement=departementRepository.findById(idDepart).orElse(null);
            nbT=departement.getEtudiants().stream().count();
        return nbT;
    }



    @Override
    public Departement  createUniver(Long idUniv,Departement d) {


            Universite universite = universiteRepository.findById(idUniv).orElse(null);
                universite.getDepartement().add(d);
                departementRepository.save(d);
            return d;
    }

    @Override
    public ResponseEntity<List<Departement>> deleteAllDepartmentOfUniversite(Long idUniv) {
        Universite universite = universiteRepository.findById(idUniv).orElse(null);
        universite.removeDepartments();
        universiteRepository.save(universite);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Departement>> getAllDepartmentOfUniversite(Long idUni) {
        Universite universite = universiteRepository.findById(idUni).orElse(null);
        List<Departement>departements=new ArrayList<Departement>();
        departements.addAll(universite.getDepartement());


        return new ResponseEntity<>(departements, HttpStatus.OK);
    }

//get nom department by id universite
    @Override
    public List<String> getNomsdepartbyidUniv(String nomUni) {
        return null;


    }

}


