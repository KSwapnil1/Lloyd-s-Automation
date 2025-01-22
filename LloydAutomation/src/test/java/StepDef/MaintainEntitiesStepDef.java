package StepDef;

import Classes.MaintainEntities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MaintainEntitiesStepDef {
    MaintainEntities maintainEntitiesMenuOption = new MaintainEntities();



    @And("User clicks on Maintain Entities Menu Option")
    public void userClicksOnMaintainEntitiesMenuOption() throws InterruptedException {
        maintainEntitiesMenuOption.clickOnMaintainEntities();

    }


    @When("User clicks on Update Auditor option")
    public void userClicksOnUpdateAuditorOption() throws InterruptedException {
        maintainEntitiesMenuOption.updateAuditorOption();

    }

    @And("User select the Auditor Name from the list")
    public void userSelectTheAuditorNameFromTheList() throws InterruptedException {
        maintainEntitiesMenuOption.selectAuditor();

    }

    @And("User updates the Auditor's information")
    public void userUpdatesTheAuditorSInformation() throws InterruptedException {
        maintainEntitiesMenuOption.updateAuditorInfo();
    }

    @And("User clicks on Update Auditor button")
    public void userClicksOnUpdateAuditorButton() throws InterruptedException {
        maintainEntitiesMenuOption.clickOnUpdateAuditorButton();
    }

    @Then("User sees the Update Successful message")
    public void userSeesTheUpdateSuccessfulMessage() throws InterruptedException {
        assertTrue(maintainEntitiesMenuOption.isSuccessfulUpdateMessageDisplayed());

    }

    @And("User clicks on close button")
    public void userClicksOnCloseButton() throws InterruptedException {
        maintainEntitiesMenuOption.clickOnCloseButton();
    }


    @When("User clicks on Update Carrier option")
    public void userClicksOnUpdateCarrierOption() throws InterruptedException {
        maintainEntitiesMenuOption.updateCarrierOption();
    }


    @And("User select the Carrier Name from the list")
    public void userSelectTheCarrierNameFromTheList() throws InterruptedException {
        maintainEntitiesMenuOption.selectCarrier();
    }


    @And("User updates the Carrier's information")
    public void userUpdatesTheCarrierSInformation() throws InterruptedException {
        maintainEntitiesMenuOption.updateCarrierInfo();
    }

    @And("User clicks on Update Carrier button")
    public void userClicksOnUpdateCarrierButton() throws InterruptedException {
        maintainEntitiesMenuOption.clickOnUpdateCarrierButton();
    }


    @When("User clicks on Update Broker option")
    public void userClicksOnUpdateBrokerOption() throws InterruptedException {
        maintainEntitiesMenuOption.updateBrokerOption();
    }

    @And("User select the Broker Name from the list")
    public void userSelectTheBrokerNameFromTheList() throws InterruptedException {
        maintainEntitiesMenuOption.selectBroker();
    }

    @And("User updates the Broker's information")
    public void userUpdatesTheBrokerSInformation() throws InterruptedException {
        maintainEntitiesMenuOption.updateBrokerInfo();
    }

    @And("User clicks on Update Broker button")
    public void userClicksOnUpdateBrokerButton() throws InterruptedException {
        maintainEntitiesMenuOption.clickOnUpdateBrokerButton();
    }
}
