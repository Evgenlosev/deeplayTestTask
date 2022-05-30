package io.deeplay.losev.testTask;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    private String type;
    private Map<Character, Integer> entityLandform;

    public Entity(String type) {
        this.type = type;
        this.entityLandform = new HashMap<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<Character, Integer> getEntityLandform() {
        return entityLandform;
    }

    public void setEntityLandform(Map<Character, Integer> entityLandform) {
        this.entityLandform = entityLandform;
    }
}
