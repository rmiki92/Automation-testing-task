package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestFilterAndAddToWatchlist {
	WebDriver driver;
	
	@Given("^open \"([^\"]*)\"$")
	public void open(String arg1) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\mozzila_geckodriver\\geckodriver.exe");		
		driver = new FirefoxDriver();
		driver.get("https://coinmarketcap.com/");
	}

	@When("^click on button filters and select for price range from \"([^\"]*)\" to (\\d+)$")
	public void click_on_button_filters_and_select_for_price_range_from(String arg1, int arg2) throws InterruptedException {
		
		WebElement button1 = driver.findElement(By.cssSelector("button[data-qa-id=table-listing-filters-toggle]"));
		button1.click();
		
		Thread.sleep(1000);
		
		WebElement priceFilter = driver.findElement(By.xpath("//*[@data-qa-id='range-filter-price']"));
		priceFilter.click();
		
		Thread.sleep(1000);
		
		WebElement insertMinPrice = driver.findElement(By.xpath("//*[@data-qa-id='range-filter-input-min']"));
		insertMinPrice.sendKeys(arg1);
		
		Thread.sleep(1000);
		
		WebElement priceMaxClick = driver.findElement(By.xpath("//*[@data-qa-id='range-filter-input-max']"));
		priceMaxClick.click();
		
		WebElement insertMaxPrice = driver.findElement(By.xpath("//*[@data-qa-id='range-filter-input-max']"));
		String s=String.valueOf(arg2);
		insertMaxPrice.sendKeys(s);
		
		WebElement applyButton = driver.findElement(By.cssSelector("button[data-qa-id=filter-dd-button-apply]"));
		applyButton.click();
		
	}

	@Then("^select (\\d+) cryptocurrencies by clicking on the ellipsis and select \"([^\"]*)\" option$")
	public void select_cryptocurrencies_by_clicking_on_the_ellipsis_and_select_option(int arg1, String arg2) throws InterruptedException {
		
		WebElement firstRow=driver.findElement(By.cssSelector("table tbody tr:nth-child(1)"));
		WebElement elipsiss1 = firstRow.findElement(By.cssSelector("td:nth-child(9)"));
		elipsiss1.click();
		WebElement addToWatchlist1 = driver.findElement(By.cssSelector("ul > li:nth-child(1)> span"));
		addToWatchlist1.click();
	
		Thread.sleep(1000);
		
		WebElement scnRow=driver.findElement(By.cssSelector("table tbody tr:nth-child(2)"));
		WebElement elipsiss2 = scnRow.findElement(By.cssSelector("td:nth-child(9)"));
		elipsiss2.click();
		WebElement addToWatchlist2 = driver.findElement(By.cssSelector("ul > li:nth-child(2)> span"));
		addToWatchlist2.click();
		
		//Thread.sleep(1000);
		
		
		//elipsiss.click();
		//Thread.sleep(1000);
		//Thread.sleep(1000);
		//List<WebElement> rowCount = driver.findElements(By.xpath("table[class='cmc-table__table-wrapper-outer'] tr"));
		
		//rowCount = driver.findElements(By.cssSelector("[class='cmc-table__table-wrapper-outer'] tr"));
		
		//List<WebElement> allRows = table.findElements(By.xpath(".//tr[not(@class='cmc-table__cell cmc-table__header cmc-table__cell--sticky cmc-table__cell--sortable cmc-table__cell--left cmc-table__cell--sort-by__rank')"));
		// And iterate over them, getting the cells
		//for (WebElement row : allRows) {
		 //assuming that you are actually trying to click on the link for each user name,
		 //and not just the second element

			
			//WebElement addToWatchlist = row.findElement(By.xpath("//li[@class='sc-1wniqvx-0 ktnZzN cmc-menu-item']/span[@class='cmc-link']"));
		 // And so on   
		 // addToWatchlist.click();
		 // }
		//table/descendant::tr[1]/td[position() >= 2 and position() <= 4]
	}

	@Then("^click on the Watchlist tab$")
	public void click_on_the_Watchlist_tab() throws InterruptedException {
		Thread.sleep(1000);
		WebElement watchlist = driver.findElement(By.linkText("Watchlist"));
		watchlist.click();
	}

}
