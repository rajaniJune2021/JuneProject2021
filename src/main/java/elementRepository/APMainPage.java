package elementRepository;

import commonUtilities.DriverUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webElementUtility.WebelementActionLibrary;

import java.util.List;

public class APMainPage extends WebelementActionLibrary {


    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInBtn;

    @FindBy(id = "contact-link")
    private WebElement contactLink;

    @FindBy(xpath = "//input[@value='FeMale']")
    private WebElement femaleRadioBtn;

    @FindBy(xpath = "//li//a[@title='T-shirts']")
    private List<WebElement> tShirts;

    @FindBy(linkText = "Women")
    private List<WebElement> womenMouseOverTab;

    @FindBy(linkText = "SwitchTo")
    private WebElement switchTOLink;

    @FindBy(linkText = "Alerts")
    private WebElement alertsLink;

    @FindBy(xpath = "//a[contains(text(),'Interactions ')]")
    private WebElement interactions;

    @FindBy(xpath = "//a[contains(text(),'Drag and Drop ')]")
    private WebElement dragAndDropArial;

    @FindBy(xpath = "//a[contains(text(),'Static ')]")
    private WebElement eleStatic;

    @FindBy(xpath = "//img[@id='node']")
    private WebElement seleniumImage;

    @FindBy(xpath = "//div[@id='droparea']")
    private WebElement dragDropElement;

    @FindBy(xpath = "//span[contains(text(),'Close')]")
    private WebElement closeBtn;


    public APMainPage() {
        PageFactory.initElements(DriverUtility.getDriver(), this);
    }

    public void switchTOAlerts(){
        moveToTheElementAndClick(switchTOLink);
        moveToTheElementAndClick(alertsLink);
        keyBoardActions(alertsLink,Keys.ENTER);
    }

    public void dragAndDropTOStaticElement() throws InterruptedException {
        moveToTheElementAndClick(interactions);
        moveToTheElementAndClick(dragAndDropArial);
        Thread.sleep(5000);
        moveToTheElementAndClick(eleStatic);
        click(eleStatic);
        Thread.sleep(5000);
        moveToTheElementAndClick(closeBtn);
        click(closeBtn);
        dragAndDropMethod(seleniumImage,dragDropElement);
    }

    public String getTitle() {
        return DriverUtility.driver.getTitle();
    }

    public APMyAccountPage goToMyAccountPage() {
        click(signInBtn);
        System.out.println("clicked on sign in button");
        return new APMyAccountPage();
    }


    public void goToContactUsPage() throws InterruptedException {
        try {
            Thread.sleep(5000);
            JavascriptExecutor je = (JavascriptExecutor) DriverUtility.driver;
            je.executeScript("arguments[0].click();", contactLink);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // je.executeScript("document.getElementById('contact-link').click()");
        // click(contactLink);
    }

    public void gotoWomenTShirtsPage() throws InterruptedException {
        moveToTheElementAndClick(womenMouseOverTab.get(0));
      //  keyBoardActions(tShirts,Keys.ENTER);
        Thread.sleep(3000);
        click(tShirts.get(0));
        System.out.println("navigated to the t-shirts page");
    }

    public void getElementByJavaScript() {
        try {
            Thread.sleep(5000);
            JavascriptExecutor je = (JavascriptExecutor) DriverUtility.driver;
            je.executeScript("arguments[0].click();", femaleRadioBtn);
            System.out.println("clicked female radio button");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
