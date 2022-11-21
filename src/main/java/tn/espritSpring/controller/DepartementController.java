package tn.espritSpring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.espritSpring.DAO.entites.Departement;
import tn.espritSpring.services.IDepartementService;

import java.util.List;

@RestController
@RequestMapping("/Departement")
@RequiredArgsConstructor
public class DepartementController {

    public final  IDepartementService iDepartementService;


    @GetMapping("/getAldepartement")
    public List<Departement> getAllDepartement() {
        return iDepartementService.getAllDepartement();
    }

    @PostMapping("/add")
    public Departement addDepartement(@RequestBody Departement d) {return iDepartementService.addDepartement(d);}



//Affectation Departement au etudiant

    @PutMapping("/update/{idDepart}/{idEtudiant}")
    public void updateDepartement(@PathVariable ("idDepart") Integer idDepart ,@PathVariable ("idEtudiant") Integer idEtudiant )
    { iDepartementService.assignEtudiantToDepartement(idDepart,idEtudiant);}

//Affectation Universite au Departement

    @PutMapping("/assignDepartementToUniversite/{idUniv}/{idDepart}")
    @ResponseBody
    public void assigndep(@PathVariable("idUniv") Integer idUniv , @PathVariable("idDepart") Integer idDepart)
    {
        iDepartementService.assignDepartementToUniversite(idUniv,idDepart);
    }



    @DeleteMapping("/deletedepartement/{idDepart}")
    public void deleteDepartement(@PathVariable("idDepart") int idDepart) {iDepartementService.deleteDepartement(idDepart);}

    @GetMapping("/getdepartementbyid/{idDepart}")
    public Departement getDepartementById(@PathVariable("idDepart") int idDepart) {
        return iDepartementService.getDepartementById(idDepart);
    }


    @GetMapping("/retrieve-University/{idUniv}")
    @ResponseBody
    public Departement retrieveDepartement(@PathVariable("idUniv")Integer idDepart){
        return iDepartementService.retrieveDepartement(idDepart);
    }



}
