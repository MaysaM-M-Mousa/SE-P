package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchByBedrooms implements SearchInterface {

    Integer bedrooms;
    ArrayList<Home> byBedrooms;

    public SearchByBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
        byBedrooms = new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {
        for (Home home : homeList)
            if (home.getBedrooms() == (int)bedrooms)
                byBedrooms.add(home);

        return byBedrooms;
    }
}
