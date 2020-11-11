package SearchFeature;

import MainClasess.Home;

import java.util.ArrayList;

public class SearchByArea implements SearchInterface{

    Integer area;
    ArrayList <Home>byArea;

    public SearchByArea(Integer area) {
        this.area = area;
        byArea=new ArrayList<Home>();
    }


    public ArrayList<Home> search(ArrayList<Home> HomeList) {
        for (Home home : HomeList)
            if (home.getArea() < area)
                byArea.add(home);

        return byArea;
    }
}
