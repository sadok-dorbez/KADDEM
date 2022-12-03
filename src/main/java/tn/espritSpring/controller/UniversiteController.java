package tn.espritSpring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.espritSpring.DAO.entites.Departement;
import tn.espritSpring.DAO.entites.Universite;
import tn.espritSpring.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/Universite")
@RequiredArgsConstructor
public class UniversiteController {

    public final  IUniversiteService iUniversiteService;

    @GetMapping("/getAllUniversite")
    public List<Universite> getAllUniversite() {
        return iUniversiteService.getAllUniversite();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u) {return iUniversiteService.addUniversite(u);}



    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite u) {
        return iUniversiteService.updateUniversite(u);
    }




    @DeleteMapping("/deleteUniversite/{idUniv}")
    public void deleteUniversite(@PathVariable("idUniv") int idUniv) {
        iUniversiteService.deleteUniversite(idUniv);
    }

    @GetMapping("/getbyid/{idUniv}")
    public Universite getEtudiantById(@PathVariable("idUniv") int idUniv) {
        return iUniversiteService.getUniversiteById(idUniv);
    }

    @GetMapping("/getDepartmentByUniversity/{idUniv}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable Integer idUniv) {
        return iUniversiteService.retrieveDepartementsByUniversite(idUniv);
    }

}
