package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class CompositeSearch implements SearchInterface {

    ArrayList<SearchInterface> searchMethods = new ArrayList<>();

    ArrayList<Home> allPassedHomes;


    public void addSearchMethod(SearchInterface search) {
        searchMethods.add(search);
    }

    public List<Home> search(List<Home> homeList) {

        allPassedHomes = (ArrayList<Home>)homeList;

        for (SearchInterface obj : searchMethods)
            allPassedHomes = (ArrayList<Home>)obj.search(allPassedHomes);

        return allPassedHomes;
    }




}
