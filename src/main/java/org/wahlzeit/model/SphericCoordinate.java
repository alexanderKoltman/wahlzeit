package org.wahlzeit.model;

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

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double phi, double theta, double radius) {
        checkPhi(phi);
        checkTheta(theta);
        checkRadius(radius);

        this.phi = phi;
        this.theta = theta;
        this.radius = radius;

        assertClassInvariants();
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

        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
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
    protected void assertClassInvariants() {
        assert Double.isFinite(phi) && phi < 2 * Math.PI && phi >= 0.0;
        assert Double.isFinite(theta) && theta <= Math.PI && theta >= 0.0;
        assert Double.isFinite(radius) && radius >= 0;
    }
}
