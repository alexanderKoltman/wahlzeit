package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Objects;

/**
 * Represents a 3D cartesian Coordinate.
 */
public class CartesianCoordinate extends AbstractCoordinate {
    /**
     * Cartesian coordinates.
     */
    private final double x;
    private final double y;
    private final double z;

    // manages instances of shared value objects
    private static final HashMap<Integer, CartesianCoordinate> mapOfCartesianCoordinates = new HashMap<>();

    /**
     * Creates a new 3D Coordinate with its corresponding coordinates x, y, z.
     *
     * @methodtype constructor
     */
    private CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException {
        this.x = x;
        this.y = y;
        this.z = z;

        try {
            assertClassInvariants();
        } catch (AssertionError error) {
            throw new IllegalArgumentException("Parameters (x|y|z) must be floating-point values.");
        }
    }

    /**
     * @methodtype factory
     */
    public static CartesianCoordinate create(double x, double y, double z) {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
        Integer key = cartesianCoordinate.hashCode();

        CartesianCoordinate result = mapOfCartesianCoordinates.get(key);
        if (result == null) {
            synchronized (CartesianCoordinate.class) {
                mapOfCartesianCoordinates.putIfAbsent(key, cartesianCoordinate);
                result = cartesianCoordinate;
            }
        }

        return result;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        double phi = 0;
        double theta = 0;
        double radius = Math.sqrt(x * x + y * y + z * z);

        if (x != 0) {
            phi = Math.atan2(y, x);
        }

        if (radius != 0) {
            theta = Math.acos(z / radius);
        }

        return SphericCoordinate.create(phi, theta, radius);
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) throws NullPointerException {
        if (coordinate == null) {
            throw new NullPointerException("Parameter 'coordinate' was null inside method 'getCartesianDistance'.");
        }

        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        double result = Math.sqrt(Math.pow(x - cartesianCoordinate.x, 2) + Math.pow(y - cartesianCoordinate.y, 2) + Math.pow(z - cartesianCoordinate.z, 2));

        assert Double.isFinite(result) && result >= 0;
        return result;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        if (coordinate == null) {
            return false;
        }

        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        return Math.abs(x - cartesianCoordinate.x) < EPSILON && Math.abs(y - cartesianCoordinate.y) < EPSILON && Math.abs(z - cartesianCoordinate.z) < EPSILON;
    }

    /**
     * @methodtype assert
     */
    private void assertClassInvariants() throws AssertionError {
        assert Double.isFinite(x);
        assert Double.isFinite(y);
        assert Double.isFinite(z);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
