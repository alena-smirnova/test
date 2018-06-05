import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.*;

public class IgorAkintevTests {

    private static WebDriver driver;
    private static final int timeout = 10;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void Test() {
        final String username = "silenium";
        final String password = "super_password";
        final String DashboardTitle = "Панель управления";

        final String title = "Title43565463456";
        final String slug = "Slug43565463456";
        final String newEntriesTitle = "Добавить entry";

        AdminPage adminPage = new AdminPage(driver, timeout);
        adminPage.open();
        String dashboardTitle = adminPage
                .clearFields()
                .fillUsername(username)
                .fillPassword(password)
                .signIn()
                .getTitle();

        Assert.assertEquals(DashboardTitle, dashboardTitle);

        AddEntryPage addEntryPage = adminPage.openAddEntryPage();
        String addEntryTitle = addEntryPage.getTitle();

        Assert.assertEquals(newEntriesTitle, addEntryTitle);

        addEntryPage
                .clearFields()
                .fillTitle(title)
                .fillSlug(slug)
                .fillTextMarkdown(slug)
                .fillText(slug)
                .save();

        BlogPage blogPage = new BlogPage(driver, timeout);
        blogPage.open();
        Boolean text = blogPage.containsEntry(title);
                blogPage.containsEntry(title);
        Assert.assertTrue(title, text);


        EntriesPage entriesPage = new EntriesPage(driver, timeout);
        entriesPage.open();

        Assert.assertTrue(entriesPage.removeRecord(title));
    }
}
