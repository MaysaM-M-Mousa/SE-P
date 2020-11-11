package SearchFeature;

import MainClasess.Home;
import io.cucumber.java.bs.A;

import java.util.ArrayList;

public class SearchByAmenities implements SearchInterface{

    String amenity;
    ArrayList<Home> byAmenities;

    public SearchByAmenities(String amenity) {
        this.amenity = amenity;
        byAmenities= new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {
        for (Home home : HomeList)
            for (String x : home.getAmenities())
                if (x.equals(amenity))
                    byAmenities.add(home);

        return byAmenities;
    }
}
