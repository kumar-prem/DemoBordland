package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.ID, using = "login-form:email")
    private WebElement txtEmail;

    @FindBy(how = How.ID, using = "login-form:password")
    private WebElement txtPassword;

    @Getter
    @FindBy(how = How.ID, using = "login-form:login")
    private WebElement btnLogin;

    @Getter
    @FindBy(how = How.ID, using = "login-form")
    private WebElement frameLoginForm;

    @Getter
    @FindBy(how = How.ID, using = "logout-form:logout")
    private WebElement btnLogout;

    public void loginToApplication(String email, String password){
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
    }
}
