package tn.esprit.projet.controller;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projet.entities.Reclamation;
import tn.esprit.projet.services.ReclamationServiceImpl;


@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ReclamationController {


    ReclamationServiceImpl reclamationService;


    @GetMapping("/retrieve-all-reclamations")

    public List<Reclamation> getAllReclamations() {
        List<Reclamation> reclamations  = reclamationService.retrieveAllReclamations();
        return reclamations;
    }

    @GetMapping("/retrieve-reclamation/{reclamation-id}")

    public Reclamation Reclamation(@PathVariable("reclamation-id") Long reclamationId) {
        return reclamationService.retrieveReclamation(reclamationId);
    }

    @PostMapping(value="/add-reclamation")
    public Reclamation addReclamation(@RequestBody Reclamation s )
    {
        Reclamation reclamations = reclamationService.addReclamation(s);
        return reclamations;
    }

    @PutMapping("/modify-reclamation/{reclamation-id}")
    public Reclamation modifyReclamation(@RequestBody Reclamation reclamations) {
        return reclamationService.updateReclamation(reclamations);
    }

    @DeleteMapping("/remove-reclamation/{reclamation-id}")
    public void removeReclamation(@PathVariable("reclamation-id") Long reclamationId) {
        reclamationService.deleteReclamation(reclamationId);
    }
}
