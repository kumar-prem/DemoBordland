package pageObjects;

import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class AutoQuotePage {
    private WebDriver driver;

    public AutoQuotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.ID, using = "quick-link:jump-menu")
    private WebElement drpService;

    @FindBy(how = How.ID, using = "autoquote:zipcode")
    private WebElement txtzipcode;

    @FindBy(how = How.ID, using = "autoquote:e-mail")
    private WebElement txtAutoquoteEmail;

    @FindBy(how = How.ID, using = "autoquote:vehicle:0")
    private WebElement rdbtnAutomobiletypeCar;

    @FindBy(how = How.ID, using = "autoquote:vehicle:1")
    private WebElement rdbtnAutomobiletypeTruck;

    @FindBy(how = How.ID, using = "autoquote:next")
    private WebElement btnNext;

    @FindBy(how = How.ID, using = "autoquote:age")
    private WebElement txtAge;

    @FindBy(how = How.ID, using = "autoquote:gender:0")
    private WebElement rdbtnGenderMale;

    @FindBy(how = How.ID, using = "autoquote:gender:1")
    private WebElement rdbtnGenderFemale;

    @FindBy(how = How.ID, using = "autoquote:type:0")
    private WebElement rdbtnDrivingRecordExcellent;

    @FindBy(how = How.ID, using = "autoquote:type:1")
    private WebElement rdbtnDrivingRecordGood;

    @FindBy(how = How.ID, using = "autoquote:type:2")
    private WebElement rdbtnDrivingRecordFair;

    @FindBy(how = How.ID, using = "autoquote:type:3")
    private WebElement rdbtnDrivingRecordPoor;

    @FindBy(how = How.ID, using = "autoquote:year")
    private WebElement txtYear;

    @FindBy(how = How.ID, using = "ext-gen4")
    private WebElement drpMake;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen8\"]")
    private WebElement selectMake;

    @FindBy(how = How.ID, using = "ext-gen6")
    private WebElement drpModel;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen12\"]")
    private WebElement selectModel;

    @FindBy(how = How.ID, using = "autoquote:finInfo:0")
    private WebElement rdbtnFinancialInfoOwn;

    @FindBy(how = How.ID, using = "autoquote:finInfo:1")
    private WebElement rdbtnFinancialInfoFinanced;

    @FindBy(how = How.ID, using = "autoquote:finInfo:2")
    private WebElement rdbtnFinancialInfoLease;

    @FindBy(how = How.NAME, using = "quote-result")
    private WebElement label_Quote_Result;

    @FindBy(how = How.XPATH, using = "//*[@id=\"quote-result\"]/h1[2]/b")
    private WebElement labelPrice;

    @FindBy(how = How.XPATH, using = "//*[@id=\"quote-result\"]/h1[2]")
    private WebElement lblConfirmationMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"quote-result\"]/h1[2]/b")
    private WebElement lblFinalPrice;

    public void selectAutoQuoteService() {
        Select servicedropdown = new Select(drpService);
        servicedropdown.selectByVisibleText("Auto Quote");
    }

    public void enterGetInstantAutoQuoteForm(String zipcode, String email) {
        txtzipcode.sendKeys(zipcode);
        txtAutoquoteEmail.sendKeys(email);
    }

    public void selectAutoMobileType(String automobiletype) {
        if (automobiletype.equals("Car")) {
            rdbtnAutomobiletypeCar.click();
        } else if (automobiletype.equals("Truck")) {
            rdbtnAutomobiletypeTruck.click();
        }
    }

    public void clickNextButton() {
        btnNext.click();
    }

    public void verifyInstantAutoQuotePageIsOpen() {
        Assert.assertTrue(txtAge.isDisplayed());
    }

    public void enterInstantAutoQuoteDetails1(String age, String gender, String drivingRecord) {
        txtAge.sendKeys(age);

        if (gender.equals("Male")) {
            rdbtnGenderMale.click();
        } else if (gender.equals("Female")) {
            rdbtnGenderFemale.click();
        } else {
            Assert.fail("Value of Gender is not correct");
        }

        switch (drivingRecord) {
            case "Excellent":
                rdbtnDrivingRecordExcellent.click();
                break;
            case "Good":
                rdbtnDrivingRecordGood.click();
                break;
            case "Fair":
                rdbtnDrivingRecordFair.click();
                break;
            case "Poor":
                rdbtnDrivingRecordPoor.click();
                break;
            default:
                Assert.fail("Value of Driving Record is not correct");
                break;
        }
    }

    public void enterInstantAutoQuoteDetails2(String year, String make, String model, String financialinfo) throws InterruptedException {
        txtYear.sendKeys(String.valueOf(year));

        drpMake.click();
        Thread.sleep(2000);

        List<WebElement> c = selectMake.findElements(By.xpath("div"));
        for (WebElement i : c) {
            if (i.getText().equalsIgnoreCase(make)) {
                System.out.println(i.getText());
                i.click();
                Thread.sleep(2000);
            }
        }

        drpModel.click();
        Thread.sleep(2000);

        List<WebElement> d = selectModel.findElements(By.xpath("div"));
        for (WebElement j : d) {
            if (j.getText().equalsIgnoreCase(model)) {
                System.out.println(j.getText());
                j.click();
            }
        }
        Thread.sleep(2000);

        switch (financialinfo) {
            case "Own":
                rdbtnFinancialInfoOwn.click();
                break;
            case "Financed":
                rdbtnFinancialInfoFinanced.click();
                break;
            case "Lease":
                rdbtnFinancialInfoLease.click();
                break;
            default:
                Assert.fail("Financial Info value is not properly set");
                break;
        }
    }

    public void getInstantQuoteInformation() {
        Assert.assertTrue(lblConfirmationMessage.getText().contains("Your Instant Quote is USD"));

        System.out.println("Final Price is: " + lblFinalPrice.getText());
    }
}
