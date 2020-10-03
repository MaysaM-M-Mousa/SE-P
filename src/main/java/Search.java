import java.util.ArrayList;

public class Search {

    private ArrayList<Home> resultSearchList;
    private static ArrayList<Home> homeList;



    public Search() {
        this.resultSearchList =new ArrayList<Home>();
        this.homeList=new ArrayList<Home>();
    }

    public void addHome(Home home){
        homeList.add(home);
    }

     void SearchByType(String type) {
        for (Home home : homeList)
            if (home.getType().equals(type)) {
                resultSearchList.add(home);
            }
    }
     void searchByMaterial(String material) {
        for (Home home : homeList)
            if (home.getMaterial().equals(material)) {
                resultSearchList.add(home);
            }
    }

     void searchByPets(String condition) {
        if(condition.equals("No")){
            for (Home home : homeList)
                if (!home.getPets())
                    resultSearchList.add(home);
        }
        else {
            for (Home home : homeList)
                if (home.getPets())
                    resultSearchList.add(home);
        }
    }

    String assertResult(String result) {
        String allHousesStr = "";
        for (Home home : resultSearchList) {
            allHousesStr += home.getID() + ",";
        }
        return allHousesStr;
    }

}
