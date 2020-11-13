import io.cucumber.java.en.And;
import mainclasses.Home;
import searchfeature.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchSteps {

    ArrayList<Home> arr = new ArrayList<>();
    SearchInterface searchI;

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
        home.setBathrooms(Integer.parseInt(list.get(10)));
        home.setLeaseLength(Integer.parseInt(list.get(11)));
        arr.add(home);
    }

    // search by type
    @When("I search about home by type {string} specification")
    public void iSearchAboutHomeWithTypeSpecification(String type) {
        searchI = new SearchByType(type);
    }


    // search by material
    @When("I search about home by material {string}")
    public void iSearchAboutHomeByMaterial(String material) {
        searchI = new SearchByMaterial(material);
    }


    // search by placement
    @When("I search about home by placement as {string}")
    public void iSearchAboutHomeByPlacementAs(String placement) {
        searchI = new SearchByPlacement(placement);
    }


    // search by Pets
    @When("I search about home by pets {string} specification")
    public void iSearchAboutHomeByPetsSpecification(String condition) {
        searchI = new SearchByPets(condition);
    }

    //search By amenities
    @When("I search about home with {string} specification")
    public void iSearchAboutHomeWithAmenities(String amenities) {
        searchI = new SearchByAmenities(amenities);
    }

    //search By less than price 
    @When("I search about home with price less than {int}")
    public void iSearchAboutHomeWithPriceLessThan(Integer price) {
        searchI = new SearchLessThanPrice(price) ;
    }

    //search by in between price 
    @When("I search about home with price less than {int} and more than {int}")
    public void iSearchAboutHomeWithPriceLessThanAndMoreThan(Integer less, Integer more) {
        searchI = new SearchInBetweenPrice(less, more) ;
    }


    //search by area less than
    @When("I search about home with area less than {int}")
    public void iSearchAboutHomeWithAreaLessThan(Integer area) {
        searchI = new SearchByArea(area) ;
    }

    //search by area in between
    @When("I search about home with area less than {int} and more than {int}")
    public void iSearchAboutHomeWithAreaLessThanAndMoreThan(Integer less, Integer more) {
        searchI = new SearchByInBetweenArea(less, more);
    }

    //search by bedrooms
    @When("I search about home with specific number of bedrooms {int}")
    public void iSearchAboutHomeWithSpecificNumberOfBedrooms(Integer bedrooms) {
        searchI = new SearchByBedrooms(bedrooms);
    }

    //search by bathrooms
    @When("I search about home with {int} bathrooms")
    public void iSearchAboutHomeWithBathroomsBathrooms(Integer bathrooms) {
        searchI=new SearchByBathrooms(bathrooms);
    }

    //search by lease length
    @When("I search about home with {int} specific lease length")
    public void iSearchAboutHomeWithLease_lengthSpecification(Integer lease) {
        searchI = new SearchByLease(lease) ;

    }


    // first combined scenario (pets and less that price)
    @When("I search about pets {string} and price less than {int}")
    public void iSearchAboutPetsAndPriceLessThanPrice(String condition, Integer price) {
        searchI = new CompositeSearch() ;
        ((CompositeSearch)searchI).addSearchMethod(new SearchByPets(condition));
        ((CompositeSearch)searchI).addSearchMethod(new SearchLessThanPrice(price));
    }

    // second combined scenario (pets and less that price)
    @When("I search about material {string} and price between {int} and {int}")
    public void iSearchAboutMaterialAndPriceBetweenPrice_more_thanAndPrice_less_than(String material, int more, int less) {
        searchI = new CompositeSearch() ;
        ((CompositeSearch)searchI).addSearchMethod(new SearchByMaterial(material));
        ((CompositeSearch)searchI).addSearchMethod(new SearchInBetweenPrice(less,more));
    }

    @When("I search about type {string} and area between {int} and {int} and {int}")
    public void iSearchAboutTypeAndAreaBetweenArea_more_thanAndArea_less_thanAndBathrooms(String condition, int more, int less, int bathrooms) {
        searchI = new CompositeSearch() ;
        ((CompositeSearch)searchI).addSearchMethod(new SearchByPets(condition));
        ((CompositeSearch)searchI).addSearchMethod(new SearchByInBetweenArea(less,more));
        ((CompositeSearch)searchI).addSearchMethod(new SearchByBathrooms(bathrooms));


    }

    @Then("A list of homes that matches specifications {string} should be returned and printed on the console")
    public void aListOfHomesThatMatchesSpecificationsShouldBeReturnedAndPrintedOnTheConsole(String result) {
        String searchString="";
        ArrayList<Home> searchResults = (ArrayList<Home>)searchI.search(arr);
        System.out.println(searchString);
        for(int i=0;i<searchResults.size();i++){
            searchString+=searchResults.get(i).getID();
            if(searchResults.size()-1!=i)
                searchString+=",";
        }

        if(searchResults.isEmpty()){
            searchString+="None";
        }
        assertEquals(searchString,result);

    }

    @And("An Email with a list of search results will be sent to customer email")
    public void anEmailWithAListOfSearchResultsWillBeSentToCustomerEmail() {
    }


}
