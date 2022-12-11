package tn.espritSpring.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import tn.espritSpring.DAO.entites.Departement;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PdfGeneratorService implements ServicePdf{
    @Override
    public ByteArrayInputStream exportPDF(List<Departement> departements) {
        {
            Document document =new Document(PageSize.A4);
            ByteArrayOutputStream out =new ByteArrayOutputStream();
            try {
                PdfWriter.getInstance(document, out);
                document.open();

                //add text to pdf
                //font
                Font font= FontFactory.getFont(FontFactory.COURIER,16, BaseColor.BLACK);
                Paragraph paragraph=new Paragraph("Departments List",font);
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                document.add(Chunk.NEWLINE);

                //columns
                PdfPTable table = new PdfPTable(4);
                //titles
                Stream.of("idDepart","nomDepart","code","type").forEach(headerTitle ->{
                    PdfPCell header=new PdfPCell();
                    Font headFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(headerTitle,headFont));
                    table.addCell(header);

                });

                for(Departement f:departements) {

                    table.addCell(f.getIdDepart().toString());


                    table.addCell(f.getNomDepart());


                    table.addCell(f.getCode());
                    table.addCell(f.getType());
                }
                document.add(table);
                document.close();
            } catch (DocumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

}
