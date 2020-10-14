package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@ng-click='demo()']")
    public WebElement demoButton;

    @FindBy(xpath = "//div[contains(text(),'Please Wait...')]")
    public WebElement spinningIndicator1;

    @FindBy(xpath = "//select[@ng-model='templateUrl']//option[contains(text(),'custom-template.html')]")
    public WebElement templateUrl;

    @FindBy(xpath = "//div[@ng-show='$cgBusyIsActive()']")
    public WebElement dancingWizardIndicator1;

    @FindBy(id = "message")
    public WebElement message;

    @FindBy(xpath = "//div[contains(text(),'Waiting')]")
    public WebElement spinningIndicator2;

    @FindBy(id = "durationInput")
    public WebElement minDuration;
}
