package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchByBathrooms implements SearchInterface{
    Integer bathrooms;
    ArrayList<Home> byBathrooms;

    public SearchByBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
        byBathrooms=new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {
        for (Home home : homeList)
            if (home.getBathrooms() == (int)bathrooms)
                byBathrooms.add(home);

        return byBathrooms;
    }
}
