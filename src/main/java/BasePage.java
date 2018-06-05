import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public abstract class BasePage {

    protected int timeout;
    protected WebDriver driver;

    public BasePage(WebDriver driver, int timeout) {

        if(driver == null) throw new NullPointerException("driver");
        if(timeout < 0) throw new IndexOutOfBoundsException("timeout");

        this.driver = driver;
        this.timeout = timeout;
    }

    public BasePage open() {
        driver.get(getUrl());
        return this;
    }

    public abstract String getUrl();

    protected WebElement waitForElementVisible(WebElement element) {
        return (new WebDriverWait(driver, timeout)).until(
                ExpectedConditions.visibilityOf(element));
    }
}
