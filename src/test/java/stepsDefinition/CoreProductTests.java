package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import pageObjects.user.UserAccountPageObject;
import pageObjects.coreproducttests.CoreProductTestsPageObject;
public class CoreProductTests {
	
	    @Given("I navigate to the core product homepage")
	    public static void navigateToCPHomepage() {
	    	CoreProductTestsPageObject.loginToCoreProducts();
	    }
	    
	    @When("I navigate to Shop menu and click Men option and switch to new window")
	    	public static void navigateToShopMens() {
	    	CoreProductTestsPageObject.navigateToShopMens();
	    }
	    
	    @And("Select Jackets radio button from All departments option")
    	public static void clickJacketsRadioButton() {
    	CoreProductTestsPageObject.clickJacketsRadioButton();
	    }
	    
	    @Then("Calculate the number of pages for jackets")
    	public static void calcutePageCount() {
    	CoreProductTestsPageObject.calcutePageCount();
	    }
	    
	    @And("Get the details of every single jacket from all the pages and store to text file")
    	public static void allJacketDetails() {
    	CoreProductTestsPageObject.getJacketdetailsinAllPages();
	    }
	    
	    @Then("Create a text file with all the jacket details and attach to report")
    	public static void textFile() {
    	CoreProductTestsPageObject.attachTextFiletoReport();
	    }
	    
	    @When("I navigate to NEWS AND FEATURE under menu bar")
    	public static void navigateTONewsANDFeatures() {
    	CoreProductTestsPageObject.navigateTONewsANDFeatures();
	    }
	    
	    @And("I scroll down to the Videos feed pane")
    	public static void scrollToVideosFeed() {
    	CoreProductTestsPageObject.scrollToVideosFeed();
	    }
	    
	    @Then("Get the count of videos posted more than three days ago")
    	public static void countToVideosFeed() {
    	CoreProductTestsPageObject.countToVideosFeed();
	    }	
}
