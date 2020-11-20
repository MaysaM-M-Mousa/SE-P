package mainclasses;

public class Home {
    private String id;
    private String type;
    private String material;
    private String placement;
    private String[] amenities;
    private Integer price;
    private Integer area;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer leaseLength;

    private Boolean pets;



    public String getID() {
        return id;
    }
    public void setID(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPlacement() {
        return placement;
    }
    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String[] getAmenities() {
        return amenities;
    }
    public void setAmenities(String[] amenities) {
        this.amenities = amenities;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getArea() {
        return area;
    }
    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }
    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }
    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getLeaseLength() {
        return leaseLength;
    }
    public void setLeaseLength(Integer leaseLength) {
        this.leaseLength = leaseLength;
    }

    public Boolean getPets() {
        return pets;
    }
    public void setPets(Boolean pets) {
        this.pets = pets;
    }

    public String toString() {
        StringBuilder resultAmenities = new StringBuilder();
        for (String temp : this.amenities) {
            resultAmenities.append(temp).append(",");
        }
        return "Home Type: " + this.getType() + ", Home Placement: " + this.getPlacement() +
                ", Home Price: " + this.getPrice() + ", Amenities: (" + resultAmenities.substring(0, resultAmenities.length() - 1) +
                "), Bedrooms: " + this.getBedrooms() + ",Bathrooms: " + this.getBathrooms() + ", Pets: " + this.getPets() +
                "lease Length"+ this.getLeaseLength();
    }


}
