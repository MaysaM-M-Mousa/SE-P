public class Home {
    private String type;
    private String material;
    private String placement;
    private String [] amenities;

    private Integer price;
    private Integer area;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer leaseLength;

    private Boolean pets;

    public Home(){
    }

    public Home(String type, String material, String placement, String[] amenities, Integer price,
                Integer area, Integer bedrooms, Integer bathrooms, Integer leaseLength, Boolean pets) {
        this.type = type;
        this.material = material;
        this.placement = placement;
        this.amenities = amenities;
        this.price = price;
        this.area = area;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.leaseLength = leaseLength;
        this.pets = pets;
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
}
