package SearchFeature;

import MainClasess.Home;
import io.cucumber.java.bs.A;

import java.util.ArrayList;

public class SearchByBathrooms implements SearchInterface{
    Integer bathrooms;
    ArrayList<Home> byBathrooms;

    public SearchByBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
        byBathrooms=new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {
        for (Home home : HomeList)
            if (home.getBathrooms() == bathrooms)
                byBathrooms.add(home);

        return byBathrooms;
    }
}
