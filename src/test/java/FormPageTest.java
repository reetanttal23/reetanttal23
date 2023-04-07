import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import utilities.ExcelDataProvider;

import java.awt.*;

public class FormPageTest extends BaseTest {
           FormPage fp;

    @Test(dataProviderClass = ExcelDataProvider.class,dataProvider = "formDetailsExcel")
        public void fillAndSubmitForm(String firstName,String lastName,String emailId, String subjects, String currentAddress) throws InterruptedException, AWTException {
        fp = new FormPage();
        WebElement message = fp.clickFormsBtn();
        Assert.assertEquals(message.getText(),"Student Registration Form");
        System.out.println(message.getText());
        fp.fillSubmitForm(firstName,lastName,emailId,subjects,currentAddress);
        fp.enterMobileNo("3435588375");
        fp.dateSelection();
        fp.selectHobby();
        fp.selectImgae(" C:\\Users\\reeta\\OneDrive\\Pictures\\Myfile.jpg");
        fp.selectState();
        fp.selectCity();
        fp.submitForm();

        ///Assertions
        Boolean flag = fp.validateHeaders();
        Assert.assertTrue(flag);
        fp.getRowData();
        String validateName = fp.validateName();
        System.out.println(validateName);
        Assert.assertEquals("Bhola Dhillon",validateName);
        fp.closeTable();

            }


}
