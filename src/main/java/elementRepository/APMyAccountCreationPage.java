package elementRepository;

import commonUtilities.DriverUtility;
import commonUtilities.ReadingFileFromJsonFile;
import commonUtilities.ReportUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webElementUtility.WebelementActionLibrary;

public class APMyAccountCreationPage extends WebelementActionLibrary {

    ReadingFileFromJsonFile readingFileFromJsonFile;

    public APMyAccountCreationPage() {
        readingFileFromJsonFile =  new ReadingFileFromJsonFile();
        PageFactory.initElements(DriverUtility.getDriver(), this);
    }

    @FindBy(id = "id_gender2")
    private WebElement mrsRadioBtn;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement customerFN;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    private WebElement customerLN;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement customerEmail;

    @FindBy(id = "passwd")
    private WebElement customerPwd;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement days;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement months;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement years;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement addressFN;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement addressLN;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address;

    @FindBy(xpath = "//input[@name='address2']")
    private WebElement addressTwo;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;

    @FindBy(xpath = "//select[@name='id_state']")
    private WebElement state;

    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postalCode;

    @FindBy(xpath = "//select[@name='id_country']")
    private WebElement country;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@name='phone_mobile']")
    private WebElement phoneTxt;

    @FindBy(xpath = "//input[@id='alias']")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement registerBtn;

    @FindBy(id = "address1")
    private WebElement addressOne;

    @FindBy(id = "company")
    private WebElement companyTxt;

    public void createNewAccount() {
        try {
            click(mrsRadioBtn);
            isEnabled(mrsRadioBtn);
            System.out.println("radio btn selected");
            enterText(customerFN, readingFileFromJsonFile.readJsonFileAndConvertToMap().get("firstName"));
            System.out.println("enter data into fn selected");
            enterText(customerLN, readingFileFromJsonFile.readJsonFileAndConvertToMap().get("lastName"));
            enterText(customerPwd, "test@678");
            click(days);
            selectDropdown(days, "1");
            click(months);
            selectDropdown(months, "1");
            click(years);
            selectDropdown(years, "2000");
            enterText(addressFN, readingFileFromJsonFile.readJsonFileAndConvertToMap().get("firstName"));
            enterText(addressLN, readingFileFromJsonFile.readJsonFileAndConvertToMap().get("lastName"));
            enterText(companyTxt, "ABCCompany");
            enterText(addressOne, "123 main street");
            enterText(city, "cypress");
            click(state);
            selectDropdownVisibleByText(state, "California");
            enterText(postalCode, "90630");
            click(country);
            selectDropdownVisibleByText(country, "United States");
            enterText(phoneTxt, readingFileFromJsonFile.readJsonFileAndConvertToMap().get("phoneNumber"));
            System.out.println("filled the all required for fields");
            ReportUtility.passCase("User is able to register succesfully", "registeredUser_1");
            //click(registerBtn);
            System.out.println("filled the all required for fields");
        } catch (Exception e) {
            ReportUtility.failCase("User unable to registered the account", "failedTCScreenshot");
            e.printStackTrace();

        }

    }

    public void createNewAccount(String custFN, String custLN, String custEmail,String dropDaysValue, String dropDMonth, String dropDownYear,String addressFirName, String addressLastName, String companyName, String address, String cityName,String addressState, String zip, String countryDdTextValue, String phoneNumber  ) {
        try {
            click(mrsRadioBtn);
            isEnabled(mrsRadioBtn);
            System.out.println("radio btn selected");
            enterText(customerFN, custFN);
            System.out.println("enter data into fn selected");
            enterText(customerLN, custLN);
            enterText(customerPwd, custEmail);
            click(days);
            selectDropdown(days, dropDaysValue);
            click(months);
            selectDropdown(months, dropDMonth);
            click(years);
            selectDropdown(years, dropDownYear);
            enterText(addressFN, addressFirName);
            enterText(addressLN, addressLastName);
            enterText(companyTxt, companyName);
            enterText(addressOne, address);
            enterText(city, cityName);
            click(state);
            selectDropdownVisibleByText(state, addressState);
            enterText(postalCode,zip );
            click(country);
            selectDropdownVisibleByText(country, countryDdTextValue);
            enterText(phoneTxt, phoneNumber);
            System.out.println("filled the all required for fields");
            ReportUtility.passCase("User is able to register succesfully", "registeredUser_1");
            //click(registerBtn);
            System.out.println("filled the all required for fields");
        } catch (Exception e) {
            ReportUtility.failCase("User unable to registered the account", "failedTCScreenshot");
            e.printStackTrace();

        }

    }

}
