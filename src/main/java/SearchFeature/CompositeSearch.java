package SearchFeature;

import MainClasess.Home;
import com.sun.tracing.dtrace.ArgsAttributes;

import java.util.ArrayList;

public class CompositeSearch implements SearchInterface {

    ArrayList<SearchInterface> searchMethods = new ArrayList<SearchInterface>();

    ArrayList<Home> allPassedHomes;


    public void addSearchMethod(SearchInterface search) {
        searchMethods.add(search);
    }

    public ArrayList<Home> search(ArrayList<Home> HomeList) {

        allPassedHomes = HomeList;

        for (SearchInterface obj : searchMethods)
            allPassedHomes = obj.search(allPassedHomes);

        return allPassedHomes;
    }

    public static void main(String[] args) {


        SearchInterface search1 = new SearchByPets("No");
        SearchInterface search2 = new SearchByInBetweenArea(200, 100);
        SearchInterface search3 = new SearchByBathrooms(2);

        SearchInterface obj = new CompositeSearch();

        ((CompositeSearch) obj).addSearchMethod(search1);
        ((CompositeSearch) obj).addSearchMethod(search2);
        ((CompositeSearch) obj).addSearchMethod(search3);

        ArrayList<Home>Result = obj.search(getCreatedHomeList());

        for(Home h : Result)
            System.out.println(h.getID());

    }

    public static ArrayList<Home> getCreatedHomeList(){
        ArrayList<Home> homeList = new ArrayList<Home>();

        Home home1 = new Home();
        home1.setID("01");
        home1.setType("House");
        home1.setMaterial("Wood");
        home1.setPlacement("Village");
        home1.setPets(false);
        home1.setAmenities("GarageParking,FirePlace,Elevator".split(","));
        home1.setPrice(510);
        home1.setArea(150);
        home1.setBedrooms(3);
        home1.setBathrooms(2);
        home1.setLeaseLength(6);

        Home home2 = new Home();
        home2.setID("02");
        home2.setType("Apartment");
        home2.setMaterial("Brick");
        home2.setPlacement("City");
        home2.setPets(false);
        home2.setAmenities("Elevator".split(","));
        home2.setPrice(230);
        home2.setArea(120);
        home2.setBedrooms(4);
        home2.setBathrooms(2);
        home2.setLeaseLength(12);

        homeList.add(home1);
        homeList.add(home2);

        return homeList;
    }

}
