package SearchFeature;

import MainClasess.Home;

import java.util.ArrayList;

public class SearchByType implements SearchInterface {

    String type;
    ArrayList<Home> byType;

    public SearchByType(String type) {
        this.type = type;
        byType = new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {

        for (Home home : HomeList)
            if (home.getType().equals(type))
                byType.add(home);

        return byType;
    }
}
