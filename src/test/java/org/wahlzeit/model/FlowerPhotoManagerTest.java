package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link FlowerPhotoManager}.
 */
public class FlowerPhotoManagerTest {

    @Test
    public void testGetInstance() {
        final PhotoManager photoManager = FlowerPhotoManager.getInstance();

        assertNotNull(photoManager);
    }
}
