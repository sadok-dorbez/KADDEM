package tn.esprit.projet.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Option;
import tn.esprit.projet.services.IContratService;
import tn.esprit.projet.services.IDepartementService;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class DepartementController {

    IDepartementService iDepartementService;

    @GetMapping("/getD")
    public List<Departement> GetDep(){

        return  iDepartementService.getAlldep();
    }

    @PostMapping("/addDep")
    public void  addContrat(@RequestBody Departement D){
        iDepartementService.addep(D);
    }


    @PutMapping("/putDep/{idDepart}")
    public void updateC(@PathVariable("idDepart") Long id, @RequestBody Departement C){

        C.setIdDepart(id);
        iDepartementService.updatedep(C);
    }
    @DeleteMapping("/delDep/{idDepart}")
    public  void deleteC(@PathVariable("idDepart") Long id){

        iDepartementService.deletedep(id);
    }

    @GetMapping("/getDep/{option}")
    public List<Departement> GetDepQ(@PathVariable("option" ) Option op){

        return  iDepartementService.retrieveDepartementByOptionEtudiant(op);
    }
    @GetMapping("/getIDU/{idUni}")
    public Set<Departement> GetDepByIdUni(@PathVariable("idUni") Long ID){

        return  iDepartementService.retrieveDepartementsByUniversite(ID);
    }
}
