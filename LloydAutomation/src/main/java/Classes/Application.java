package Classes;


import com.incessant.bon34.controls.Button;
import com.incessant.bon34.controls.TextField;
import com.incessant.bon34.tests.CucumberGenericTest;
import org.openqa.selenium.By;

public class Application extends CucumberGenericTest {

    private final TextField userNameTextField;
    private final TextField passwordTextField;
    private final Button loginBtn;
    private final Button userMenuButton;
    private final Button logOutButton;

    public Application() {
        userNameTextField = new TextField(By.id("txtUserID"));
        passwordTextField = new TextField(By.id("txtPassword"));
        loginBtn = new Button(By.xpath("//button[@id='sub']"));
        userMenuButton = new Button(By.xpath("//button[@data-test-id='px-opr-image-ctrl']"));
        logOutButton = new Button(By.xpath("//span[text()='Log off']"));
    }

    public void UserEntersUserNameAndPassword(String username, String password) {
        userNameTextField.enterText(username);
        passwordTextField.enterText(By.id("txtPassword"), password);
    }

    public void clickOnLogin() throws InterruptedException {
        loginBtn.click();
        Thread.sleep(2000);
    }

    public void logOut() throws InterruptedException {
        getDriver().switchTo().defaultContent();
        userMenuButton.click();
        ReusableMethods.hardWait(1000);
        logOutButton.click();
    }
}



