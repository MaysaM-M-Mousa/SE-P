import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchSteps {

    ArrayList<Home> homeList = new ArrayList<Home>();
    ArrayList<Home> resultSearchList = new ArrayList<Home>();


    @Given("the following home is a data in the system")
    public void theFollowingHomeIsADataInTheSystem(DataTable table) {

        List<String> list = table.column(1);

        Home home = new Home();

        home.setID(list.get(1));
        home.setType(list.get(2));
        home.setMaterial(list.get(3));
        home.setPlacement(list.get(4));
        home.setPets(list.get(5).equals("No") ? new Boolean(false) : new Boolean(true));
        home.setAmenities(list.get(6).split(","));
        home.setPrice(Integer.parseInt(list.get(7)));
        home.setArea(Integer.parseInt(list.get(8)));
        home.setBedrooms(Integer.parseInt(list.get(9)));
        home.setLeaseLength(Integer.parseInt(list.get(10)));

        homeList.add(home);
    }

    // search by type
    @When("I search about home by type {string} specification")
    public void iSearchAboutHomeWithSpecification(String type) {

        for (Home home : homeList)
            if (home.getType().equals(type)) {
                resultSearchList.add(home);
            }
    }

    // search by material
    @When("I search about home by material {string}")
    public void iSearchAboutHomeByMaterial(String material) {

        for (Home home : homeList)
            if (home.getMaterial().equals(material)) {
                resultSearchList.add(home);
            }

    }


    // search by placement


    // search by Pets
    @When("I search about home by pets {string} specification")
    public void iSearchAboutHomeByPetsSpecification(String condition) {
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

    // TODO implement (@When) tags for the rest of scenarios -> Note that (@Then) tag is general



    @Then("A list of homes that matches specifications {string} should be returned and printed on the console")
    public void aListOfHomesThatMatchesSpecificationsShouldBeReturnedAndPrintedOnTheConsole(String result) {

        String allHousesStr = "";
        for (Home home : resultSearchList) {
            allHousesStr += home.getID() + ",";
        }

        String allHousesResultStr = "";
        try {
            // it will be in the form : 01,02, -> the lase comma was removed in the next line
            // it might cause out of index in case it's empty so it's surrounded with a try block
            allHousesResultStr = allHousesStr.substring(0, allHousesStr.length() - 1);
            assertEquals(allHousesResultStr, result);

        } catch (StringIndexOutOfBoundsException e) {
            // every empty position is filled with "None" string
            assertEquals("None", result);
        }


    }



}
