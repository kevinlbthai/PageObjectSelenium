package dsi;

import org.openqa.selenium.WebDriver;

public class DslTodoUser {
    private final WebDriver driver;
    private final DslTodoAppNavigator navigate;

    public DslTodoUser(final WebDriver driver) {
        this.driver = driver;
        navigate = new DslTodoAppNavigator(driver);
    }

    public void createTodoList(final DslTodoListName listName) {
        DslTodoListsPage todolists =
                            navigate.toTodoListsPage();
        todolists.enterTodoListName(listName.getName());
    }
}
