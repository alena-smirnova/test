import org.openqa.selenium.By;
import org.openqa.selenium.*;

public class AdminPage extends BasePage  {

    private final String Url = "http://igorakintev.ru/admin/";

    private final By XPATH_LOGIN_FIELD = By.xpath("//input [@name='username']");
    private final By XPATH_PASS_FIELD = By.xpath("//input [@name='password']");
    private final By XPATH_SIGN_IN_BUTTON = By.xpath("//input [@value='Войти']");
    private final By XPATH_TITLE_TEXT = By.xpath("//h1 [@class='dashboard-title']");
    private final By XPATH_ADD_ENTRY_LINK = By.xpath("//a [@href='/admin/blog/entry/add/']");

    public AdminPage(WebDriver driver, int timeout){
        super(driver, timeout);
    }

    @Override
    public String getUrl() {
        return Url;
    }

    public AdminPage clearFields(){
        WebElement usernameField = driver.findElement(XPATH_LOGIN_FIELD);
        WebElement passwordField = driver.findElement(XPATH_PASS_FIELD);

        waitForElementVisible(usernameField).clear();
        waitForElementVisible(passwordField).clear();

        return this;
    }

    public AdminPage fillUsername(String username){
        if(username == null) throw new NullPointerException("username");
        WebElement usernameField = driver.findElement(XPATH_LOGIN_FIELD);

        waitForElementVisible(usernameField).sendKeys(username);

        return this;
    }

    public AdminPage fillPassword(String password){
        if(password == null) throw new NullPointerException("password");
        WebElement passwordField = driver.findElement(XPATH_PASS_FIELD);

        waitForElementVisible(passwordField).sendKeys(password);

        return this;
    }

    public AdminPage signIn(){
        WebElement button = driver.findElement(XPATH_SIGN_IN_BUTTON);

        waitForElementVisible(button).click();

        return this;
    }

    public String getTitle(){
        WebElement dashboardTitle = driver.findElement(XPATH_TITLE_TEXT);

       return waitForElementVisible(dashboardTitle).getText();
    }

    public AddEntryPage openAddEntryPage(){
        WebElement button = driver.findElement(XPATH_ADD_ENTRY_LINK);

        waitForElementVisible(button).click();

        return new AddEntryPage(driver, timeout);
    }
}
