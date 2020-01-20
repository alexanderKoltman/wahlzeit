package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class FlowerType extends DataObject {

    private String flowerType;

    protected FlowerType superType = null;
    protected Set<FlowerType> subTypes = new HashSet<>();

    /**
     * @methodtype constructor
     */
    public FlowerType() {
    }

    /**
     * @param flowerType the name of the flower type
     * @methodtype constructor
     */
    public FlowerType(String flowerType) {
        assertIsValidFlowerType(flowerType);
        this.flowerType = flowerType;
    }

    /**
     * @methodtype get
     */
    public String getFlowerType() {
        return flowerType;
    }

    /**
     * @methodtype get
     */
    public FlowerType getSuperType() {
        return superType;
    }

    /**
     * @methodtype get
     */
    public Iterator<FlowerType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    /**
     * @methodtype factory
     */
    public Flower createInstance() {
        return new Flower(this);
    }

    /**
     * @methodtype factory
     */
    public void addSubType(FlowerType flowerType) {
        assert (flowerType != null) : "tried to set null sub - type";
        flowerType.setSuperType(this);
        subTypes.add(flowerType);
    }

    /**
     * @methodtype set
     */
    private void setSuperType(FlowerType flowerType) {
        this.superType = flowerType;
    }

    /**
     * @methodtype query
     */
    public boolean hasInstance(Flower flower) {
        assert (flower != null) : "asked about null object";
        if (flower.getFlowerType() == this) {
            return true;
        }
        for (FlowerType type : subTypes) {
            if (type.hasInstance(flower)) {
                return true;
            }
        }
        return false;
    }


    public boolean isSubtype() {
        return false;
    }

    /**
     * @methodtype assertion
     */
    private void assertIsValidFlowerType(String flowerType) {
        if (flowerType == null || flowerType.isEmpty()) {
            throw new IllegalArgumentException("'FlowerType' must not be null or empty.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlowerType that = (FlowerType) o;

        return Objects.equals(flowerType, that.flowerType);
    }

    @Override
    public int hashCode() {
        return flowerType != null ? flowerType.hashCode() : 0;
    }
}
