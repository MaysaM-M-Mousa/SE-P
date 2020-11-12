package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchLessThanPrice implements SearchInterface{

    Integer price;
    ArrayList<Home> lessThanPrice;

    public SearchLessThanPrice(Integer price) {
        this.price = price;
        lessThanPrice = new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {
        for (Home home : homeList)
            if (home.getPrice() < price)
                lessThanPrice.add(home);

        return lessThanPrice;
    }
}
