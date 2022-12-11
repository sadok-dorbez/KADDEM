package tn.espritSpring.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


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
}
