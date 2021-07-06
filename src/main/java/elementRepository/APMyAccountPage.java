package elementRepository;

import commonUtilities.DriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webElementUtility.WebelementActionLibrary;

public class APMyAccountPage extends WebelementActionLibrary {

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailAddressInput;

    @FindBy(xpath="//button[@name='SubmitCreate']")
    private WebElement createSignInBtn;

    public APMyAccountPage(){
        PageFactory.initElements(DriverUtility.getDriver(),this);
    }

    public String getTitle(){
        return  DriverUtility.driver.getTitle();
    }

    public APMyAccountCreationPage goToMyAccountCreationPage() {
        enterText(emailAddressInput,"oneapptest68@gmail.com");
        System.out.println("entered email address");
        click(createSignInBtn);
        System.out.println("clicked on create sign in btn");
        return new APMyAccountCreationPage();
    }
}
