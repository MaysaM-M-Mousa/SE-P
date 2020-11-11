package SearchFeature;

import MainClasess.Home;

import java.util.ArrayList;

public class SearchByPets implements SearchInterface {

    String condition;
    ArrayList<Home> byPets;

    SearchByPets(String condition) {
        this.condition = condition;
        byPets = new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {
        if (condition.equals("No")) {
            for (Home home : HomeList)
                if (!home.getPets())
                    byPets.add(home);
        } else {
            for (Home home : HomeList)
                if (home.getPets())
                    byPets.add(home);
        }
        return byPets;
    }
}
