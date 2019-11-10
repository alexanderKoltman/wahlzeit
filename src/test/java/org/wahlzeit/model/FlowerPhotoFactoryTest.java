package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link FlowerPhotoFactory}.
 */
public class FlowerPhotoFactoryTest {

    @Test
    public void testGetInstance() {
        final FlowerPhotoFactory flowerPhotoFactory = FlowerPhotoFactory.getInstance();

        assertNotNull(flowerPhotoFactory);
    }

    @Test(expected = IllegalStateException.class)
    public void testSetInstanceShouldThrowException() {
        FlowerPhotoFactory.setInstance(new FlowerPhotoFactory());
        FlowerPhotoFactory.setInstance(new FlowerPhotoFactory());
    }

    @Test
    public void testCreatePhoto(){
        final FlowerPhotoFactory flowerPhotoFactory = new FlowerPhotoFactory();
        final FlowerPhoto flowerPhoto = flowerPhotoFactory.createPhoto();

        assertNotNull(flowerPhoto);
    }

    @Test
    public void testCreatePhotoWithPhotoId(){
        final FlowerPhotoFactory flowerPhotoFactory = new FlowerPhotoFactory();
        final FlowerPhoto flowerPhoto = flowerPhotoFactory.createPhoto(new PhotoId(1234));

        assertNotNull(flowerPhoto);
    }
}
