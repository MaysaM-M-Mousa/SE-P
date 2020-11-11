package SearchFeature;

import MainClasess.Home;

import java.util.ArrayList;

public class SearchByMaterial implements SearchInterface {

    String material;
    ArrayList<Home> byMaterial;

    public SearchByMaterial(String material) {
        this.material = material;
        byMaterial = new ArrayList<Home>();
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {
        for (Home home : HomeList)
            if (home.getMaterial().equals(material)) {
                byMaterial.add(home);
            }
        return byMaterial;
    }
}
