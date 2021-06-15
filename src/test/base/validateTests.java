package test.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import test.pageObjects.SearchIsland;
import test.utils.DriverManager;


public class validateTests extends DriverManager {

	WebDriver driver;
	private static Logger log = LogManager.getLogger(validateTests.class.getName());
	
	
	@Test
	public void validateQueryInputAndSearchButton() throws Exception {
		driver = drivermanager();
		WebDriverWait wait =new WebDriverWait(driver,20);
		SearchIsland searchIsland = new SearchIsland(driver);
		int searchQueryText = searchIsland.getAvailabilitySearchQuery().size();
		if (searchQueryText < 1) {
			log.error("There is no Search Query Text");
		}
		
		int searchQueryButton = searchIsland.getAvailabilitySearchButton().size();
		if (searchQueryButton < 1) {
			log.error("There is no Search Query button");
		}
	}
	
	@Test
	public void validateEmptySearchString() throws Exception {
		driver = drivermanager();
		WebDriverWait wait =new WebDriverWait(driver,20);
		SearchIsland searchIsland = new SearchIsland(driver);
		String getTextOFQuery = searchIsland.getSearchQuery().getText();
		if (getTextOFQuery.isEmpty()) {
			System.out.println("There is no search query available");
		}
	}
	
	@Test
	public void validateForAtleastOneResponse() throws Exception {
		driver = drivermanager();
		WebDriverWait wait =new WebDriverWait(driver,20);
		SearchIsland searchIsland = new SearchIsland(driver);
		String getTextOFQuery = searchIsland.getSearchQuery().getText();
		if (getTextOFQuery.equalsIgnoreCase("isla")) {
			int countOfSearch = searchIsland.getSearchResultsCount().size();
			if (countOfSearch > 1) {
				log.info("There is island for the search");
			} else {
				log.error("There is no Island and expect atleast one for the given search criteria");
			}
		}
	}

	@Test
	public void validateForFeedbackOnNoAvailability() throws Exception {
		driver = drivermanager();
		WebDriverWait wait =new WebDriverWait(driver,20);
		SearchIsland searchIsland = new SearchIsland(driver);
		int countOfSearch = searchIsland.getSearchResultsCount().size();
		if (countOfSearch == 0) {
			String getText = searchIsland.getSearchNoResultComment().getText();
			Assert.assertEquals(getText, "No Result");
		}
	}
	
	@Test
	public void validateForSearchQueryWithPort() throws Exception {
		driver = drivermanager();
		WebDriverWait wait =new WebDriverWait(driver,20);
		SearchIsland searchIsland = new SearchIsland(driver);
		String getTextOFQuery = searchIsland.getSearchQuery().getText();
		if (getTextOFQuery.equalsIgnoreCase("port")) {
			int countOfSearch = searchIsland.getSearchResultsCount().size();
			if (countOfSearch > 1) {
				log.info("There is island for the search");
				String getText = searchIsland.getSearchResults().getText();
				Assert.assertEquals(getText, "Port Royal");
			} else {
				log.error("There is no Island and expect Port Royal to be as one Island name for the given search criteria");
			}
		}
	}
}
