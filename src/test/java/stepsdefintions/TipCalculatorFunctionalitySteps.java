package stepsdefintions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TipCalculatorFunctionalitySteps {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Given("I am on the calculate page")
    public void gettheCalculatePage(){
        driver.get("https://qatipcalc.ccbp.tech/");
    }
    @When("I click on the calculate button")
    public void clickthecalculationButton(){
        WebElement calculateBt = driver.findElement(By.id("calculateButton")) ;
        calculateBt.click();
    }
    @When("I Enter the tip percentage as 10f.")
    public void enterpecentageOnly(){
        WebElement percentageEl = driver.findElement(By.id("percentageTip")) ;
        percentageEl.sendKeys("10f");
    }
    @When("I Enter the bill amount as 1000.")
    public void enterbillAmount(){
        WebElement percentageEl = driver.findElement(By.id("billAmount")) ;
        percentageEl.sendKeys("1000");
    }
    @When("I Enter the tip percentage as 15.")
    public void enterValidpecentageOnly(){
        WebElement percentageEl = driver.findElement(By.id("percentageTip")) ;
        percentageEl.sendKeys("15");
    }
    @Then("an error message 'Please Enter a Valid Input.' should be visible")
    public void getErrorMsg(){
        WebElement errorEl = driver.findElement(By.id("errorMessage"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));
        String expectError = "Please Enter a Valid Input.";
        String currentMsg = errorEl.getText();
        Assert.assertEquals(expectError,currentMsg);
    }
    @Then("an expected the tip amount and total amount")
    public void getOutput(){
        WebElement tipAmountEl = driver.findElement(By.id("tipAmount"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipAmount")));
        String currentTip = tipAmountEl.getText();
        String expectTip = "150.00";
        Assert.assertEquals(currentTip,expectTip);
        WebElement totalAmountEl = driver.findElement(By.id("totalAmount"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalAmount")));
        String currentTotal = totalAmountEl.getText();
        String expectTotal = "1150.00";
        Assert.assertEquals(currentTotal,expectTotal);
    }

}
