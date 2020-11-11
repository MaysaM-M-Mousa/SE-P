package SearchFeature;

import MainClasess.Home;

import java.util.ArrayList;

public class SearchByBedrooms implements SearchInterface {

    Integer bedrooms;
    ArrayList<Home> byBedrooms;

    public SearchByBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
        byBedrooms = new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {
        for (Home home : HomeList)
            if (home.getBedrooms() == (int)bedrooms)
                byBedrooms.add(home);

        return byBedrooms;
    }
}
