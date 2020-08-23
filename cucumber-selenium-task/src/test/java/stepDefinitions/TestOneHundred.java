package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestOneHundred {
	WebDriver driver;
	@Given("^open the Firefox and search \"([^\"]*)\"$")
	public void open_the_Firefox_and_search(String arg1){
	   // System.out.println("This step show how to open Firefox browser and search for " + arg1);
		System.setProperty("webdriver.gecko.driver", "C:\\mozzila_geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://coinmarketcap.com/");
		
	}

	@When("^from Cryptocurrencies dropdown choose option \"([^\"]*)\"$")
	public void from_Cryptocurrencies_dropdown_choose_option_Top(String arg1) throws InterruptedException{
		//System.out.println("This step shows how to chose option Top " + arg1 + " from dropdown menu Cryptocurrencies");
		
		WebElement tab = driver.findElement(By.xpath("//*[@class='sc-12d77vg-0 eXpvpJ cmc-popover']"));
		tab.click();
		//Thread.sleep(1000);
		
		WebElement element1 = driver.findElement(By.partialLinkText(arg1));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element1);
		
	}

	@Then("^verify that amount of results is (\\d+)$")
	public void verify_that_amount_of_results_is(int arg1) {
		int size = 0;
		//System.out.println("This step shows verification of how many results does exists in Top " + arg1 +" section");
		List<WebElement> rowCount = driver.findElements(By.cssSelector("[class='cmc-table__table-wrapper-outer'] tr"));
		size = (rowCount.size())-2;
		
		//WebElement Status = null;
		
		if(size==arg1) {
			System.out.println("There are 100 results on this page");
		}
		else {
			System.out.println("There are "+ size + " results");
		}
	}


}
