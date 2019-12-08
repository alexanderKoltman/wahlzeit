package org.wahlzeit.model;

/**
 * Represents an abstract 3D Coordinate.
 */
public abstract class AbstractCoordinate implements Coordinate {

    /**
     * @methodtype get
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) throws NullPointerException {
        return asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    /**
     * @methodtype get
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) throws NullPointerException {
        return asSphericCoordinate().getCentralAngle(coordinate);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return (CartesianCoordinate) this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return (SphericCoordinate) this;
    }

    /**
     * Checks for equality.
     *
     * @param object Object.
     * @return true, if the object has the same values,
     * false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CartesianCoordinate) && !(object instanceof SphericCoordinate)) {
            return false;
        } else {
            return isEqual((Coordinate) object);
        }
    }
}
