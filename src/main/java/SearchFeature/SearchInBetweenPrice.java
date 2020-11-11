package SearchFeature;

import MainClasess.Home;

import java.util.ArrayList;

public class SearchInBetweenPrice implements SearchInterface{

    Integer less;
    Integer more;
    ArrayList<Home>inBetweenPrice;

    public SearchInBetweenPrice(Integer less, Integer more) {
        this.less = less;
        this.more = more;
        inBetweenPrice=new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {

        for (Home home : HomeList)
            if (home.getPrice() < less && home.getPrice() > more)
                inBetweenPrice.add(home);

        return inBetweenPrice;
    }
}
