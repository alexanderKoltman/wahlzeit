package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Location}.
 */
public class LocationTest {

    @Test
    public void testConstructor() {
        Location location = new Location(new Coordinate(4, 3, 2));
        assertEquals(location.coordinate, new Coordinate(4, 3, 2));
    }
}
