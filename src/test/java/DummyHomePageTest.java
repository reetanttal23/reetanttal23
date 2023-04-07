import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class DummyHomePageTest extends BaseTest{
    @Test(groups={"Smoke","Regression","Sanity"})
    public void testElements(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openElements();;
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("Dummy1");

    }
    @Test(groups={"Smoke","functional","Sanity"})
    public void testAlerts(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openAlerts();
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("Dummy2");

    }
    @Test(groups={"Smoke","Regression","Sanity"})
    public void testElement2(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openElements();;
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("Dummy3");

    }
    @Test(groups={"Smoke","functional","dailybuild"})
    public void testAlerts2(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openAlerts();
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("Dummy45dailybuild");

    }
    @Test(groups={"Smoke","Regression","Sanity"})
    public void testElements3(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openElements();;
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("Dummy");

    }
    @Test(groups={"Smoke","functional","dailybuild"})
    public void testAlerts3(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openAlerts();
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("Dummy6daily");

    }
    @Test
    public void testAlerts4(){
        HomePage homePage = new HomePage();
        WebElement fname = homePage.openAlerts();
        Assert.assertEquals(fname.getText(),"Please select an item from left to start practice.");
        System.out.println("Dummy7");

    }
}
