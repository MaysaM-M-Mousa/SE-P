package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchByAmenities implements SearchInterface{

    String amenity;
    ArrayList<Home> byAmenities;

    public SearchByAmenities(String amenity) {
        this.amenity = amenity;
        byAmenities= new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {
        for (Home home : homeList)
            for (String x : home.getAmenities())
                if (x.equals(amenity))
                    byAmenities.add(home);

        return byAmenities;
    }
}
