package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.util.Objects;

/**
 * Sequence of method calls that lead to the new object:
 * - by Flower with the method Flower()/Flower(FlowerType flowerType)/Flower(FlowerType flowerType, String flowerName)
 * - by FlowerManager with the method createFlower(String typeName) call
 * - by FlowerType with the method createInstance() call
 *
 * Object creation solution as point in the solution space:
 * - Delegation of object creation -> by delegating to a separate-object
 * - Selection of Concrete class -> On-the-spot
 * - Configuration of Class Mapping -> N/A
 * - Instantiation of Concrete Class -> In-code
 * - Initialization of New Object -> Default
 * - Building of Object Structure -> Default
 */

/**
 * Binds the base object role in the collaboration (base object - type object collaboration) of {@link Flower} and {@link  FlowerType}.
 * Binds the element role in the collaboration (manager element collaboration) of {@link FlowerManager} and {@link Flower}.
 * Binds the service role in the collaboration (client service collaboration) of {@link FlowerPhoto} and {@link Flower}.
 */
public class Flower extends DataObject {

    private FlowerType flowerType;
    private String flowerName;

    /**
     * @methodtype constructor
     */
    public Flower() {
    }

    /**
     * @methodtype constructor
     */
    public Flower(FlowerType flowerType) {
        assertIsValidFlowerType(flowerType);
        this.flowerType = flowerType;
    }

    /**
     * @methodtype constructor
     */
    public Flower(FlowerType flowerType, String flowerName) {
        assertIsValidFlowerType(flowerType);
        assertIsValidFlowerName(flowerName);

        this.flowerType = flowerType;
        this.flowerName = flowerName;
    }

    /**
     * @methodtype get
     */
    public FlowerType getFlowerType() {
        return flowerType;
    }

    /**
     * @methodtype get
     */
    public String getFlowerName() {
        return flowerName;
    }

    /**
     * @methodtype assertion
     */
    private void assertIsValidFlowerType(FlowerType flowerType) {
        if (flowerType == null) {
            throw new IllegalArgumentException("'FlowerType' must not be null.");
        }
    }

    /**
     * @methodtype assertion
     */
    private void assertIsValidFlowerName(String flowerName) {
        if (flowerName == null || flowerName.isEmpty()) {
            throw new IllegalArgumentException("'flowerName' must not be null or empty.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;

        if (!Objects.equals(flowerType, flower.flowerType)) return false;
        return Objects.equals(flowerName, flower.flowerName);
    }

    @Override
    public int hashCode() {
        int result = flowerType != null ? flowerType.hashCode() : 0;
        result = 31 * result + (flowerName != null ? flowerName.hashCode() : 0);
        return result;
    }
}
