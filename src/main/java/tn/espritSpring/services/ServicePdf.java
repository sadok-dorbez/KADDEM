package tn.espritSpring.services;

import tn.espritSpring.DAO.entites.Departement;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ServicePdf {
    ByteArrayInputStream exportPDF(List<Departement> departements);
}
