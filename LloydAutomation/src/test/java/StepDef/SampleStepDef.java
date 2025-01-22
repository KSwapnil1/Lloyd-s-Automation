package StepDef;

import Classes.ARFForm;
import Classes.Application;
import Classes.RFIProcess;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SampleStepDef {
    Application app = new Application();
    RFIProcess rfiProcess = new RFIProcess();
    ARFForm arfForm = new ARFForm();
    String arfId = "";

    @When("User enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        app.UserEntersUserNameAndPassword("", "");
        app.clickOnLogin();
    }

    @Then("Home page shall be displayed")
    public void home_page_shall_be_displayed() throws InterruptedException {
    }

    @Then("User clicks on the Auditor RFI process menu option")
    public void userClicksOnTheAuditorRFIProcessMenuOption() {
    }

    @Given("^User login into the application as ([A-Za-z]+\\sManager)$")
    public void user_Login_Into_The_Application(String userRole) throws InterruptedException {
        String username;
        String password;
        System.out.println("Userrole: " + userRole);
        switch (userRole) {
            case "CAF Manager":
                username = "testcaf";
                password = "rules";
                break;

            case "Auditor Manager":
                username = "testauditor1";
                password = "rules";
                break;

            case "Carrier Manager":
                username = "testcarrier1";
                password = "rules";
                break;

            default:
                username = "testcaf";
                password = "rules";
                break;
        }
        System.out.println("Username and password: " + username + " : " + password);
        app.UserEntersUserNameAndPassword(username, password);
        app.clickOnLogin();
    }

    @And("User creates the ARF Case ID")
    public void user_Creates_The_ARF_Case_ID() throws InterruptedException {
        rfiProcess.clickOnRFIProcess();
        rfiProcess.clickAuditCompanyCheckbox();
        rfiProcess.clickOnCreateRFIButton();
        rfiProcess.clickOnOkButton();
        rfiProcess.clickOnCloseButton();
        rfiProcess.clickOnRFIProcess();
        rfiProcess.clickAuditCompanyCheckbox();
        rfiProcess.clickOnCreateRFIButton();
        arfId = rfiProcess.fetchARFCaseId();
        assertNotNull("ASSERTION FAILED: Case ID is Null", arfId);
    }

    @And("User logs out from the application")
    public void userLogsOutFromTheApplication() throws InterruptedException {
        app.logOut();
    }

    @And("User opens ARF form")
    public void userOpensARFForm() throws InterruptedException {
        rfiProcess.openArfForm(arfId);
    }

    @And("User fills and submit the ARF form for newly created ARF case ID")
    public void userFillsAndSubmitTheARFFormForNewlyCreatedARFCaseID() throws InterruptedException {
        arfForm.enterMandatoryData();
    }

    @And("User accepts and submits the ARF case")
    public void userShouldBeAbleToAcceptAndSubmitTheARFCase() throws InterruptedException {
        arfForm.acceptAndSubmitARFFormByCAFManager();
    }

    @And("^User sees the status as ([A-Za-z]+-[A-Za-z]+)$")
    public void userShouldBeAbleToSeeTheStatus(String status) {
        assertEquals("ASSERTION FAILED: ARF ID " + arfId + " status is not " + status + ". Current status is: " + arfForm.getArfIdStatus(), status, arfForm.getArfIdStatus());
    }
}
