package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchByInBetweenArea implements SearchInterface {

    Integer less;
    Integer more;
    ArrayList<Home> byInBetweenArea;

    public SearchByInBetweenArea(Integer less, Integer more) {
        this.less = less;
        this.more = more;
        byInBetweenArea = new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {

        for (Home home : homeList) {
            if (home.getArea() < less && home.getArea() > more)
                byInBetweenArea.add(home);
        }
        return byInBetweenArea;
    }
}
