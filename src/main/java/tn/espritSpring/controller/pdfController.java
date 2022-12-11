package tn.espritSpring.controller;


import lombok.AllArgsConstructor;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.espritSpring.DAO.entites.Departement;
import tn.espritSpring.repositories.DepartementRepository;
import tn.espritSpring.services.ServicePdf;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@AllArgsConstructor
@Controller
public class pdfController {
   DepartementRepository departementRepository;
   ServicePdf exportPDF;

   @GetMapping("/pdfDownload")
   public void downloadPdfFile(HttpServletResponse response) throws IOException {
       List<Departement> departements =(List<Departement>)departementRepository.findAll();
       ByteArrayInputStream byteArrayInputStream = exportPDF.exportPDF(departements);
       response.setContentType("application/octet-stream");
       response.setHeader("Content-Disposition", "inline; filename=departements.pdf");
       IOUtils.copy(byteArrayInputStream, response.getOutputStream());
   }
}
