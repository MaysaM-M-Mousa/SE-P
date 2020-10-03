import java.util.ArrayList;

public class Search {

    private ArrayList<Home> resultSearchList;
    private static ArrayList<Home> homeList;


    public Search() {
        this.resultSearchList = new ArrayList<Home>();
        this.homeList = new ArrayList<Home>();
    }

    public void addHome(Home home) {
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
        if (condition.equals("No")) {
            for (Home home : homeList)
                if (!home.getPets())
                    resultSearchList.add(home);
        } else {
            for (Home home : homeList)
                if (home.getPets())
                    resultSearchList.add(home);
        }
    }

    void searchByPlacement(String placement) {
        for (Home home : homeList)
            if (home.getPlacement().equals(placement)) {
                resultSearchList.add(home);
            }
    }


    public void searchByAmenities(String amenity) {
        for (Home home : homeList)
            for (String x : home.getAmenities()) {
                if (x.equals(amenity)) {
                    resultSearchList.add(home);
                }
            }

    }

    public void searchByLessThanPrice(Integer price) {
        for (Home home : homeList)
            if (home.getPrice() < price) {
                resultSearchList.add(home);
            }
    }

    public void searchByInBetweenPrice(Integer less, Integer more) {
        for (Home home : homeList) {
            if (home.getPrice() < less && home.getPrice() > more)
                resultSearchList.add(home);
        }
    }

    public void searchByArea(Integer area) {
        for (Home home : homeList) {
            if (home.getArea() < area)
                resultSearchList.add(home);
        }
    }

    public void searchByAreaInBetween(Integer less, Integer more) {
        for (Home home : homeList) {
            if (home.getArea() < less && home.getArea() > more)
                resultSearchList.add(home);
        }
    }


    public void searchByBedrooms(Integer bedrooms) {
        for (Home home : homeList) {
            if (home.getBedrooms()==bedrooms)
                resultSearchList.add(home);
        }
    }

    public void searchByBathrooms(int bathrooms) {
        for (Home home : homeList) {
            if (home.getBedrooms()==bathrooms)
                resultSearchList.add(home);
        }
    }

    public void searchByLease(Integer lease) {
        for (Home home : homeList) {
            if (home.getBedrooms().equals(lease))
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
