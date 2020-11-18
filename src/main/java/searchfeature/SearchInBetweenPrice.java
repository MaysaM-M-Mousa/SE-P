package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchInBetweenPrice implements SearchInterface{

    Integer less;
    Integer more;
    ArrayList<Home>inBetweenPrice;

    public SearchInBetweenPrice(Integer less, Integer more) {
        this.less = less;
        this.more = more;
        inBetweenPrice=new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {

        for (Home home : homeList)
            if (home.getPrice() < less && home.getPrice() > more)
                inBetweenPrice.add(home);

        return inBetweenPrice;
    }
}
