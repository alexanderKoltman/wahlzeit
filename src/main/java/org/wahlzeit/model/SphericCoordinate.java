package org.wahlzeit.model;

import java.util.HashMap;

/**
 * Represents a 3D spheric Coordinate.
 */
public class SphericCoordinate extends AbstractCoordinate {
    /**
     * Spheric coordinates.
     */
    private final double phi;
    private final double theta;
    private final double radius;

    // manages instances of shared value objects
    private static final HashMap<Integer, SphericCoordinate> mapOfSphericCoordinates = new HashMap<>();

    /**
     * @param phi    must be in the range [phi < 2 * Math.PI && phi >= 0.0]
     * @param theta  must be in the range [theta <= Math.PI && theta >= 0.0]
     * @param radius must bigger or equal zero
     * @methodtype constructor
     */
    private SphericCoordinate(double phi, double theta, double radius) throws IllegalArgumentException {
        checkPhi(phi);
        checkTheta(theta);
        checkRadius(radius);

        this.phi = phi;
        this.theta = theta;
        this.radius = radius;

        try {
            assertClassInvariants();
        } catch (AssertionError error) {
            throw new IllegalArgumentException("Parameters (x|y|z) must be floating-point values and in a valid range.");
        }
    }

    /**
     * @methodtype factory
     */
    public static SphericCoordinate create(double phi, double theta, double radius) {
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, theta, radius);
        Integer key = sphericCoordinate.hashCode();

        SphericCoordinate result = mapOfSphericCoordinates.get(key);
        if (result == null) {
            synchronized (SphericCoordinate.class) {
                mapOfSphericCoordinates.putIfAbsent(key, sphericCoordinate);
                result = sphericCoordinate;
            }
        }

        return result;
    }

    /**
     * @methodtype assert
     */
    private void checkPhi(double phi) {
        if (phi >= 2 * Math.PI || phi < 0.0) {
            throw new IllegalArgumentException("Theta must be >= 0 and < 2*PI");
        }
    }

    /**
     * @methodtype assert
     */
    private void checkTheta(double theta) {
        if (theta > Math.PI || theta < 0.0) {
            throw new IllegalArgumentException("Theta must be >= 0 and <= PI");
        }
    }

    /**
     * @methodtype assert
     */
    private void checkRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be >= 0.0");
        }
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);

        assert Double.isFinite(x);
        assert Double.isFinite(y);
        assert Double.isFinite(z);

        return CartesianCoordinate.create(x, y, z);
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) throws NullPointerException {
        if (coordinate == null) {
            throw new NullPointerException("Parameter 'coordinate' was null inside method 'getCentralAngle'.");
        }

        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        double delta = Math.abs(phi - sphericCoordinate.phi);
        double result = Math.acos(Math.sin(theta) * Math.sin(sphericCoordinate.theta) + Math.cos(theta) * Math.cos(sphericCoordinate.theta) * Math.cos(delta));
        assert Double.isFinite(result);

        return result;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        if (coordinate == null) {
            return false;
        }

        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        return Math.abs(phi - sphericCoordinate.phi) < EPSILON && Math.abs(theta - sphericCoordinate.theta) < EPSILON && Math.abs(radius - sphericCoordinate.radius) < EPSILON;
    }

    /**
     * @methodtype assert
     */
    private void assertClassInvariants() throws AssertionError {
        assert Double.isFinite(phi) && phi < 2 * Math.PI && phi >= 0.0;
        assert Double.isFinite(theta) && theta <= Math.PI && theta >= 0.0;
        assert Double.isFinite(radius) && radius >= 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(phi);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(theta);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
