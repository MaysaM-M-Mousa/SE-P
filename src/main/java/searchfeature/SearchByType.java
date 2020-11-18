package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchByType implements SearchInterface {

    String type;
    ArrayList<Home> byType;

    public SearchByType(String type) {
        this.type = type;
        byType = new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {

        for (Home home : homeList)
            if (home.getType().equals(type))
                byType.add(home);

        return byType;
    }
}
