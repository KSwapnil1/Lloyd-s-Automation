package StepDef;

import Classes.ADP;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertNotNull;

public class ADPStepDef {
    ADP objectOFADP = new ADP();
    String adpId = "";

    @And("User creates the ADP case for carrier")
    public void userCreatesTheADPCaseForCarrier() throws InterruptedException {
        objectOFADP.clickOnPreScheduling();
        objectOFADP.clickOnADPLink();
        objectOFADP.adpIframe();
        objectOFADP.clickOnCheckBox();
        objectOFADP.clickOnSubmitButton();
        objectOFADP.clickOnNextSubmitButton();
        objectOFADP.clickOnCloseButton();
        objectOFADP.clickOnPreScheduling();
        objectOFADP.clickOnADPLink();
        objectOFADP.adpIframe();
        objectOFADP.clickOnCheckBox();
        objectOFADP.clickOnSubmitButton();
        adpId = objectOFADP.fetchADPCaseId();
        assertNotNull("ASSERTION FAILED: Case ID is Null", adpId);
        System.out.println(adpId);
    }

    @And("User Successfully resolve the ADP case")
    public void userSuccessfullyResolveTheADPCase() throws InterruptedException {
        objectOFADP.openADPForm(adpId);
        objectOFADP.selectPreferredAuditorsWithCheckBoxes();
    }

    @Then("User sees the status as Resolved-Completed for ADP Case")
    public void userSeesTheStatusAsResolvedCompletedForADPCase() {
        objectOFADP.adpCaseStatus();

    }
}
