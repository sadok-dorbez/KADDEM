package tn.esprit.projet.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Universite;
import tn.esprit.projet.services.IUniversiteService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UniversiteController {



    IUniversiteService iUniversiteService;

    @GetMapping("/allUni")
    public List<Universite> GetUni(){

        return  iUniversiteService.getAllUniv();
    }
    @PostMapping("/addUni")
    public void  addUniv(@RequestBody Universite D){
       iUniversiteService.addUniv(D);
    }


    @PutMapping("/putUni/{idUni}")
    public void updateUni(@PathVariable("idUni") Long id, @RequestBody Universite E){

        E.setIdUni(id);
        iUniversiteService.updateUni(E);
    }
    @DeleteMapping("/delUni/{idUni}")
    public  void deleteUni(@PathVariable("idUni") Long id){

     iUniversiteService.deleteUni(id);
    }
    @PostMapping("/addUniDep/{idUni}/{idDepart}")
    public void  addUnivtoDep(@PathVariable("idUni") Long idU,@PathVariable("idDepart") Long id){
        iUniversiteService.assignDepartToUni(idU, id);
    }

}
