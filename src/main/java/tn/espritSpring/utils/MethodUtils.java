package tn.espritSpring.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tn.espritSpring.DAO.entites.Equipe;


public class MethodUtils {
    private MethodUtils() {
    }

    public static byte[] generateByteQRCode(String text, int width, int height) {
        ByteArrayOutputStream outputStream = null;
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            outputStream = new ByteArrayOutputStream();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageConfig config = new MatrixToImageConfig(0xFF000000, 0xFFFFFFFF);
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream, config);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public static void generateImageQRCode(String text, int width, int height, String path) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", FileSystems.getDefault().getPath(path));
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    public static ByteArrayInputStream contactListToExcelFile(List<Equipe> equipes) {
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Equipes");

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header
            Cell cell = row.createCell(0);
            cell.setCellValue("#ID");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Nom Equipe");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Niveau");
            cell.setCellStyle(headerCellStyle);

            // Creating data rows for each customer
            for(int i = 0; i < equipes.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(equipes.get(i).getIdEquipe());
                dataRow.createCell(1).setCellValue(equipes.get(i).getNomEquipe());
                dataRow.createCell(2).setCellValue(equipes.get(i).getNiveau().ordinal());
            }

            // Making size of column auto resize to fit with data
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
