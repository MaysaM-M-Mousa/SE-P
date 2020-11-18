package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchByPlacement implements SearchInterface {

    ArrayList<Home> byPlacement;
    String placement;

    public SearchByPlacement(String condition) {
        this.placement = condition;
        byPlacement = new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {

        for (Home home : homeList)
            if (home.getPlacement().equals(placement)) {
                byPlacement.add(home);
            }
        return byPlacement;
    }
}
