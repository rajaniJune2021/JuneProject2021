package webElementUtility;

import commonUtilities.DriverUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

public class WebelementActionLibrary {

    public WebDriverWait wait = new WebDriverWait(DriverUtility.driver, 20);

    public void click(WebElement element) {

        try {
            //  wait.until(ExpectedConditions.visibilityOf(element));
            element.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterText(WebElement element, String input) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSelected(WebElement element) {
        boolean b = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isSelected())
                b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public boolean isEnabled(WebElement element) {
        boolean b = false;
        try {

            if (element.isEnabled())
                b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public void selectDropdown(WebElement element, String ddValue) {
        try {
            Select ddSelection = new Select(element);
            ddSelection.selectByValue(ddValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectDropdownVisibleByText(WebElement element, String visibleTxt) {
        try {
            Select ddSelection = new Select(element);
            ddSelection.selectByVisibleText(visibleTxt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveToTheElementAndClick(WebElement element) {
        try {
            //wait.until(ExpectedConditions.visibilityOf(element));
            //   Wait fluentWait = new FluentWait(DriverUtility.driver).withTimeout(Duration.ofSeconds(90)).pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
            Actions act = new Actions(DriverUtility.driver);
            act.moveToElement(element).perform();
            // act.contextClick()  right click any particular element
            // act.keyUp()// press the key
            //act.keyDown(element, Keys.) releasing the key
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dragAndDropMethod(WebElement sourceElement, WebElement targetElement1) {
        try {
            Actions act = new Actions(DriverUtility.driver);
            act.dragAndDrop(sourceElement, targetElement1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void keyBoardActions(WebElement element, Keys keys) {
        try {
            Actions act = new Actions(DriverUtility.driver);
            // act.keyUp(element,keys);
            //act.keyDown(element,keys);
            element.sendKeys(Keys.chord(keys));// with chord multiple key action can be passed such as  element.sendKeys(Keys.chord(Keys.SHIFT,Keys.ALT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void acceptAlert() {
        try {
            Alert alert = DriverUtility.driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissAlert() {
        try {
            Alert alert = DriverUtility.driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterTextInAlertBox(String text) {
        try {
            Alert alert = DriverUtility.driver.switchTo().alert();
            alert.sendKeys(text);
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<String> switchToGetWindowHandle() {
        return DriverUtility.driver.getWindowHandles();
    }

    public String getCurrentWindowName() {
        return DriverUtility.driver.getWindowHandle();
    }

}
