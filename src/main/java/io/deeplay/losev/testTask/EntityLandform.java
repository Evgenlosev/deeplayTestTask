package io.deeplay.losev.testTask;

import java.util.HashMap;
import java.util.Map;

public class EntityLandform {

    private static final Map<Character, Integer> HUMAN = Map.of('S', 5, 'W', 2, 'T', 3, 'P', 1);
    private static final Map<Character, Integer> SWAMPER = Map.of('S', 2, 'W', 2, 'T', 5, 'P', 2);
    private static final Map<Character, Integer> WOODMAN = Map.of('S', 3, 'W', 3, 'T', 2, 'P', 2);

    private static Map<Character, Integer> getMapByString (String entityType){
        if (entityType.equalsIgnoreCase("HUMAN")) {
            return HUMAN;
        }
        if (entityType.equalsIgnoreCase("SWAMPER")) {
            return SWAMPER;
        }
        if (entityType.equalsIgnoreCase("WOODMAN")) {
            return WOODMAN;
        }
        throw new RuntimeException("Не верно указан вид существа");
    }

    public static int[][] getNumberField (String cells, String entityType) {
        if (cells.length() != 16) {
            throw new RuntimeException("Неверное количество символов для игрового поля");
        }
        Map<Character, Integer> entityMap = getMapByString(entityType);
        char[] field = cells.toCharArray();
        int[][] numberField = new int[4][4];
        try {
            int index = 0;
            for (int i = 0; i < 4; i ++) {
                for (int j = 0; j < 4; j++) {
                    numberField[i][j] = entityMap.get(field[index]);
                    index++;
                }
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Неверный ввод символов для игрового поля");
        }
        return numberField;
    }

}
