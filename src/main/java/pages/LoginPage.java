package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="defaultRegisterFormEmail")
    public WebElement userName;

    @FindBy(xpath = "//input[@name ='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@routerlink='/user/registration']")
    public WebElement registerLink;

    @FindBy(id = "error-message")
    public WebElement errorMsg;

    @FindBy(id="email-error-required")
    public WebElement emailErrorMsg;

    @FindBy(id="password-error-required")
    public WebElement passwordErrorMsg;



    public ContactsPage login(String uName, String pass) {
        enterCreds(uName, pass);
        click(loginButton);
        return new ContactsPage(driver);
    }

    public void enterCreds(String uName, String pass) {
        type(userName, uName);
        type(password, pass);
    }

    public LoginPage loginNegative(String uName, String pass) {
        type(userName, uName);
        type(password, pass);
        click(loginButton);
        return this;
    }

}