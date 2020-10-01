import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class SearchSteps {
    Integer result;

    @Given("I have {int} and {int}")
    public void iHaveAnd(int arg0, int arg1) {
        result=arg0+arg1;

    }

    @When("I add Them")
    public void iAddThem() {
        
    }

    @Then("I should see {int}")
    public void iShouldSee(int arg0) {
        assertEquals(arg0,(int) result);
    }
}
