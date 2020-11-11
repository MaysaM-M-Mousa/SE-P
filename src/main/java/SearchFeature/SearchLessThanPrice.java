package SearchFeature;

import MainClasess.Home;

import java.util.ArrayList;

public class SearchLessThanPrice implements SearchInterface{

    Integer price;
    ArrayList<Home> lessThanPrice;

    public SearchLessThanPrice(Integer price) {
        this.price = price;
        lessThanPrice = new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {
        for (Home home : HomeList)
            if (home.getPrice() < price)
                lessThanPrice.add(home);

        return lessThanPrice;
    }
}
