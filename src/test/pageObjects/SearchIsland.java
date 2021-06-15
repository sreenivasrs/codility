package test.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchIsland {

	WebDriver driver;
	public SearchIsland(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchResults = By.xpath("//div[@id='search-results']");
	By searchQuery = By.xpath("id of search query");
	By searchButton = By.xpath("id of button");
	By searchResultCommentOnNoResult = By.xpath("No result comment id ");

	
	public WebElement getSearchResults() {
		return driver.findElement(searchResults);
	}
	
	public List<WebElement> getSearchResultsCount() {
		return driver.findElements(searchResults);
	}
	
	
	
	public WebElement getSearchQuery() {
		return driver.findElement(searchQuery);
	}
	
	public List<WebElement> getAvailabilitySearchQuery() {
		return driver.findElements(searchQuery);
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}
	
	public List<WebElement> getAvailabilitySearchButton() {
		return driver.findElements(searchButton);
	}
	
	public WebElement getSearchNoResultComment() {
		return driver.findElement(searchResultCommentOnNoResult);
	}
	

}
