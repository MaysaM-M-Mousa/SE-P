package searchfeature;

import mainclasses.Home;

import java.util.ArrayList;
import java.util.List;

public class SearchByMaterial implements SearchInterface {

    String material;
    ArrayList<Home> byMaterial;

    public SearchByMaterial(String material) {
        this.material = material;
        byMaterial = new ArrayList<>();
    }

    public List<Home> search(List<Home> homeList) {
        for (Home home : homeList)
            if (home.getMaterial().equals(material)) {
                byMaterial.add(home);
            }
        return byMaterial;
    }
}
