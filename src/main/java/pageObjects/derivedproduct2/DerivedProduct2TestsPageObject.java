package pageObjects.derivedproduct2;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVWriter;

import commons.BasePage;
import pageUIs.CoreProductTests;
import pageUIs.DerivedProduct2Tests;

public class DerivedProduct2TestsPageObject {
	private static final Logger log = LogManager.getLogger(DerivedProduct2TestsPageObject.class);
	public static void loginToDP2Products() {
    	BasePage.launchbrowser();
    	BasePage.windowMaximize();
    	BasePage.loginPage("https://www.nba.com/bulls/");
	}
	
	public static void navigateToDP2Footer() {
    	BasePage.hoverMouseAction(DerivedProduct2Tests.DP2_FOOTER);
	}
	
	public static void verifyFooterCategories() {
    	BasePage.hoverMouseAction(DerivedProduct2Tests.DP2_FOOTER);
    	BasePage.waitForElement(DerivedProduct2Tests.DP2_NEWS);
    	BasePage.waitForElement(DerivedProduct2Tests.DP2_TICKETS);
    	BasePage.waitForElement(DerivedProduct2Tests.DP2_SHOP);
    	BasePage.waitForElement(DerivedProduct2Tests.DP2_UNITEDCENTER);
    	BasePage.waitForElement(DerivedProduct2Tests.DP2_TEAM);
    	BasePage.waitForElement(DerivedProduct2Tests.DP2_NEWS);
	}
	//getHyperlinksAddToCSV
	
	public static void getHyperlinksAddToCSV() throws IOException {
		String hyperlinks = BasePage.getAlllist(DerivedProduct2Tests.DP2_HYPERLINK_DYNAMIC);
		String[] links=hyperlinks.split("");
		
		log.info("hyperlinks are : "+hyperlinks);
		System.out.println("hyperlinks are : "+hyperlinks);
    	String fileName = "hyperlink.csv";
    	FileWriter outputfile = new FileWriter(fileName);
    	CSVWriter writer = new CSVWriter(outputfile); 
        writer.writeNext(links);        
        writer.close();
	}
	
	public static void verifyDuplicates() {
		String actual = BasePage.getAlllist(DerivedProduct2Tests.DP2_HYPERLINK_DYNAMIC);
		char[] dup=actual.toCharArray();
		for(int i=0;i<dup.length-1;i++) {
			for(int j=1;j<i;j++) {
				if(dup[i]==dup[j]) {
					System.out.println("Duplicates are there" +dup[i]);
				}
			}
		}
	}
	
	
	
}
