package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link CartesianCoordinate}.
 */
public class CartesianCoordinateTest {
    /**
     * Describes the allowed difference between the difference of two floating-point numbers.
     */
    private static final double EPSILON = 10E-5;

    private CartesianCoordinate cartesianCoordinateOne;
    private CartesianCoordinate cartesianCoordinateTwo;

    private SphericCoordinate sphericCoordinateOne;
    private SphericCoordinate sphericCoordinateTwo;

    @Before
    public void init() {
        cartesianCoordinateOne = CartesianCoordinate.create(0.0, 0.0, 0.0);
        cartesianCoordinateTwo = CartesianCoordinate.create(1.0, 1.0, 1.0);

        sphericCoordinateOne = SphericCoordinate.create(0.0, 0.0, 0.0);
        sphericCoordinateTwo = SphericCoordinate.create(1.0, 1.0, 1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowExceptionWhenArgumentIsNotAFloatingValue() {
        CartesianCoordinate.create(Double.NaN, 0.0, 0.0);
    }

    @Test
    public void testAsCartesianCoordinate() {
        assertSame(cartesianCoordinateOne, cartesianCoordinateOne.asCartesianCoordinate());
        assertSame(cartesianCoordinateOne, sphericCoordinateOne.asCartesianCoordinate());
        assertNotSame(cartesianCoordinateOne, sphericCoordinateTwo.asCartesianCoordinate());
    }

    @Test
    public void testAsSphericCoordinate() {
        assertEquals(cartesianCoordinateOne.asSphericCoordinate(), sphericCoordinateOne);
        assertNotEquals(cartesianCoordinateOne.asSphericCoordinate(), sphericCoordinateTwo);
    }

    @Test
    public void testGetCartesianDistance() {
        assertEquals(0.0, cartesianCoordinateOne.getCartesianDistance(cartesianCoordinateOne), EPSILON);
        assertEquals(0.0, cartesianCoordinateTwo.getCartesianDistance(cartesianCoordinateTwo), EPSILON);
        assertEquals(1.7320508075688772, cartesianCoordinateOne.getCartesianDistance(cartesianCoordinateTwo), EPSILON);
    }

    @Test(expected = NullPointerException.class)
    public void testGetCartesianDistanceShouldThrowExceptionForNullParameter() {
        cartesianCoordinateOne.getCartesianDistance(null);
    }

    @Test
    public void testGetCentralAngle(){
        assertEquals(0.0, cartesianCoordinateOne.getCentralAngle(sphericCoordinateOne), EPSILON);
        assertEquals(0.12778759501273776, cartesianCoordinateTwo.getCentralAngle(sphericCoordinateTwo), EPSILON);
    }

    @Test
    public void testIsEqual() {
        assertTrue(cartesianCoordinateOne.isEqual(cartesianCoordinateOne));
        assertFalse(cartesianCoordinateOne.isEqual(cartesianCoordinateTwo));
    }

    @Test
    public void testEquals() {
        assertEquals(cartesianCoordinateOne, cartesianCoordinateOne);
        assertNotEquals(cartesianCoordinateOne, null);
        assertNotEquals(cartesianCoordinateOne, cartesianCoordinateTwo);
    }
}
