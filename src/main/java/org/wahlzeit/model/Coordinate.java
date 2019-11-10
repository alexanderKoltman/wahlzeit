package org.wahlzeit.model;

/**
 * Represents a 3D Coordinate.
 */
public class Coordinate {
    /**
     * Cartesian coordinates.
     */
    private final double x;
    private final double y;
    private final double z;

    /**
     * Describes the allowed difference between the difference of two floating-point numbers.
     */
    private static final double EPSILON = 10E-5;

    /**
     * Creates a new 3D Coordinate with its corresponding coordinates x, y, z.
     */
    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Calculating cartesian distance.
     *
     * @param coordinate 3D Coordinate.
     * @return Cartesian distance.
     * @throws NullPointerException on input error.
     * @see NullPointerException
     */
    public double getDistance(Coordinate coordinate) {
        if (coordinate == null) {
            throw new NullPointerException("Parameter 'coordinate' was null inside method 'getDistance'.");
        }

        return Math.sqrt(Math.pow(x - coordinate.x, 2) + Math.pow(y - coordinate.y, 2) + Math.pow(z - coordinate.z, 2));
    }

    /**
     * Compares the coordinates for equality.
     *
     * @param coordinate 3D Coordinate
     * @return true, if the coordinates have the same values,
     * false otherwise.
     */
    public boolean isEqual(Coordinate coordinate) {
        if (coordinate == null) {
            return false;
        }

        return Math.abs(x - coordinate.x) < EPSILON && Math.abs(y - coordinate.y) < EPSILON && Math.abs(z - coordinate.z) < EPSILON;
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
        if (getClass() != object.getClass()) {
            return false;
        }

        return isEqual((Coordinate) object);
    }
}
