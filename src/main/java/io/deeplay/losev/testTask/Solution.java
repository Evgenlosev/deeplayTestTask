package io.deeplay.losev.testTask;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class Solution {

    public static void main(String[] args) throws IOException {
        int result = getResult("STWSWTPPTPTTPWPS", "Human");
        System.out.println(result);

//        List<Entity> entities = ExelParser.parseExcelFile();
//        System.out.println(entities);
    }

    public static int getResult(String cells, String entityType) {

        int[][] numberField = EntityLandform.getNumberField(cells, entityType);

        int[][] resultField = numberField.clone();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 && j == 0) {
                    resultField[i][j] = 0;
                    continue;
                }
                if (i == 0) {
                    resultField[i][j] = resultField[i][j] + resultField[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    resultField[i][j] = resultField[i][j] + resultField[i - 1][j];
                    continue;
                }
                if (resultField[i][j - 1] < resultField[i - 1][j]) {
                    resultField[i][j] = resultField[i][j] + resultField[i][j - 1];
                } else {
                    resultField[i][j] = resultField[i][j] + resultField[i - 1][j];
                }
            }
        }
        return resultField[3][3];
    }
}
