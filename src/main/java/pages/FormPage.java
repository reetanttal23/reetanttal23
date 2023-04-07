package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import utilities.ReadProperties;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

public class FormPage extends BasePage {
    Map<String,String> tableDataMap;
    List<WebElement> finalList;

    public WebElement clickFormsBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement forms = driver.findElement(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("homePage_FormsBtn")));
        js.executeScript("arguments[0].scrollIntoView(true)", forms);
        forms.click();
        Wait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        WebElement practiceForms = (WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("forms_PracticeFormBtn")))));
        practiceForms.click();
        Wait wait1 = new WebDriverWait(driver, Duration.ofMillis(2000));
        WebElement formsMessage = (WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("forms_FormsMessage")))));
        return formsMessage;

    }

    public void fillSubmitForm(String firstName, String lastName, String emailId, String subjects, String currentAddress) throws AWTException {
        WebElement firstNamee = driver.findElement(By.id(ReadProperties.readOrPropertiesfile().getProperty("forms_FirstName")));
        firstNamee.sendKeys(firstName);
        WebElement lastNamee = driver.findElement(By.id(ReadProperties.readOrPropertiesfile().getProperty("forms_LastName")));
        lastNamee.sendKeys(lastName);
        WebElement email = driver.findElement(By.id(ReadProperties.readOrPropertiesfile().getProperty("forms_Email")));
        email.sendKeys(emailId);
        String gender = ReadProperties.readOrPropertiesfile().getProperty("forms_Gender").replace("Gender", "Male");
        Wait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        ((WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(gender))))).click();
        //.click();
        WebElement subjectss = driver.findElement(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("forms_Subjects")));
        subjectss.sendKeys(subjects);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        WebElement currentAddresss = driver.findElement(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("forms_CurrentAddress")));
        currentAddresss.sendKeys(currentAddress);
    }

    public void enterMobileNo(String mobileNo){
        WebElement mobilNo = driver.findElement(By.id(ReadProperties.readOrPropertiesfile().getProperty("forms_MobileNumber")));
        mobilNo.sendKeys(mobileNo);
    }


    public void dateSelection() throws InterruptedException {
        WebElement chooseDate = driver.findElement(By.id(ReadProperties.readOrPropertiesfile().getProperty("forms_Dob")));
        chooseDate.click();
        LocalDateTime ldt = LocalDateTime.now().plusMonths(3).plusYears(3).plusDays(15);

        String month = ldt.getMonth().toString();
        month = month.substring(0, 1) + month.substring(1).toLowerCase();
        String year = String.valueOf(ldt.getYear());
        String day = String.valueOf(ldt.getDayOfMonth());

        WebElement dateMonth = driver.findElement(By.className(ReadProperties.readOrPropertiesfile().getProperty("date-Month")));
        Select selectm = new Select(dateMonth);
        selectm.selectByVisibleText(month);

        WebElement dateYear = driver.findElement(By.className(ReadProperties.readOrPropertiesfile().getProperty("date-Year")));
        Select selecty = new Select(dateYear);
        selecty.selectByVisibleText(year);

        Thread.sleep(2000);

        List<WebElement> dateList = driver.findElements(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("forms-Day")));
        for (WebElement date : dateList) {
            if (date.getText().equals(day)) {
                date.click();
                break;

            }
        }
    }

    public void selectHobby() {
        String myHobby = ReadProperties.readOrPropertiesfile().getProperty("forms_Hobbies").replace("Hobbies", "Sports");
        WebElement hobby = driver.findElement(By.xpath(myHobby));
        hobby.click();
    }
    public void selectImgae(String pathOfFile) throws AWTException, InterruptedException {
        Wait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
        WebElement chooseFile = (WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(ReadProperties.readOrPropertiesfile().getProperty("forms_ChooseFile")))));
        chooseFile.sendKeys(pathOfFile);
        /*BasePage.CtrlC(pathOfFile);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(8000);
        System.out.println("completed");*/
    }

    public void selectState() throws InterruptedException {
        WebElement state = driver.findElement(By.id(ReadProperties.readOrPropertiesfile().getProperty("forms_State")));
        state.click();
        /*setTimeout(function() {
debugger;
}, 3000);*/

        Wait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
        WebElement finalState = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("state_ChooseState"))));
        finalState.click();

    }
    public void selectCity(){
        Wait wait = new WebDriverWait(driver,Duration.ofMillis(12000));
        WebElement city = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("forms_City"))));
        city.click();

        Wait wait1 = new WebDriverWait(driver,Duration.ofMillis(5000));
        WebElement finalCity = (WebElement) wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("city_FinalCIty"))));
        finalCity.click();
    }
    public void submitForm() throws InterruptedException {
        Wait wait = new WebDriverWait(driver,Duration.ofMillis(12000));
        WebElement submitButton = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ReadProperties.readOrPropertiesfile().getProperty("forms_Submit"))));
        submitButton.sendKeys(Keys.ENTER);
        Thread.sleep(8000);
    }

    public Boolean validateHeaders(){
        List<WebElement> headersList = driver.findElements(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("table_Headers")));
        Boolean flag = false;
        for (int i = 0;i<headersList.size();i++){
             if ((headersList.get(i).getText()).contains("Label")){
                 flag = true;
            }
         }
        return flag;
            }
            public void getRowData(){
        List<WebElement> rowsList = driver.findElements(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("table_Rows")));
         tableDataMap = new HashMap<String, String>();
         finalList = new ArrayList<WebElement>();
             for(int i=0;i< rowsList.size();i++){
             List<WebElement>coulmndata = rowsList.get(i).findElements(By.tagName("td"));
                 for(int j=0;j< coulmndata.size();j++){
                     finalList.add(coulmndata.get(j));
                 }



                       //tableDataMap.put(coulmndata.get(0).getText(),coulmndata.get(1).getText());
        }
            }

public String validateName(){
    String studentName = finalList.get(1).getText();
    //String studentName = tableDataMap.get("Student Name");
    return studentName;

}
public void closeTable(){
        WebElement closeTable = driver.findElement(By.xpath(ReadProperties.readOrPropertiesfile().getProperty("table-Close")));
        closeTable.sendKeys(Keys.ENTER);
}
}

