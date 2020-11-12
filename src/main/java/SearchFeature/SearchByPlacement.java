package SearchFeature;

import MainClasess.Home;

import java.util.ArrayList;

public class SearchByPlacement implements SearchInterface {

    ArrayList<Home> byPlacement;
    String placement;

    public SearchByPlacement(String condition) {
        this.placement = condition;
        byPlacement = new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {

        for (Home home : HomeList)
            if (home.getPlacement().equals(placement)) {
                byPlacement.add(home);
            }
        return byPlacement;
    }
}
