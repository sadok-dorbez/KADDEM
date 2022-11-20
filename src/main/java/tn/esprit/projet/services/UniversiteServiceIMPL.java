package tn.esprit.projet.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Universite;
import tn.esprit.projet.repository.DepartementRepository;
import tn.esprit.projet.repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceIMPL implements  IUniversiteService {



    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;

    @Override
    public List<Universite> getAllUniv() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniv(Universite U) {
        return universiteRepository.save(U);
    }

    @Override
    public Universite updateUni(Universite U) {
        return universiteRepository.save(U);
    }

    @Override
    public void deleteUni(long id) {
        universiteRepository.deleteById(id);

    }

    @Override
    public Universite getUnid(long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void assignDepartToUni(Long idU, Long dep) {
        Universite universite =universiteRepository.findById(idU).orElse(null);
        Departement departement =departementRepository.findById(dep).orElse(null);
        universite.getDepartement().add(departement);
        universiteRepository.save(universite);


    }
}
