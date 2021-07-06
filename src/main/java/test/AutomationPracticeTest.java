package test;

import commonUtilities.DriverUtility;
import commonUtilities.ReadExcelFileUtility;
import commonUtilities.ReportUtility;

import elementRepository.APMainPage;
import elementRepository.APMyAccountCreationPage;
import elementRepository.APMyAccountPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import webElementUtility.WebelementActionLibrary;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Driver;

public class AutomationPracticeTest {

    APMainPage apMainPage;
    APMyAccountPage apMyAccountPage;
    APMyAccountCreationPage apMyAccountCreationPage;
    ReadExcelFileUtility readExcelFileUtility;
    // BeforeClass and AfterClass annotation usage

    @BeforeSuite
    public void openBrowser() {
        DriverUtility.getDriver();
        readExcelFileUtility = new ReadExcelFileUtility();

    }

    @BeforeMethod
    public void navigateToLaunchAutomationSite(Method method) {
        ReportUtility.testReport = ReportUtility.report.createTest(method.getName());
       // DriverUtility.driver.get("http://automationpractice.com/index.php");
        DriverUtility.driver.get("http://demo.automationtesting.in/Register.html");
        apMainPage = new APMainPage();
    }

//    @BeforeTest
//    public void verifyMainPage(){
//        System.out.println("This is printing from before Test from Automation Practice Test ");
//    }

    @Test
    public void automationDemoSiteAlertSite() throws InterruptedException {
        apMainPage.dragAndDropTOStaticElement();
       // apMainPage.switchTOAlerts();
    }

    @Test(groups = "automation-regression", priority = 1)
    public void verifyMyAccountPage() {
        apMyAccountPage = apMainPage.goToMyAccountPage();
        Assert.assertEquals(apMyAccountPage.getTitle(), "Login - My Store");
        System.out.println("test case passed");
    }

    @Test(groups = "automation-regression", priority = 2)
    public void registerAccount() {
        apMyAccountPage = apMainPage.goToMyAccountPage();
        apMyAccountCreationPage = apMyAccountPage.goToMyAccountCreationPage();
        apMyAccountCreationPage.createNewAccount();
    }
    
//    @Test
//    public void registerAccountWithJavaScript() throws InterruptedException {
//        apMainPage.goToContactUsPage();
//
//    }

    @Test
    public void tShirtCartPageNavigationWithKeysActions() throws InterruptedException {
         apMainPage.gotoWomenTShirtsPage();
    }

    @Test(dataProvider = "test123")
    public void runTestViaDataProviderTestData(String email, String pwd) {
        System.out.println(email);
        System.out.println(pwd);
    }

    @AfterSuite
    public void closeBrowser() {
        ReportUtility.report.flush();
//        DriverUtility.driver.quit();
    }

    @DataProvider(name = "test123")
    public Object[][] getTestData() {
        return new Object[][]{{"test@gmail.com", "pwd123"}, {"test2@gmail.com", "pwd124"}};

    }

    @Test(dataProvider = "registerTestData")
    public void registerAccountWithDataProviderData(String custFN, String custLN, String custEmail, String dropDaysValue, String dropDMonth, String dropDownYear, String addressFirName, String addressLastName, String companyName, String address, String cityName, String addressState, String zip, String countryDdTextValue, String phoneNumber) {
        apMyAccountPage = apMainPage.goToMyAccountPage();
        apMyAccountCreationPage = apMyAccountPage.goToMyAccountCreationPage();
        apMyAccountCreationPage.createNewAccount(custFN, custLN, custEmail, dropDaysValue, dropDMonth, dropDownYear, addressFirName, addressLastName, companyName, address, cityName, addressState, zip, countryDdTextValue, phoneNumber);
    }

    @DataProvider(name = "registerTestData")
    public Object[][] getRegistrationTestData() {
        return new Object[][]{{"testone", "testtwo", "test@678", "1", "1", "2000", "testone", "testtwo", "ABCCompany", "123 main street", "cypress", "California", "90630", "United States", "234567890"}};
    }


    @Test
    public void getDataFromExcelSheet() {

        String excelCellData = readExcelFileUtility.getData("LoginData", 1, 0);
        System.out.println(excelCellData);
    }

    @AfterMethod
    public void afterMethod(ITestResult result,Method method){

        switch(result.getStatus()){
            case 1: readExcelFileUtility.writeDataToExcel("TestCaseStatus",0,1,method.getName()+" PASSED");
                    break;
            case 2: readExcelFileUtility.writeDataToExcel("TestCaseStatus", 0,1, method.getName()+ "FAILED");
        }
    }

    @Test
    public void Test(){
         apMainPage.getElementByJavaScript();

            }

    @AfterSuite
    public void openReportInBrowser() throws IOException {
//        DriverUtility.driver.get(ReportUtility.reportFile);
//        Runtime.getRuntime().exec("taskkill /IM chromedirver.exe /f");
    }

}
