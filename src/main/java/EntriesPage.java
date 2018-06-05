import org.openqa.selenium.*;

import java.util.List;

public class EntriesPage extends BasePage{

    private final String Url = "http://igorakintev.ru/admin/blog/entry/";

    private static final By XPATH_TABLE = By.xpath("//table[@id='result_list']/tbody/tr");
    private static final By XPATH_TABLE_TITLE_COLUMN = By.xpath("//th/a");
    private static final By XPATH_TABLE_LINK_COLUMN = By.xpath("//tr[@class='row1']/th/a");
    private static final By XPATH_LINK_BUTTON = By.xpath("//a[@class='deletelink']");
    private static final By XPATH_CONFIRMATION_BUTTON = By.xpath("//input[@type='submit']");

    public EntriesPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    @Override
    public String getUrl() { return Url; }

    public boolean removeRecord(String title) {
        if(title == null) throw new NullPointerException("title");

        List<WebElement> rows = driver.findElements(XPATH_TABLE);
        waitForElementVisible(rows.get(0));

        for(WebElement row : rows) {
            String rowTitle = row.findElement(XPATH_TABLE_TITLE_COLUMN).getText();
            if(rowTitle.equals(title)) {
                WebElement linkColumn = row.findElement(XPATH_TABLE_LINK_COLUMN);
                linkColumn.click();
                WebElement removeButton = driver.findElement(XPATH_LINK_BUTTON);
                removeButton.click();
                WebElement confirmationButton = driver.findElement(XPATH_CONFIRMATION_BUTTON);
                confirmationButton.click();
                return true;
            }
        }
        return false;
    }
}
