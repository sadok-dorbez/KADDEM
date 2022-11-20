package tn.esprit.projet.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.Reclamation;
import tn.esprit.projet.repository.ReclamationRepository;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class ReclamationServiceImpl  implements IReclamationService {

    ReclamationRepository Reclamationrepo;

    @Override
    public List<Reclamation> retrieveAllReclamations() {
        return (List<Reclamation>) this.Reclamationrepo.findAll();
    }

    @Override
    public Reclamation addReclamation(Reclamation r) {
        Date date = new Date();
        r.setDateReclamation(date);

        //r.setClientReclamation(clientService.retrieveClient(r.getClientReclamation().getIdClient()));
        return this.Reclamationrepo.save(r);
    }
    @Override
    public void deleteReclamation(Long id) {
        Reclamationrepo.deleteById(id);

    }

    @Override
    public Reclamation updateReclamation(Reclamation r) {
        Reclamation reclamation = Reclamationrepo.findById(r.getIdReclamation()).orElse(null);
        if(reclamation != null)
            Reclamationrepo.save(r);
        return r;
    }

    @Override
    public Reclamation retrieveReclamation(Long id) {
        return this.Reclamationrepo.findById(id).orElse(null);
    }
}
