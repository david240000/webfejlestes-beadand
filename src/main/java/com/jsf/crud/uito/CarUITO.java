/**
 *
 */
package com.jsf.crud.uito;

import java.io.Serializable;

/**
 * @author s727953
 *
 */
public class CarUITO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4840260415183676656L;
    private Long id;
    private String brand;
    private String type;
    private String color;
    private String licensePlate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "CarUITO [id=" + id + ", brand=" + brand + ", type=" + type + ", color="
                + color + ", licensePlate=" + licensePlate  + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarUITO other = (CarUITO) obj;
        if (brand == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
