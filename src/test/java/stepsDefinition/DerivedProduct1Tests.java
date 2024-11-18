package stepsDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.derivedproduct1.DerivedProduct1TestsPageObject;

public class DerivedProduct1Tests {

    @Given("I navigate to the derived product one homepage")
    public static void loginToDerivedProductsOne() {
    	DerivedProduct1TestsPageObject.loginToDerivedProductsOne();
    }
    
    @When("I get the total number of slides under Tickets")
    public static void countOfSlides() {
    	DerivedProduct1TestsPageObject.countOfSlides();
    }
    
    @And("I verify the titles of the slides")
    public static void verifySlideTitles() {
    	DerivedProduct1TestsPageObject.verifySlideTitles();
    }
    
    @Then("I verify the duration of each slide")
    public static void durationOfEachSlide() {
    	DerivedProduct1TestsPageObject.durationOfEachSlide();
    }
	
}
