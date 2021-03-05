package com.wisea.yysc.tp.trade.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cyq
 */
public class ZxingUtil {

    private static final String FORMAT = "png";
    private static final int DEFAULT_WIDTH = 255;
    private static final int DEFAULT_HEIGHT = 255;

    private static BitMatrix setBitMatrix(String content) throws WriterException {
        return setBitMatrix(content, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    private static BitMatrix setBitMatrix(String content, int width, int height) throws WriterException {
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵

        return bitMatrix;
    }

    public static void genCode(String content) throws IOException, WriterException {
        BitMatrix bitMatrix = setBitMatrix(content);

        String filePath = "D://";
        String fileName = "zxing.png";
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToFile(bitMatrix, FORMAT, new File(filePath + fileName));
        System.out.println("输出成功.");
    }


    public static void genCode(String content, OutputStream stream) throws IOException, WriterException {
        BitMatrix bitMatrix = setBitMatrix(content);

        MatrixToImageWriter.writeToStream(bitMatrix, FORMAT, stream);
    }
}
