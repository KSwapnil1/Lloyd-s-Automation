import Classes.Application;
import Classes.DevPortal;
import io.cucumber.java.en.Given;

public class DevPortalStepdef {

    DevPortal dp = new DevPortal();
    Application app = new Application();
    String username = "swapnilk";
    String password = "rules";

    @Given("User login into the dev portal")
    public void user_Login_Into_The_Dev_Portal() throws InterruptedException {
        app.UserEntersUserNameAndPassword(username,password);
        app.clickOnLogin();

    }
}
