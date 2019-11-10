package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link FlowerPhoto}.
 */
public class FlowerPhotoTest {

    @Test
    public void testConstructor() {
        final FlowerPhoto flowerPhoto = new FlowerPhoto("Anemone", "Europe");

        assertEquals(flowerPhoto.getFlowerName(), "Anemone");
        assertEquals(flowerPhoto.getFlowerOrigin(), "Europe");
    }
}
