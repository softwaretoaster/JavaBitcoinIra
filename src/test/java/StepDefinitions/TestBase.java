package StepDefinitions;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class TestBase {

    public static WebDriver driver;
    public static SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    @Parameters("driverName")
    public static void setUp(String driverName){
        driver = Driver.getDriver(driverName);
        softAssert = new SoftAssert();

    }

}
