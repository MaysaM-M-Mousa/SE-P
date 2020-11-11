package SearchFeature;

import MainClasess.Home;

import java.util.ArrayList;

public class SearchByInBetweenArea implements SearchInterface {

    Integer less;
    Integer more;
    ArrayList<Home> byInBetweenArea;

    public SearchByInBetweenArea(Integer less, Integer more) {
        this.less = less;
        this.more = more;
        byInBetweenArea = new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {

        for (Home home : HomeList) {
            if (home.getArea() < less && home.getArea() > more)
                byInBetweenArea.add(home);
        }
        return byInBetweenArea;
    }
}
