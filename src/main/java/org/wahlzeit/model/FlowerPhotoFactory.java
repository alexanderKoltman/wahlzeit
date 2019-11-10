package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

/**
 * A Factory for creating flower photos and related objects.
 */
public class FlowerPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(FlowerPhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static FlowerPhotoFactory instance = null;

    /**
     * @methodtype constructor
     */
    protected FlowerPhotoFactory() {
        super();
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    /**
     * Public singleton access method.
     */
    public static synchronized FlowerPhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic FlowerPhotoFactory").toString());
            setInstance(new FlowerPhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of FlowerPhotoFactory.
     */
    protected static synchronized void setInstance(FlowerPhotoFactory flowerPhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize FlowerPhotoFactory twice");
        }

        instance = flowerPhotoFactory;
    }

    /**
     * @methodtype factory
     */
    @Override
    public FlowerPhoto createPhoto() {
        return new FlowerPhoto();
    }

    /**
     * @methodtype factory
     */
    @Override
    public FlowerPhoto createPhoto(PhotoId id) {
        return new FlowerPhoto(id);
    }
}
