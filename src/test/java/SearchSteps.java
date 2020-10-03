import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchSteps {

    Search search = new Search();


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
        search.addHome(home);
    }

    // search by type
    @When("I search about home by type {string} specification")
    public void iSearchAboutHomeWithSpecification(String type) {
        search.SearchByType(type);
    }


    // search by material
    @When("I search about home by material {string}")
    public void iSearchAboutHomeByMaterial(String material) {
        search.searchByMaterial(material);
    }


    // search by placement
    @When("I search about home by placement as {string}")
    public void iSearchAboutHomeByPlacementAs(String placement) {
        search.searchByPlacement(placement);
    }


    // search by Pets
    @When("I search about home by pets {string} specification")
    public void iSearchAboutHomeByPetsSpecification(String condition) {
        search.searchByPets(condition);
    }

    //search By amenities
    @When("I search about home with {string} specification")
    public void iSearchAboutHomeWithAmenities(String amenities) {
        search.searchByAmenities(amenities);
    }

    //search By less than price 
    @When("I search about home with price less than {int}")
    public void iSearchAboutHomeWithPriceLessThan(Integer price) {
        search.searchByLessThanPrice(price);
    }

    //search by in between price 
    @When("I search about home with price less than {int} and more than {int}")
    public void iSearchAboutHomeWithPriceLessThanAndMoreThan(Integer less, Integer more) {
        search.searchByInBetweenPrice(less, more);
    }


    // TODO implement (@When) tags for the rest of scenarios -> Note that (@Then) tag is general


    //search by area less than
    @When("I search about home with area less than {int}")
    public void iSearchAboutHomeWithAreaLessThan(Integer area) {
        search.searchByArea(area);
    }

    //search by area in between
    @When("I search about home with area less than {int} and more than {int}")
    public void iSearchAboutHomeWithAreaLessThanAndMoreThan(Integer less, Integer more) {
        search.searchByAreaInBetween(less, more);
    }

    //search by bedrooms
    @When("I search about home with specific number of bedrooms {int}")
    public void iSearchAboutHomeWithSpecificNumberOfBedrooms(Integer bedrooms) {
        search.searchByBedrooms(bedrooms);
    }

    //search by bathrooms
    @When("I search about home with {int} bathrooms")
    public void iSearchAboutHomeWithBathroomsBathrooms(Integer bathrooms) {
        search.searchByBathrooms(bathrooms);

    }

    //search by lease length
    @When("I search about home with {int} specification")
    public void iSearchAboutHomeWithLease_lengthSpecification(Integer lease) {
        search.searchByLease(lease);
    }

    @Then("A list of homes that matches specifications {string} should be returned and printed on the console")
    public void aListOfHomesThatMatchesSpecificationsShouldBeReturnedAndPrintedOnTheConsole(String result) {

        String allHousesStr = search.assertResult(result);

        try {
            // it will be in the form : 01,02, -> the last comma was removed in the next line
            // it might cause out of index in case it's empty so it's surrounded with a try block
            allHousesStr = allHousesStr.substring(0, allHousesStr.length() - 1);
            assertEquals(allHousesStr, result);

        } catch (StringIndexOutOfBoundsException e) {
            // every empty position is filled with "None" string
            assertEquals("None", result);
        }

    }
}
