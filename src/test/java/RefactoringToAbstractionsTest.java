import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RefactoringToAbstractionsTest {

    @Test
    public void aTestWithNoAbstractions(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");

        createToDoList(driver, "My First Todo List");

        WebElement renderName;
        String listDataId = "My-First-Todo-List";

        renderName = getToDoListNameElement(driver, listDataId);

        Assertions.assertEquals(listDataId,
                renderName.getText());

        driver.close();
    }

    private static WebElement getToDoListNameElement(WebDriver driver, String listDataId) {
        WebElement renderName;
        final WebElement listitem = driver.findElement(
                By.cssSelector(
                        "li[data-id='" + listDataId + "']"));

        renderName = listitem.findElement(
                By.tagName("label"));
        return renderName;
    }

    private static void createToDoList(WebDriver driver, String listName) {
        final WebElement todoListNameInput =
                driver.findElement(
                        By.cssSelector("input.new-todo-list"));

        todoListNameInput.sendKeys(
                listName + Keys.ENTER);
    }
}
