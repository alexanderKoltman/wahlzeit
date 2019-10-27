package org.wahlzeit.model;

/**
 * Represents a Location.
 */
public class Location {
    /**
     * Coordinate of the Location.
     */
    public Coordinate coordinate;

    /**
     * Creates a new Location with its corresponding coordinate.
     */
    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
