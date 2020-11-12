package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchByPets implements SearchInterface {

    String condition;
    ArrayList<Home> byPets;

    public SearchByPets(String condition) {
        this.condition = condition;
        byPets = new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {
        for (Home home : homeList) {
            if(condition.equals("No")&&Boolean.FALSE.equals(home.getPets()))
                byPets.add(home);
            else if(condition.equals("Yes")&&Boolean.TRUE.equals(home.getPets())){
                byPets.add(home);
            }
        }
        return byPets;
    }
}
