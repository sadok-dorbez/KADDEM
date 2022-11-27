package tn.esprit.projet.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Option;
import tn.esprit.projet.entities.Universite;
import tn.esprit.projet.repository.DepartementRepository;
import tn.esprit.projet.repository.UniversiteRepository;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class DepartementServiceIMPL implements IDepartementService {




    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Departement> getAlldep() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addep(Departement D) {
        log.debug("test method adddep");
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
    public Set<Departement> retrieveDepartementsByUniversite(Long idUniversite) {
        Universite uni=universiteRepository.findById(idUniversite).orElse(null);
        return  uni.getDepartement();
    }

}
