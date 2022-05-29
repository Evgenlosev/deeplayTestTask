package io.deeplay.losev.testTask;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSignatureLine;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExelParser {
    private static FileInputStream fileInputStream;

    public static List<Entity> parseExcelFile() {
        List<Entity> entities = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(new File("Виды существ.xlsx"));
            Workbook wb = new XSSFWorkbook(fileInputStream);
            Sheet sheet = wb.getSheetAt(0);
            int lastRow = sheet.getLastRowNum() + 1;
            int lactColumn = sheet.getRow(0).getLastCellNum();

            for (int i = 1; i < lastRow; i++) {
                Entity entity = new Entity(sheet.getRow(i).getCell(0).getStringCellValue());
                for (int j = 1; j < lactColumn; j++) {
                    entity.getEntityLandform().put(sheet.getRow(0).getCell(j).getStringCellValue().toCharArray()[0],
                            (int) sheet.getRow(i).getCell(j).getNumericCellValue());
                }
                entities.add(entity);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    return entities;
    }


}
