package pageUIs;

public class DerivedProduct1Tests {
	 public final static String DP1_TICKETS = "(//span[text()='Tickets'])[1]";
	 public final static String DP1_SLIDES_COUNT = "//div[contains(@class,'TileHero_tileHeroContent')]/descendant::button";
	 public final static String DP1_SLIDES_TITLE = "(//div[contains(@class,'TileHero_tileHeroContent')]/descendant::button/div[contains(@class,'TileHeroStories_tileHeroStoriesButtonTitle')])[slidenumber]";
	 public final static String DP1_SLIDES_DURATION = "//div[contains(@class,'TileHero_tileHeroContent')]/descendant::button[@aria-selected='true']";
}
