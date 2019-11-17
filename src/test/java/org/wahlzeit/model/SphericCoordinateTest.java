package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link SphericCoordinate}.
 */
public class SphericCoordinateTest {
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
        cartesianCoordinateOne = new CartesianCoordinate(0.0, 0.0, 0.0);
        cartesianCoordinateTwo = new CartesianCoordinate(1.0, 1.0, 1.0);

        sphericCoordinateOne = new SphericCoordinate(0.0, 0.0, 0.0);
        sphericCoordinateTwo = new SphericCoordinate(1.0, 1.0, 1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowExceptionWhenPhiIsNegative() {
        new SphericCoordinate(-1, 0.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowExceptionWhenPhiIsBiggerThan_2_MULT_PI() {
        new SphericCoordinate(100, 0.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowExceptionWhenThetaIsNegative() {
        new SphericCoordinate(1.0, -1, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowExceptionWhenThetaIsBiggerThanPI() {
        new SphericCoordinate(1.0, 100, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowExceptionWhenRadiusIsNegative() {
        new SphericCoordinate(1, 1, -1);
    }

    @Test
    public void testAsSphericCoordinate() {
        assertSame(sphericCoordinateOne, sphericCoordinateOne.asSphericCoordinate());
        assertNotSame(sphericCoordinateOne, cartesianCoordinateOne.asSphericCoordinate());
    }

    @Test
    public void testAsCartesianCoordinate() {
        assertEquals(0.0, sphericCoordinateOne.getCartesianDistance(cartesianCoordinateOne), EPSILON);
        assertEquals(0.7706822463836158, sphericCoordinateTwo.getCartesianDistance(cartesianCoordinateTwo), EPSILON);
        assertEquals(1.7320508075688772, sphericCoordinateOne.getCartesianDistance(cartesianCoordinateTwo), EPSILON);
    }

    @Test
    public void testGetCentralAngle(){
        assertEquals(0.0, sphericCoordinateOne.getCentralAngle(cartesianCoordinateOne), EPSILON);
        assertEquals(0.12778759501273776, sphericCoordinateTwo.getCentralAngle(cartesianCoordinateTwo), EPSILON);
    }

    @Test(expected = NullPointerException.class)
    public void testGetCentralAngleShouldThrowExceptionForNullParameter() {
        sphericCoordinateOne.getCentralAngle(null);
    }

    @Test
    public void testIsEqual() {
        assertTrue(sphericCoordinateOne.isEqual(sphericCoordinateOne));
        assertFalse(sphericCoordinateOne.isEqual(sphericCoordinateTwo));
    }

    @Test
    public void testEquals() {
        assertEquals(sphericCoordinateOne, sphericCoordinateOne);
        assertNotEquals(sphericCoordinateOne, null);
        assertNotEquals(sphericCoordinateOne, sphericCoordinateTwo);
    }
}
