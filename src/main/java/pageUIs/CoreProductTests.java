package pageUIs;

public class CoreProductTests {
		 public final static String CP_IACCEPT = "//button[text()='I Accept']";
		 public final static String CP_CLOSE_BUTTON = "//div[@class='p-2 absolute right-3 hover:cursor-pointer']";
		 public final static String CP_SHOP = "(//span[text()='Shop'])[1]";
		 public final static String CP_SHOP_MEN = "(//li[contains(@data-testid,'nav-item-https://shop.warriors.com/golden-state-warriors-men/')])[1]";
		 public final static String CP_JACKETS_RADIO_BUTTON = "//span[@class='allDepartmentsBoxes-link-text' and text()='Jackets']";
		 public final static String moneyvalue_of_jackets = "//div[@class='grid grid-small-2-medium-3 row small-up-2 medium-up-3']/descendant::div[@class='columns small-12 medium-12']/descendant::span[@class='money-value']";
		 public final static String CP_MENS_PAGINATION = "//li[contains(@class,'show-for-large')][pagenumber]";
		 public final static String CP_MENU_BAR = "(//ul[@class='_menu_1k79k_73' and @role='menubar'])[2]";
		 public final static String CP_NEWS_FEATURES = "(//a[@title='News & Features'])[1]";
		 public final static String CP_VIDEO_FEED_TOTAL = "(//ul[@class='ContentGrid_contentGridArticles__laJB3'])[2]/li";
		 public final static String CP_VIDEO_LESSTHAN_3D = "(//div[contains(@class,'ContentContainer_contentContainer__10mzD')])[2]/descendant::span[@aria-hidden='true' and contains(text(),'1d') or contains(text(),'2d')]";
}
