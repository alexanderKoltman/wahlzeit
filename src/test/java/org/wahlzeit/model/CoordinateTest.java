package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 * Test class for {@link Coordinate}.
 */
public class CoordinateTest {

    private Coordinate coordinateOne;
    private Coordinate coordinateTwo;

    @Before
    public void init() {
        coordinateOne = new Coordinate(0, 0, 0);
        coordinateTwo = new Coordinate(1, 1, 1);
    }

    @Test
    public void testGetDistance() {
        assertEquals(1.7320508075688772, coordinateOne.getDistance(coordinateTwo));
        assertEquals(0.0, coordinateOne.getDistance(coordinateOne));
        assertEquals(0.0, coordinateTwo.getDistance(coordinateTwo));
    }

    @Test(expected = NullPointerException.class)
    public void getDistanceShouldThrowExceptionForNullParameter() {
        coordinateOne.getDistance(null);
    }

    @Test
    public void testIsEqual() {
        assertFalse(coordinateOne.isEqual(null));
        assertFalse(coordinateOne.isEqual(coordinateTwo));
        assertTrue(coordinateOne.isEqual(coordinateOne));
    }

    @Test
    public void testEquals() {
        assertEquals(coordinateOne, coordinateOne);
        assertEquals(coordinateOne, new Coordinate(0, 0, 0));
        assertNotEquals(null, coordinateOne);
        assertNotEquals(coordinateOne, coordinateTwo);
        assertNotEquals(coordinateOne, new Object());
    }
}
