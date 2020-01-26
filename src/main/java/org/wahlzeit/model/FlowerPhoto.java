package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

/**
 * Sequence of method calls that lead to the new object:
 * - by FlowerPhotoFactory with the method createPhoto()/createPhoto(PhotoId id) call
 * - by PhotoManager with the method createPhoto(String filename, Image uploadedImage) call
 * - by PhotoUtil with the method createPhoto(String filename, PhotoId id, Image uploadedImage) call
 * - by FlowerPhoto with the method FlowerPhoto()/FlowerPhoto(PhotoId myId)/FlowerPhoto(String flowerName, String flowerOrigin) call
 *
 * Object creation solution as point in the solution space:
 * - Delegation of object creation -> by delegating to a separate-object
 * - Selection of Concrete class -> By-subclassing
 * - Configuration of Class Mapping -> In-code
 * - Instantiation of Concrete Class -> In-code
 * - Initialization of New Object -> Default
 * - Building of Object Structure -> Default
 *
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
