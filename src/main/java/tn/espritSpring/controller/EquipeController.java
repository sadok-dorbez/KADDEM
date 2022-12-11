package tn.espritSpring.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.web.bind.annotation.*;
import tn.espritSpring.DAO.entites.Equipe;
import tn.espritSpring.DAO.entites.Niveau;
import tn.espritSpring.repositories.IEquipeRepository;
import tn.espritSpring.services.IEquipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import tn.espritSpring.utils.MethodUtils;


import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Equipe")
@RequiredArgsConstructor
public class EquipeController {
    private final  IEquipeService iEquipeService;
    private final IEquipeRepository equipeRepository ;

    private final String imagePath = "./src/main/resources/qrcodes/";

    @GetMapping("/getAllEquipe")
    public List<Equipe> getAllEquipe() {
        return iEquipeService.getAllEquipe();
    }

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe e) {return iEquipeService.addEquipe(e);}

    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        return iEquipeService.updateEquipe(e);
    }

    @DeleteMapping("/deleteEquipe/{idEquipe}")
    public void deleteEquipe(@PathVariable("idEquipe") int idEquipe) {iEquipeService.deleteEquipe(idEquipe);}

    @GetMapping("/getbyid/{idEquipe}")
    public Equipe getEquipeById (@PathVariable("idEquipe") int idEquipe) {
        return iEquipeService.getEquipeById(idEquipe);
    }

    @GetMapping("/getEquipeByNiveauAndThematique/{niveau}/{thematique}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niveau") Niveau niveau ,@PathVariable("thematique") String thematique){
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @DeleteMapping("/DeleteEquipeByNiveau/{niveau}")
    public void deleteEquipeByNiveau(@PathVariable("niveau") Niveau niveau){
        equipeRepository.deleteEquipeByNiveau(niveau);
    }




    @GetMapping("/findByEtudiant/{idEtudiant}")
    public List<Equipe> findEquipeByEtudiantIdEtudiant(@PathVariable("idEtudiant") int id) {
        return iEquipeService.findEquipeByEtudinatsIdEtudiant(id);
    }

    @GetMapping("/findByThematiqueNotNull/{idE}")
    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(@PathVariable("idE") int idEtudiant) {
        return iEquipeService.findByEtudinatsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @GetMapping("/findByEtudiantAndDepart/{idE}/{idD}")
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(@PathVariable("idE") int idEtudiant, @PathVariable("idD") Integer idDepart) {
        return iEquipeService.findByEtudinatsIdEtudiantAndEtudinatsDepartementIdDepart(idEtudiant, idDepart);
    }

    @GetMapping("/generateQrCode/{idEquipe}")
    public ResponseEntity<Equipe> generateImageQRCode(@PathVariable("idEquipe") int idEquipe) {
        Equipe equipe = iEquipeService.getEquipeById(idEquipe);
        String info=equipe.getIdEquipe()+" "+equipe.getNomEquipe()+" "+equipe.getNiveau();
        MethodUtils.generateImageQRCode(info, 250, 250, imagePath+"QRCode"+equipe.getIdEquipe()+".png");
        return new ResponseEntity<>(equipe, HttpStatus.OK);
    }

    @GetMapping("/download/equipes.xlsx")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=equipes.xlsx");
        ByteArrayInputStream stream = MethodUtils.contactListToExcelFile(iEquipeService.getAllEquipe());
        IOUtils.copy(stream, response.getOutputStream());
    }

}
