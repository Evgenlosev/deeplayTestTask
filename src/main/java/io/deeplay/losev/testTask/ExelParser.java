package io.deeplay.losev.testTask;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExelParser {

    public static List<Entity> parseExcelFile() {
        List<Entity> entities = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(new File("Виды существ.xlsx"))) {
            Workbook wb = new XSSFWorkbook(fileInputStream);
            Sheet sheet = wb.getSheetAt(0);
            int lastRow = sheet.getLastRowNum() + 1;
            int lactColumn = sheet.getRow(0).getLastCellNum();

            for (int i = 1; i < lastRow; i++) {
                Entity entity = new Entity(sheet.getRow(i).getCell(0).getStringCellValue());
                for (int j = 1; j < lactColumn; j++) {
                    char key = sheet.getRow(0).getCell(j).getStringCellValue().toCharArray()[0];
                    int value = (int) sheet.getRow(i).getCell(j).getNumericCellValue();

                    if (entity.getEntityLandform().containsKey(key)) {
                        throw new RuntimeException("Название каждого типа клетки должно начинаться с уникальной буквы");
                    }
                    entity.getEntityLandform().put(key, value);
                }
                entities.add(entity);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Не найден файл с таблицей Excel");
        } catch (IOException e) {
            throw new RuntimeException("Не удалось получить доступ к файлу Excel");
        } catch (NullPointerException | IllegalStateException e) {
            throw new RuntimeException("Неверный формат Excel файла");
        }
    return entities;
    }


}
