package io.deeplay.losev.testTask;

import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        int result = getResult("STWSWTPPTPTTPWPP", "Human");
        System.out.println(result);

    }

    public static int getResult(String cells, String entityType) {
        // Получим числовое игровой поле (т.е. поле на котором вместо типов клеток,
        // будет указана стоимость перемещения по этим клеткам)
        int[][] numberField = EntityLandform.getNumberField(cells, entityType);

        // Для каждой клетки поля посчитаем минимальные затраты на путь до него и запишем результат в поле. Ход будет
        // осуществляться только вниз или вправо, так как для поля 4х4 движение вверх или влево не имеет смысла
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Для верхнего левого поля (начало пути) установим значение 0, поскольку затраты на прохождения этого
                // поля не входят в итоговый результат
                if (i == 0 && j == 0) {
                    numberField[i][j] = 0;
                    continue;
                }
                // До полей из крайней левой колонки мы можем добраться только из верхнего поля
                if (i == 0) {
                    numberField[i][j] = numberField[i][j] + numberField[i][j - 1];
                    continue;
                }
                // До полей из верхней строки мы можем добраться только из левого поля
                if (j == 0) {
                    numberField[i][j] = numberField[i][j] + numberField[i - 1][j];
                    continue;
                }
                // Для остальных полей минимальный затраты определим исходя из значений левого и верхнего полей
                if (numberField[i][j - 1] < numberField[i - 1][j]) {
                    numberField[i][j] = numberField[i][j] + numberField[i][j - 1];
                } else {
                    numberField[i][j] = numberField[i][j] + numberField[i - 1][j];
                }
            }
        }
        // Возвращаем значение правого нижнего поля (конец пути) которое соответствует минимальным затратам на путь до
        // этого поля
        return numberField[3][3];
    }
}
