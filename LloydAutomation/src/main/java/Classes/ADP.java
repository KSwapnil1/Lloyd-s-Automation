package Classes;

import com.incessant.bon34.controls.*;
import com.incessant.bon34.tests.CucumberGenericTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ADP extends CucumberGenericTest {
    public final Link preSchedulingLink;
    public final Link adpLink;
    public final Checkbox carrierNameCheckBox;
    public final Button submitButton;
    public final Button nextSubmitButton;
    public final Button closeButton;
    public final Button nextPageButton;
    public final Dropdown firstAuditorDropDown;
    public final Button addAuditorButton;
    public final Dropdown secondAuditorDropDown;
    public final Dropdown thirdAuditorDropDown;
    public final Checkbox firstAuditorCHCheckBox;
    public final Checkbox firstAuditorTPACheckBox;
    public final Checkbox secondAuditorCHCheckBox;
    public final Checkbox thirdAuditorTPACheckBox;
    //public final TextField adpCaseStatusTextField;



    public ADP(){
        preSchedulingLink = new Link(By.xpath("//span[@class='menu-item-icon-imageclass pi pi-check-circle']"));
        adpLink = new Link(By.xpath("//span[text()='Audit Panel Request']"));
        carrierNameCheckBox = new Checkbox(By.xpath("(//input[@type='checkbox'])[4]"));
        submitButton = new Button(By.xpath("//button[text()='Submit']"));
        nextSubmitButton = new Button(By.xpath("//div[text()='Submit']"));
        closeButton = new Button(By.xpath("//div[text()='Close']"));
        nextPageButton = new Button(By.xpath("//button[@title='Next Page' and @class='nextPage']"));
        firstAuditorDropDown = new Dropdown(By.xpath("//select[@class='ams_dropdown']"));
        addAuditorButton = new Button(By.xpath("//button[@name='UpdateAuditPanel_pyWorkPage_42']"));
        secondAuditorDropDown = new Dropdown(By.xpath("(//select[@class='ams_dropdown'])[2]"));
        thirdAuditorDropDown = new Dropdown(By.xpath("(//select[@class='ams_dropdown'])[3]"));
        firstAuditorCHCheckBox = new Checkbox(By.xpath("(//input[@name='$PpyWorkPage$pAuditorsPanel$l1$pIsAuditorofCH'])[2]"));
        firstAuditorTPACheckBox = new Checkbox(By.xpath("(//input[@name='$PpyWorkPage$pAuditorsPanel$l1$pIsAuditorofTPA'])[2]"));
        secondAuditorCHCheckBox = new Checkbox(By.xpath("(//input[@name='$PpyWorkPage$pAuditorsPanel$l2$pIsAuditorofCH'])[2]"));
        thirdAuditorTPACheckBox = new Checkbox(By.xpath("(//input[@name='$PpyWorkPage$pAuditorsPanel$l3$pIsAuditorofTPA'])[2]"));
     //   adpCaseStatusTextField = new TextField(By.xpath("//span[text()='Status']/following-sibling::div//a"));

    }

    public void clickOnPreScheduling() throws InterruptedException {
        Actions action = new Actions(getDriver());
        WebElement leftPanelMenu = getDriver().findElement(By.xpath("//ul[contains(@class,'menu-vertical menu-bar-regular')]"));
        action.moveToElement(leftPanelMenu).build().perform();
        ReusableMethods.hardWait(1000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement searchElement = getDriver().findElement(By.xpath("//span[text()='Work Management']"));
        js.executeScript("arguments[0].scrollIntoView();", searchElement);
        preSchedulingLink.click();
        ReusableMethods.hardWait(1000);

    }

    public void clickOnADPLink() throws InterruptedException {
        adpLink.click();
        ReusableMethods.hardWait(2000);
    }

    public void adpIframe(){
        getDriver().switchTo().defaultContent();
        WebElement adpIframe = getDriver().findElement(By.xpath("//iframe[@name='PegaGadget0Ifr']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        wait.until(ExpectedConditions.visibilityOf(adpIframe));
        getDriver().switchTo().frame(adpIframe);
    }

    public void clickOnCheckBox() throws InterruptedException {
        carrierNameCheckBox.click();
        ReusableMethods.hardWait(1000);
    }

    public void clickOnSubmitButton() throws InterruptedException {
        submitButton.click();
        ReusableMethods.hardWait(2000);
    }

    public void clickOnNextSubmitButton() throws InterruptedException {
        nextSubmitButton.click();
        ReusableMethods.hardWait(1000);
    }

    public void clickOnCloseButton(){
        closeButton.click();
        getDriver().switchTo().defaultContent();
    }

    public String fetchADPCaseId() throws InterruptedException {
        Thread.sleep(1000);
        adpIframe();
        WebElement adpCaseId = getDriver().findElement(By.xpath("(//div[@class='oflowDivM '])[5]"));
        String caseId = adpCaseId.getText();
        System.out.println("Case ID Created"+caseId);
        getDriver().switchTo().defaultContent();
        return caseId;

    }

    public WebElement linkWithDynamicText(String text){

        return getDriver().findElement(By.xpath("//a[text()='"+text+"']"));
    }

    public void openADPForm(String adpId) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3000);

        try{
            wait.until(ExpectedConditions.visibilityOf(linkWithDynamicText(adpId)));
        } catch(Exception e) {
            int i = 0;
            try {
                nextPageButton.click();
                WebElement totalPagesLabel = getDriver().findElement(By.xpath("//button[@title='Next Page' and @class='nextPage']/../../preceding-sibling::td[1]//label"));
                System.out.println("Total Page________" + totalPagesLabel);

                int totalPages = Integer.parseInt(totalPagesLabel.getText());
                for (i = 2; i < totalPages; i++) {
                    wait.until(ExpectedConditions.visibilityOf(linkWithDynamicText(adpId)));
                }
            } catch (Exception ex) {
                System.out.println("ARF ID not found on Page: " + i);
                nextPageButton.click();
            }

        }

        linkWithDynamicText(adpId).click();
        adpIframe();
    }

    public void selectPreferredAuditorsWithCheckBoxes() throws InterruptedException {

        firstAuditorDropDown.selectFromDropdownByText("ABC Consulting PVT LTD");
        ReusableMethods.hardWait(2000);
        firstAuditorCHCheckBox.click();
        ReusableMethods.hardWait(2000);
        firstAuditorTPACheckBox.click();
        ReusableMethods.hardWait(2000);
        addAuditorButton.click();
        ReusableMethods.hardWait(2000);
        secondAuditorDropDown.selectFromDropdownByText("Alan Gray Inc");
        ReusableMethods.hardWait(2000);
        secondAuditorCHCheckBox.click();
        ReusableMethods.hardWait(2000);
        addAuditorButton.click();
        ReusableMethods.hardWait(2000);
        thirdAuditorDropDown.selectFromDropdownByText("AM Associates");
        ReusableMethods.hardWait(2000);
        thirdAuditorTPACheckBox.click();
        ReusableMethods.hardWait(1000);
        nextSubmitButton.click();
    }

    public String adpCaseStatus(){
        WebElement adpCaseStatusTextField = getDriver().findElement(By.xpath("//span[text()='Status']/following-sibling::div//a"));
        String status = adpCaseStatusTextField.getText();
        return status;

    }



}
