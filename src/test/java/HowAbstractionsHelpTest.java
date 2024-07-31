import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowAbstractionsHelpTest {

    private WebDriver driver;

    @BeforeTest
    public void setupData(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist");
    }

    @Test
    public void canCreateATodoList(){

        ATodoAppNavigator navigate = new ATodoAppNavigator(driver);
        ATodoListsPage todoLists = navigate.to().todoListsPage();

        todoLists.enterTodoListName("my todo list");
        Assert.assertEquals("my-todo-list",
                todoLists.getDisplayedListText("my-todo-list"));

    }

    @Test
    public void canCreateAnotherTodoList() {

        String listName = new ATodoAppUser(driver).createsATodoList();
        Assert.assertEquals(listName,
                new ATodoListsPage(driver).getDisplayedListText(listName));

    }

    /*@AfterTest
    public void closeBrowser(){
        driver.close();
    } */
}
