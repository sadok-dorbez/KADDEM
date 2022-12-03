package tn.espritSpring.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.espritSpring.DAO.entites.Departement;
import tn.espritSpring.DAO.entites.Universite;
import tn.espritSpring.repositories.IUniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
 public class UniversiteImpl implements IUniversiteService{


    @Autowired
    private final  IUniversiteRepository universiteRepository;



    @Override
    public List<Universite> getAllUniversite() {
        return (List<Universite>) universiteRepository.findAll();
    }
    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }
    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }
    @Override
    public void deleteUniversite(Integer idUniv) {universiteRepository.deleteById(idUniv);}
    @Override
    public Universite getUniversiteById(Integer idUniv) {
        return universiteRepository.findById(idUniv).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        List<Departement> listDepart = new ArrayList<>();
        for (Departement d:universite.getDepartements()) {
            listDepart.add(d);
        }
        return listDepart;
    }
}
