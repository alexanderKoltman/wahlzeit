package org.wahlzeit.model;

/**
 * Represents a 3D Coordinate.
 */
public interface Coordinate {
    /**
     * Describes the allowed difference between the difference of two floating-point numbers.
     */
    double EPSILON = 10E-5;

    /**
     * @methodtype conversion
     */
    CartesianCoordinate asCartesianCoordinate() throws IllegalArgumentException;

    /**
     * @methodtype conversion
     */
    SphericCoordinate asSphericCoordinate() throws IllegalArgumentException;

    /**
     * @methodtype get
     */
    double getCartesianDistance(Coordinate coordinate) throws NullPointerException;

    /**
     * @methodtype get
     */
    double getCentralAngle(Coordinate coordinate) throws NullPointerException;

    /**
     * @methodtype boolean-query
     */
    boolean isEqual(Coordinate coordinate);
}
