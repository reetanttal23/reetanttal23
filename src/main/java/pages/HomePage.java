package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadProperties;

import java.time.Duration;

public class HomePage extends BasePage{

 public  WebElement openElements(){
     JavascriptExecutor js = (JavascriptExecutor)driver;
     WebElement element =  driver.findElement(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("homePage_ElementsBtn")));
     js.executeScript("arguments[0].scrollIntoView(true)", element);
     element.click();
     Wait wait = new WebDriverWait( driver, Duration.ofMillis(2000));
     WebElement fullName = (WebElement) wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath(ReadProperties.orProperties.getProperty("elements_Message")))));
     return fullName;
      }

    public  WebElement openAlerts(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element =  driver.findElement(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("homePage_AlertsBtn")));
        js.executeScript("arguments[0].scrollIntoView(true)", element);
        element.click();
        Wait wait = new WebDriverWait( driver, Duration.ofMillis(2000));
        WebElement fullName = (WebElement) wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath(ReadProperties.orProperties.getProperty("alerts-Message")))));
        return fullName;

    }


}
