import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

@Test(groups={"All"})

public class HomePageTest extends BaseTest {
   @Test(groups={"Smoke","Regression","Sanity"})
    public void testElements(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openElements();;
       Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
       System.out.println("original1");

    }
    @Test(groups={"Smoke","functional","Sanity"})
    public void testAlerts(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openAlerts();
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("original2");

    }
    @Test(groups={"Smoke","Regression","Sanity"})
    public void testElement2(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openElements();;
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("original3");

    }
    @Test(groups={"Sanity","functional","dailybuild"})
    public void testAlerts2(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openAlerts();
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("original4dialy");

    }
    @Test(groups={"Smoke","Regression","Sanity"})
    public void testElements3(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openElements();;
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("original5");

    }
    @Test(groups={"Smoke","functional","dailybuild"})
    public void testAlerts3(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openAlerts();
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("original6dailyy");

    }
    @Test
    public void testAlerts4(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openAlerts();
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("original7");

    }
}
