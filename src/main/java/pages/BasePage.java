package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.Constants;
import utilities.ReadProperties;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

public class BasePage {

        public static WebDriver driver;
        public static void openBrowser(String BrowserName){

        switch(BrowserName){
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", Constants.chromexePath);
                  driver = new ChromeDriver();
                  break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Constants.firefoxexePath);
                 driver = new FirefoxDriver();
                 break;
            case "internetexplorer":
                System.setProperty("webdriver.ie.driver", Constants.explorerexePath);
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ReadProperties.url);


    }
    public static void closeBrowser(){
        driver.quit();
    }
    public static void CtrlC(String filepath){
        StringSelection selection = new StringSelection(filepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
    }

}
