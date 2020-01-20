package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link FlowerType}.
 */
public class FlowerTypeTest {

    @Test
    public void testConstructor() {
        final FlowerType flowerType = new FlowerType("Simple Flower");

        assertEquals(flowerType.getFlowerType(), "Simple Flower");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidFlowerName() {
        final FlowerType flowerType = new FlowerType(null);
    }
}
