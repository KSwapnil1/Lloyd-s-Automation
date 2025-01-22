package Classes;

import com.incessant.bon34.controls.Button;
import com.incessant.bon34.controls.Link;
import com.incessant.bon34.tests.CucumberGenericTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RFIProcess extends CucumberGenericTest {
    private final Link auditorRFIProcesslink;
    private final Link selectAuditCompanyCheckbox;
    private final Button createRFIButton;
    private final Button clickOKButton;
    private final Button clickCloseButton;
    private final Button nextPageButton;



    public RFIProcess() {
        selectAuditCompanyCheckbox = new Link(By.xpath("(//div[@id='PEGA_GRID_CONTENT']//../../../..//input[@type='checkbox'])[24]"));
        auditorRFIProcesslink = new Link(By.xpath("//span[contains(text(),'Auditor RFI Process')]"));
        createRFIButton = new Button(By.xpath("//button[text()='Create RFI']"));
        clickOKButton = new Button(By.xpath("//button[text()='OK']"));
        clickCloseButton = new Button(By.xpath("//div[text()='Close']"));
        nextPageButton = new Button(By.xpath("//button[@title='Next Page' and @class='nextPage']"));
    }

    public WebElement linkWithDynamicText(String text){

        return getDriver().findElement(By.xpath("//a[text()='"+text+"']"));
    }

    public void clickOnRFIProcess() throws InterruptedException {
        Actions action = new Actions(getDriver());
        WebElement leftPanelMenu = getDriver().findElement(By.xpath("//ul[contains(@class,'menu-vertical menu-bar-regular')]"));
        action.moveToElement(leftPanelMenu).build().perform();
        ReusableMethods.hardWait(3000);
        auditorRFIProcesslink.click();
        WebElement mainHeader = getDriver().findElement(By.xpath("//div[text()='Delegated Audit Manager']"));
        action.moveToElement(mainHeader).click().build().perform();
        ReusableMethods.hardWait(3000);
    }

    public void clickAuditCompanyCheckbox() throws InterruptedException {
        switchToAuditorRFIPageIframe();
        selectAuditCompanyCheckbox.click();
    }

    public void switchToAuditorRFIPageIframe() throws InterruptedException {
        getDriver().switchTo().defaultContent();
        WebElement auditorRFIIframe = getDriver().findElement(By.xpath("//iframe[@name='PegaGadget0Ifr']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        wait.until(ExpectedConditions.visibilityOf(auditorRFIIframe));
        getDriver().switchTo().frame(auditorRFIIframe);
    }

    public void clickOnCreateRFIButton() throws InterruptedException {
        createRFIButton.click();

    }

    public void clickOnOkButton() {
        clickOKButton.click();
    }

    public void clickOnCloseButton() {
        clickCloseButton.click();
        getDriver().switchTo().defaultContent();
    }

    public String fetchARFCaseId() throws InterruptedException {
        Thread.sleep(1000);
        switchToAuditorRFIPageIframe();
        WebElement arfCaseId = getDriver().findElement(By.xpath("//div[text()='Case ID']/../../../../following-sibling::tr/td[4]//span"));
        String caseId = arfCaseId.getText();
        System.out.println("Case ID Created"+caseId);
        getDriver().switchTo().defaultContent();
        return caseId;

    }

    public void openArfForm(String arfId) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3000);

        try{
            wait.until(ExpectedConditions.visibilityOf(linkWithDynamicText(arfId)));
        } catch(Exception e) {
            int i = 0;
            try {
                nextPageButton.click();
                WebElement totalPagesLabel = getDriver().findElement(By.xpath("//button[@title='Next Page' and @class='nextPage']/../../preceding-sibling::td[1]//label"));
                System.out.println("Total Page________" + totalPagesLabel);

                int totalPages = Integer.parseInt(totalPagesLabel.getText());
                for (i = 2; i < totalPages; i++) {
                    wait.until(ExpectedConditions.visibilityOf(linkWithDynamicText(arfId)));
                }
            } catch (Exception ex) {
                System.out.println("ARF ID not found on Page: " + i);
                nextPageButton.click();
            }

        }

        linkWithDynamicText(arfId).click();
        switchToAuditorRFIPageIframe();
    }
}
