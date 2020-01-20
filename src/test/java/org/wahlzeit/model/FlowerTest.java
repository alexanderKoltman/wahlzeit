package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Flower}.
 */
public class FlowerTest {

    @Test
    public void testConstructor() {
        final FlowerType flowerType = new FlowerType("Simple Flower");
        final Flower flower = new Flower(flowerType, "Anemone");

        assertEquals(flower.getFlowerName(), "Anemone");
        assertEquals(flower.getFlowerType(), flowerType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidFlowerName() {
        final FlowerType flowerType = new FlowerType("Simple Flower");
        final Flower flower = new Flower(flowerType, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidFlowerType() {
        final Flower flower = new Flower(null, "Anemone");
    }
}
