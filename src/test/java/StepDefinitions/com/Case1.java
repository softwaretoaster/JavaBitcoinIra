package StepDefinitions.com;

import PageFactory.MainPage;
import StepDefinitions.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Case1 extends TestBase {


    MainPage mainPage;
    String xPathForTemplateDropDown = "//select[@ng-model='templateUrl']";

    @BeforeClass
    public void setUpPage() {
        mainPage = new MainPage(driver);
        driver.get("http://cgross.github.io/angular-busy/demo/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void testCase1() throws InterruptedException {
        WebElement templateDropDown = driver.findElement(By.xpath(xPathForTemplateDropDown));
        Select select = new Select(templateDropDown);
        select.selectByVisibleText("Standard");
        mainPage.demoButton.click();
        Thread.sleep(500);
        String actualSpinner = "Please Wait...";
        String expectedSpinner = mainPage.spinningIndicator1.getText();
        Assert.assertEquals(actualSpinner, expectedSpinner);

        Thread.sleep(500);
        templateDropDown.click();
        Thread.sleep(300);

        select.selectByValue("custom-template.html");
        mainPage.demoButton.click();
        String actualWizardText = "Please Wait...";
        String expectedWizardText = mainPage.dancingWizardIndicator1.getText();
        Assert.assertEquals(actualWizardText, expectedWizardText);
    }


    @Test
    public void testCase2() throws InterruptedException {
        mainPage.message.clear();
        mainPage.message.sendKeys("Waiting");
        WebElement templateDropDown = driver.findElement(By.xpath(xPathForTemplateDropDown));
        Select select = new Select(templateDropDown);
        select.selectByVisibleText("Standard");
        mainPage.demoButton.click();
        String actualSpinTextWaiting = "Waiting";
        String expectedSpinTextWaiting = mainPage.spinningIndicator2.getText();
        Assert.assertEquals(actualSpinTextWaiting, expectedSpinTextWaiting);
        System.out.println(expectedSpinTextWaiting);

        Thread.sleep(500);
        templateDropDown.click();
        select.selectByValue("custom-template.html");
        mainPage.demoButton.click();
        String actualWizardText = "Waiting";
        String expectedWizardText = mainPage.dancingWizardIndicator1.getText();
        Assert.assertEquals(actualWizardText, expectedWizardText);
    }


    @Test
    public void testCase3() {
        mainPage.minDuration.clear();
        mainPage.minDuration.sendKeys("1000");
        WebElement templateDropDown = driver.findElement(By.xpath("//select[@ng-model='templateUrl']"));
        Select select = new Select(templateDropDown);
        select.selectByVisibleText("Standard");
        long startTime = System.currentTimeMillis();
        mainPage.demoButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(mainPage.spinningIndicator2));

        while (mainPage.spinningIndicator2.isDisplayed()) {
            System.out.println("wizard is displayed");
        }

        long endTime = System.currentTimeMillis();
        Assert.assertTrue((endTime - startTime) >= 1000);
    }


   



}
