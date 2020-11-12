package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchByArea implements SearchInterface{

    Integer area;
    ArrayList <Home>byArea;

    public SearchByArea(Integer area) {
        this.area = area;
        byArea=new ArrayList<>();
    }


    public List<Home> search(List<Home> homeList) {
        for (Home home : homeList)
            if (home.getArea() < area)
                byArea.add(home);

        return byArea;
    }
}
