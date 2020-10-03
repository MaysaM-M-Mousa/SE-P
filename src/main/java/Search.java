import java.util.ArrayList;

public class Search {

    public static int counter = 0;
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
        counter++;
    }

    void searchByMaterial(String material) {
        for (Home home : homeList)
            if (home.getMaterial().equals(material)) {
                resultSearchList.add(home);
            }
        counter++;
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
        counter++;
    }

    void searchByPlacement(String placement) {
        for (Home home : homeList)
            if (home.getPlacement().equals(placement)) {
                resultSearchList.add(home);
            }
        counter++;
    }


    public void searchByAmenities(String amenity) {
        for (Home home : homeList)
            for (String x : home.getAmenities()) {
                if (x.equals(amenity)) {
                    resultSearchList.add(home);
                }
            }
        counter++;
    }

    public void searchByLessThanPrice(Integer price) {
        for (Home home : homeList)
            if (home.getPrice() < price) {
                resultSearchList.add(home);
            }
        counter++;
    }

    public void searchByInBetweenPrice(Integer less, Integer more) {
        for (Home home : homeList) {
            if (home.getPrice() < less && home.getPrice() > more)
                resultSearchList.add(home);
        }
        counter++;
    }

    public void searchByArea(Integer area) {
        for (Home home : homeList) {
            if (home.getArea() < area)
                resultSearchList.add(home);
        }
        counter++;
    }

    public void searchByAreaInBetween(Integer less, Integer more) {
        for (Home home : homeList) {
            if (home.getArea() < less && home.getArea() > more)
                resultSearchList.add(home);
        }
        counter++;
    }


    public void searchByBedrooms(Integer bedrooms) {
        for (Home home : homeList) {
            if (home.getBedrooms() == bedrooms)
                resultSearchList.add(home);
        }
        counter++;
    }

    public void searchByBathrooms(int bathrooms) {
        for (Home home : homeList) {
            if (home.getBathrooms() == bathrooms)
                resultSearchList.add(home);
        }
        counter++;
    }

    public void searchByLease(Integer lease) {
        for (Home home : homeList) {
            if (home.getLeaseLength() == (lease))
                resultSearchList.add(home);
        }
        counter++;
    }

    String assertResult(String result) {

        ArrayList<Home> duplicatedArrayList = new ArrayList<Home>();

        Boolean duplicatedElements = false;
        for (int i = 0; i < resultSearchList.size(); i++) {
            if (resultSearchList.lastIndexOf(resultSearchList.get(i)) != i) {
                duplicatedArrayList.add(resultSearchList.get(i));
                duplicatedElements = true;
            }
        }

        String allHousesStr = "";
        if (duplicatedElements) {
            for (Home home : duplicatedArrayList) {
                allHousesStr += home.getID() + ",";
            }
        } else if (counter == 1) {
            for (Home home : resultSearchList) {
                allHousesStr += home.getID() + ",";
            }
        }
        counter=0;
        return allHousesStr;
    }
}
