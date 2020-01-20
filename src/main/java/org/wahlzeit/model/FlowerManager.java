package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FlowerManager extends ObjectManager {

    protected static final FlowerManager instance = new FlowerManager();
    protected Map<String, FlowerType> flowerTypes = new HashMap<>();
    protected HashSet<Flower> flowers = new HashSet<>();

    public static FlowerManager getInstance() {
        return instance;
    }

    /**
     * @methodtype factory
     */
    public Flower createFlower(String typeName) {
        FlowerType flowerType = getFlowerType(typeName);
        assert (flowerType != null) : "invalid FlowerType name";

        Flower flower = flowerType.createInstance();
        flowers.add(flower);
        return flower;
    }

    public FlowerType getFlowerType(String typeName) {
        assertIsValidTypeName(typeName);

        if (!flowerTypes.containsKey(typeName)) {
            FlowerType flowerType = new FlowerType(typeName);
            flowerTypes.put(typeName, flowerType);
            return flowerType;
        }

        return flowerTypes.get(typeName);
    }

    /**
     * @methodtype assertion
     */
    private void assertIsValidTypeName(String typeName) {
        if (typeName == null) {
            throw new IllegalArgumentException("'typeName' must not be null.");
        }
    }
}
