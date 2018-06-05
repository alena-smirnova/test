import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEntryPage extends BasePage {

    private final String Url = "http://igorakintev.ru/admin/blog/entry/add/";

    private final By XPATH_TITLE_TEXT = By.xpath("//div[@id='content']/h1");
    private final By XPATH_TITLE_FIELD = By.xpath("//input [@id='id_title']");
    private final By XPATH_SLUG_FIELD = By.xpath("//input [@id='id_slug']");
    private final By XPATH_TEXT_MARKDOWN_FIELD = By.xpath("//textarea [@id='id_text_markdown']");
    private final By XPATH_TEXT_FIELD = By.xpath("//textarea [@id='id_text']");
    private final By XPATH_SAVE_BUTTON = By.xpath("//input [@name='_save']");

    public AddEntryPage(WebDriver driver, int timeout){
        super(driver, timeout);
    }

    @Override
    public String getUrl() {
        return Url;
    }

    public String getTitle(){
        WebElement title = driver.findElement(XPATH_TITLE_TEXT);

        return waitForElementVisible(title).getText();
    }

    public AddEntryPage clearFields(){
        WebElement titleField = driver.findElement(XPATH_TITLE_FIELD);
        WebElement slugField = driver.findElement(XPATH_SLUG_FIELD);
        WebElement textMarkDownField = driver.findElement(XPATH_TEXT_MARKDOWN_FIELD);
        WebElement textField = driver.findElement(XPATH_TEXT_FIELD);

        waitForElementVisible(titleField).clear();
        waitForElementVisible(slugField).clear();
        waitForElementVisible(textMarkDownField).clear();
        waitForElementVisible(textField).clear();

        return this;
    }

    public AddEntryPage fillTitle(String title){
        if(title == null) throw new NullPointerException("title");
        WebElement titleField = driver.findElement(XPATH_TITLE_FIELD);

        waitForElementVisible(titleField).sendKeys(title);

        return this;
    }

    public AddEntryPage fillSlug(String slug){
        if(slug == null) throw new NullPointerException("slug");
        WebElement slugField = driver.findElement(XPATH_SLUG_FIELD);

        waitForElementVisible(slugField).sendKeys(slug);

        return this;
    }

    public AddEntryPage fillTextMarkdown(String textMarkdown){
        if(textMarkdown == null) throw new NullPointerException("textMarkdown");
        WebElement textMarkdownField = driver.findElement(XPATH_TEXT_MARKDOWN_FIELD);

        waitForElementVisible(textMarkdownField).sendKeys(textMarkdown);

        return this;
    }
    public AddEntryPage fillText(String text){
        if(text == null) throw new NullPointerException("text");
        WebElement textElement = driver.findElement(XPATH_TEXT_FIELD);

        waitForElementVisible(textElement).sendKeys(text);

        return this;
    }

    public AddEntryPage save(){
        WebElement button = driver.findElement(XPATH_SAVE_BUTTON);

        waitForElementVisible(button).click();

        return this;
    }
}
