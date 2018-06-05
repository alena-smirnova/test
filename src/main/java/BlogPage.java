import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BlogPage extends BasePage {

    private final String Url = "http://igorakintev.ru/blog/";

    private static final By XPATH_TITLES = By.xpath("//div[@id='entries']/h2/a");

    public BlogPage(WebDriver driver, int timeout){
        super(driver, timeout);
    }

    @Override
    public String getUrl() {
        return Url;
    }

    public boolean containsEntry(String title) {
        if(title == null) throw new NullPointerException("title");

        List<WebElement> titles = driver.findElements(XPATH_TITLES);

        for(int i = 0; i < titles.size(); i++) {
            String text =  titles.get(i).getText();
            if(text.equals(title)) {
                return true;
            }
        }
        return false;
    }
}
