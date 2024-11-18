package pageObjects.derivedproduct1;
import commons.BasePage;
import pageUIs.DerivedProduct1Tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class DerivedProduct1TestsPageObject {
	private static final Logger log = LogManager.getLogger(DerivedProduct1TestsPageObject.class);
	public static void loginToDerivedProductsOne() {
    	BasePage.launchbrowser();
    	BasePage.windowMaximize();
    	BasePage.loginPage("https://www.nba.com/sixers/");
	}
	
	public static void countOfSlides() {
		int count = BasePage.getCount(DerivedProduct1Tests.DP1_SLIDES_COUNT);
		log.info("Total number of slides: "+count);
		System.out.println("Total number of slides: "+count);
	}
	
	public static void verifySlideTitles() {
		int count = BasePage.getCount(DerivedProduct1Tests.DP1_SLIDES_COUNT);
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=4;i++) {
    		String getValue = Integer.toString(i);
    	
			String title= BasePage.getdynamicTextAttributeValue(DerivedProduct1Tests.DP1_SLIDES_TITLE.replaceAll("slidenumber", getValue));
			sb.append(title);
		}
		log.info("Titles of all slides: "+sb);
		System.out.println("Titles of all slides: "+sb);
	}
	
	public static void durationOfEachSlide() {
		BasePage.getdynamicTextAttributeValue(DerivedProduct1Tests.DP1_SLIDES_DURATION);
	}
}
