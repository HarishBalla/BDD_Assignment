package stepsDefinition;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.derivedproduct2.DerivedProduct2TestsPageObject;

public class DerivedProduct2Tests {
	

    @Given("I navigate to the homepage of derived product two")
    public static void navigateToDP2Homepage() {
    	DerivedProduct2TestsPageObject.loginToDP2Products();
}

@When("I scroll down to the footer")
    public static void navigateToDP2Footer() {
		DerivedProduct2TestsPageObject.navigateToDP2Footer();
}

@And("Verify all the expected categories are available in the footer section")
    public static void verifyFooterCategories() {
		DerivedProduct2TestsPageObject.verifyFooterCategories();
}

@And("I get all the hyperlinks of the all the categories in the footer and add to CSV file")
    public static void getHyperlinksAddToCSV() throws IOException {
	  	DerivedProduct2TestsPageObject.getHyperlinksAddToCSV();
}

@Then("I validate if duplicates are present in the hyperlinks")
    public static void verifyDuplicates() {
		DerivedProduct2TestsPageObject.verifyDuplicates();
}

}
