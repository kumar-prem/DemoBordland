package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContactUsPage {
    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"footer\"]/div/div[2]/a[3]")
    private WebElement lnkContactUs;

    @FindBy(how = How.ID, using = "autoquote:f1")
    private WebElement txtTitle;

    @FindBy(how = How.ID, using = "autoquote:f2")
    private WebElement txtFirstName;

    @FindBy(how = How.ID, using = "autoquote:f3")
    private WebElement txtLastName;

    @FindBy(how = How.ID, using = "autoquote:f5")
    private WebElement txtAddress;

    @FindBy(how = How.ID, using = "autoquote:f7")
    private WebElement txtCity;

    @FindBy(how = How.ID, using = "autoquote:f8")
    private WebElement txtState;

    @FindBy(how = How.ID, using = "autoquote:f9")
    private WebElement txtZipCode;

    @FindBy(how = How.ID, using = "autoquote:f10")
    private WebElement txtTelephone;

    @FindBy(how = How.ID, using = "autoquote:f11")
    private WebElement txtEmail;

    @FindBy(how = How.ID, using = "autoquote:f12")
    private WebElement txtComment;

    @FindBy(how = How.XPATH, using = "//*[@id=\"autoquote\"]/fieldset/div[11]/a/img")
    private WebElement lnkSubmit;

    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]")
    private WebElement txtHeader;

    public void clickContactUsLink() {
        lnkContactUs.click();
    }

    public void verifyContactUsPageIsOpen() {
        Assert.assertTrue(txtTitle.isDisplayed());
    }

    public void fillContactUsPersonalDetails(String title, String firstname, String lastname) {
        txtTitle.sendKeys(title);
        txtFirstName.sendKeys(firstname);
        txtLastName.sendKeys(lastname);
    }

    public void fillContactUsContactDetails(String address, String city, String state, String zipcode, String telephone, String email) {
        txtAddress.sendKeys(address);
        txtCity.sendKeys(city);
        txtState.sendKeys(state);
        txtZipCode.sendKeys(zipcode);
        txtTelephone.sendKeys(String.valueOf(telephone));
        txtEmail.sendKeys(email);
    }

    public void fillContactUsComment(String comment) {
        txtComment.sendKeys(comment);
    }

    public void clickSubmitLink() {
        lnkSubmit.click();
    }

    public void verifyContactUsFormIsSubmitted() {
        Assert.assertTrue(txtHeader.isDisplayed());
    }
}
