package tn.esprit.projet.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.services.IContratService;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ContratController {

    IContratService contratService;

    @GetMapping("/getC")
    public List<Contrat> GetC(){

        return  contratService.getAllContrat();
    }

    @PostMapping("/addC")
    public void  addContrat(@RequestBody Contrat C){
        contratService.addContrat(C);
    }


    @PutMapping("/putC/{idContrat}")
    public void updateC(@PathVariable("idContrat") Long id, @RequestBody Contrat C){

        C.setIdContrat(id);
        contratService.updateContrat(C);
    }
    @DeleteMapping("/delC/{idContrat}")
    public  void deleteC(@PathVariable("idContrat") Long id){

        contratService.deleteContrat(id);
    }
    @GetMapping("/getValide/{DateDebutContrat}/{DateFinContrat}")
    public Integer GetValide(@PathVariable("DateDebutContrat") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateD, @PathVariable("DateFinContrat")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date dateF){

        return  contratService.nbContratsValides(dateD,dateF);
    }


    @GetMapping("/getCA/{DateDebutContrat}/{DateFinContrat}")
    public Float GetCA(@PathVariable("DateDebutContrat") @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)Date dateD, @PathVariable("DateFinContrat")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date dateF){

        return  contratService.getChiffreAffaireEntreDeuxDate(dateD,dateF);
    }
}
