import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import utilities.ReadProperties;

import java.io.IOException;

public class BaseTest extends BasePage {

    @BeforeSuite(groups={"Smoke","Regression","Sanity","functional","dailybuild","All"})
    public void readProperties() throws IOException {
        ReadProperties.readConfigfile();
    }

    @BeforeMethod(groups={"Smoke","Regression","Sanity","functional","dailybuild","All"})
    public void openBrowser(){
        openBrowser("chrome");
            }

    @AfterMethod(groups={"Smoke","Regression","Sanity","functional","dailybuild","All"})
    public void shutBrowser(){
        closeBrowser();
    }
}
