package org.wahlzeit.model;


/**
 * A photo manager provides access to and manages photos.
 */
public class FlowerPhotoManager extends PhotoManager {

    protected static final PhotoManager instance = new PhotoManager();
    /**
     * @methodtype constructor
     */
    public FlowerPhotoManager() {
        super();
    }
}
