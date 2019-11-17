package org.wahlzeit.model;

/**
 * Represents a 3D spheric Coordinate.
 */
public class SphericCoordinate implements Coordinate {
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

        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        if (coordinate == null) {
            throw new NullPointerException("Parameter 'coordinate' was null inside method 'getCentralAngle'.");
        }

        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        double delta = Math.abs(phi - sphericCoordinate.phi);
        return Math.acos(Math.sin(theta) * Math.sin(sphericCoordinate.theta) + Math.cos(theta) * Math.cos(sphericCoordinate.theta) * Math.cos(delta));
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
     * Checks for equality.
     *
     * @param object Object.
     * @return true, if the object has the same values,
     * false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SphericCoordinate)) {
            return false;
        }

        return isEqual((SphericCoordinate) object);
    }
}
