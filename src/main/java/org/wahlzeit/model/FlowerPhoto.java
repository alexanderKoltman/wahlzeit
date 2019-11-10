package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

/**
 * Represents a photo of a flower.
 */
@Entity
public class FlowerPhoto extends Photo {

    private String flowerName;
    private String flowerOrigin;

    /**
     * @methodtype constructor
     */
    public FlowerPhoto() {
        super();
    }

    /**
     * @methodtype constructor
     */
    public FlowerPhoto(PhotoId myId) {
        super(myId);
    }

    /**
     * @methodtype constructor
     */
    public FlowerPhoto(String flowerName, String flowerOrigin) {
        super();
        this.flowerName = flowerName;
        this.flowerOrigin = flowerOrigin;
    }

    /**
     * @methodtype get
     */
    public String getFlowerName() {
        return flowerName;
    }

    /**
     * @methodtype set
     */
    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    /**
     * @methodtype get
     */
    public String getFlowerOrigin() {
        return flowerOrigin;
    }

    /**
     * @methodtype set
     */
    public void setFlowerOrigin(String flowerOrigin) {
        this.flowerOrigin = flowerOrigin;
    }
}
