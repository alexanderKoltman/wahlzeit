package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Location}.
 */
public class LocationTest {

    @Test
    public void testConstructor() {
        Location location = new Location(new CartesianCoordinate(4, 3, 2));
        assertEquals(location.coordinate, new CartesianCoordinate(4, 3, 2));
    }
}
