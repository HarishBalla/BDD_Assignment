package pageObjects.coreproducttests;
import commons.BasePage;
import pageUIs.CoreProductTests;
import pageUIs.DerivedProduct1Tests;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoreProductTestsPageObject {
	private static final Logger log = LogManager.getLogger(CoreProductTestsPageObject.class);
    public static void loginToCoreProducts() {
    	BasePage.launchbrowser();
    	BasePage.windowMaximize();
    	BasePage.loginPage("https://www.nba.com/warriors");
//    	if(BasePage.waitForElement(CoreProductTests.CP_IACCEPT)) {
//    	BasePage.click(CoreProductTests.CP_IACCEPT);
//    	}
    	if(BasePage.waitForElement(CoreProductTests.CP_CLOSE_BUTTON)) {
    	BasePage.click(CoreProductTests.CP_CLOSE_BUTTON);
    	}
//    	BasePage.hoverMouseAction(CoreProductTests.CP_SHOP);
//    	BasePage.click(CoreProductTests.CP_SHOP_MEN);;
    }
    
    public static void navigateToShopMens() {
    	BasePage.hoverMouseAction(CoreProductTests.CP_SHOP);
    	BasePage.waitForElement(CoreProductTests.CP_SHOP_MEN);
    	BasePage.click(CoreProductTests.CP_SHOP_MEN);
    	BasePage.switchToLatestOpenedWindow();
    }
    
    public static void clickJacketsRadioButton() {
    	BasePage.click(CoreProductTests.CP_JACKETS_RADIO_BUTTON);
    }
    
    public static void calcutePageCount() {
		int count = BasePage.getCount(CoreProductTests.moneyvalue_of_jackets);
    }
    
    public static void getJacketdetailsinAllPages() {
    	try {
    	int pageCount=5;
    	StringBuffer sb = new StringBuffer();
    	String fileName = "output.txt";
    	FileWriter writer = new FileWriter(fileName);
    	for(int i=0;i<=pageCount;i++) {
    		String getValue = Integer.toString(i);
    		BasePage.click(CoreProductTests.CP_MENS_PAGINATION.replaceAll("pagenumber", getValue));
    		String jacketdetails = BasePage.getdynamicTextAttributeValue(CoreProductTests.moneyvalue_of_jackets);
    		sb.append(jacketdetails);

    	}
    	String textdata=sb.toString();
        writer.write("Extracted Text from the webpage: \n");
        writer.write(textdata);
        writer.write("\n");
    	}catch(IOException i) {
			log.info("Data updation failed -"+ i.getMessage());
    	}
    }
    
    public static void attachTextFiletoReport() {
    	BasePage.click(CoreProductTests.CP_JACKETS_RADIO_BUTTON);
    }
    
    
    
    public static void navigateTONewsANDFeatures() {
    	BasePage.hoverMouseAction(CoreProductTests.CP_NEWS_FEATURES);
    	BasePage.click(CoreProductTests.CP_MENU_BAR);
    }
    
    public static void scrollToVideosFeed() {
    	BasePage.hoverMouseAction(CoreProductTests.CP_VIDEO_FEED_TOTAL);
//    	BasePage.click(CoreProductTests.CP_MENU_BAR);
    }
    
    public static int countToVideosFeed() {
    	BasePage.hoverMouseAction(CoreProductTests.CP_VIDEO_FEED_TOTAL);
    	int videocount = BasePage.getCount(CoreProductTests.CP_VIDEO_FEED_TOTAL);
    	int videoLessThan3d = BasePage.getCount(CoreProductTests.CP_VIDEO_LESSTHAN_3D);
    	int videosGreaterThan3d = videocount-videoLessThan3d;
    		log.info("Number of videos more than or equal to 3 days "+videosGreaterThan3d);
    	return videosGreaterThan3d;
//    	BasePage.click(CoreProductTests.CP_MENU_BAR);
    }
    
}