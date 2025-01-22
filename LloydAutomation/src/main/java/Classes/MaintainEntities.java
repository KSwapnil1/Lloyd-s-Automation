package Classes;

import com.incessant.bon34.controls.*;
import com.incessant.bon34.tests.CucumberGenericTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MaintainEntities extends CucumberGenericTest {
    public final Link maintainEntitiesLink;
    public final Link updateAuditorLink;
    public final Link updateCarrierLink;
    public final Link selectAuditorNameLink;
    public final TextField fillTownCityTextField;
    public final TextField fillDomicileTextField;
    public final TextField enterPhoneCountryCodeTextField;
    public final TextField enterPhoneNumber;
    public final Button updateAuditorButton;
    public final Button closeButton;
    public final Link selectCarrierNameLink;
    public final TextField auditEmailAddressTextField;
    public final TextField contactNumberTextField;
    public final Button updateCarrierButton;
    public final Link updateBrokerLink;
    public final Link selectBrokerNameLink;
    public final TextField brokerAuditEmailAddressTextField;
    public final TextField brokerContactNumberTextField;
    public final Button updateBrokerButton;

    public MaintainEntities() {
        maintainEntitiesLink = new Link(By.xpath("//span[text()='Maintain Entities']"));
        updateAuditorLink = new Link(By.xpath("//span[text()='Update Auditor']"));
        selectAuditorNameLink = new Link(By.xpath("//span[text()='Ameya Consulting LLC']"));
        fillTownCityTextField = new TextField(By.id("c7c2356d"));
        fillDomicileTextField = new TextField(By.id("affccdd1"));
        enterPhoneCountryCodeTextField = new TextField(By.id("56e2d161"));
        enterPhoneNumber = new TextField(By.id("bc93c905"));
        updateAuditorButton = new Button(By.xpath("(//div[@class='pzbtn-lft'])[3]"));
        closeButton = new Button(By.xpath("//div[text()='Close' and @class='pzbtn-mid']"));
        updateCarrierLink = new Link(By.xpath("//span[text()='Update Carrier']"));
        selectCarrierNameLink = new Link(By.xpath("//span[text()='Apollo Syndicate Management Limited']"));
        auditEmailAddressTextField = new TextField(By.xpath("(//span/input[@type='text'])[1]"));
        contactNumberTextField = new TextField(By.xpath("(//span/input[@type='text'])[3]"));
        updateCarrierButton =new Button(By.xpath("//div[text()='Update Carrier']"));
        updateBrokerLink = new Link(By.xpath("//span[text()='Update Broker']"));
        selectBrokerNameLink = new Link(By.xpath("//span[text()='3 Dimensional Insurance Ltd']"));
        brokerAuditEmailAddressTextField = new TextField(By.xpath("(//span/input[@type='text'])[1]"));
        brokerContactNumberTextField = new TextField(By.xpath("(//span/input[@type='text'])[2]"));
        updateBrokerButton = new Button(By.xpath("//div[text()='Update Broker']"));
    }

    public void clickOnMaintainEntities() throws InterruptedException {
        Actions action = new Actions(getDriver());
        WebElement leftPanelMenu = getDriver().findElement(By.xpath("//ul[contains(@class,'menu-vertical menu-bar-regular')]"));
        action.moveToElement(leftPanelMenu).build().perform();
        ReusableMethods.hardWait(1000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement searchElement = getDriver().findElement(By.xpath("//span[text()='Work Management']"));
        js.executeScript("arguments[0].scrollIntoView();", searchElement);
        maintainEntitiesLink.click();
    }

    public void updateAuditorOption() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        updateAuditorLink.click();
    }

    public void updateCarrierOption() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        updateCarrierLink.click();
    }

    public void updateBrokerOption() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        updateBrokerLink.click();
    }

    public void switchToUpdateAuditorPageIframe() throws InterruptedException {
        getDriver().switchTo().defaultContent();
        WebElement updateAuditorIframe = getDriver().findElement(By.xpath("//iframe[@id='PegaGadget0Ifr']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 3000);
        wait.until(ExpectedConditions.visibilityOf(updateAuditorIframe));
        getDriver().switchTo().frame(updateAuditorIframe);
    }

    public void switchToUpdateCarrierPageIframe() throws InterruptedException {
        getDriver().switchTo().defaultContent();
        WebElement updateCarrierIframe = getDriver().findElement(By.xpath("//iframe[@id='PegaGadget0Ifr' and @title='Update Carrier']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 3000);
        wait.until(ExpectedConditions.visibilityOf(updateCarrierIframe));
        getDriver().switchTo().frame(updateCarrierIframe);
    }

    public void switchToUpdateBrokerPageIframe() throws InterruptedException {
        getDriver().switchTo().defaultContent();
        WebElement updateBrokerIframe = getDriver().findElement(By.xpath("//iframe[@id='PegaGadget0Ifr' and @title='Update Broker']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 3000);
        wait.until(ExpectedConditions.visibilityOf(updateBrokerIframe));
        getDriver().switchTo().frame(updateBrokerIframe);
    }

    public void selectAuditor() throws InterruptedException {
        switchToUpdateAuditorPageIframe();
        ReusableMethods.hardWait(1000);
        WebElement selectAuditorName = getDriver().findElement(By.xpath("//input[@class='autocomplete_input ac_ams_autocomplete']"));
        selectAuditorName.sendKeys(String.valueOf(Keys.ARROW_DOWN));
        selectAuditorName.sendKeys("Ameya Consulting LLC");
        selectAuditorNameLink.click();
    }

    public void selectCarrier() throws InterruptedException {
        switchToUpdateCarrierPageIframe();
        ReusableMethods.hardWait(1000);
        WebElement selectCarrierName = getDriver().findElement(By.xpath("//input[@name='$PCarriersInformation$pLeadManagingAgent']"));
        selectCarrierName.sendKeys(String.valueOf(Keys.ARROW_DOWN));
        selectCarrierName.sendKeys("Apollo Syndicate Management Limited");
        selectCarrierNameLink.click();
    }

    public void selectBroker() throws InterruptedException {
        switchToUpdateBrokerPageIframe();
        ReusableMethods.hardWait(1000);
        WebElement selectBrokerName = getDriver().findElement(By.xpath("//input[@name='$PBrokerInformation$pBrokerName']"));
        selectBrokerName.sendKeys(String.valueOf(Keys.ARROW_DOWN));
        selectBrokerName.sendKeys("3 Dimensional Insurance Ltd");
        selectBrokerNameLink.click();
    }

    public void updateAuditorInfo() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        fillTownCityTextField.clear();
        fillTownCityTextField.enterText("Manchester");
        fillDomicileTextField.clear();
        fillDomicileTextField.enterText("United Kingdom");
        enterPhoneCountryCodeTextField.clear();
        enterPhoneCountryCodeTextField.enterText("0161");
        enterPhoneNumber.clear();
        enterPhoneNumber.enterText("989077867");
    }

    public void updateCarrierInfo() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        auditEmailAddressTextField.clear();
        auditEmailAddressTextField.enterText("appolo@lloyds.com");
        contactNumberTextField.clear();
        contactNumberTextField.enterText("+01762244675");
    }

    public void updateBrokerInfo() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        brokerAuditEmailAddressTextField.clear();
        brokerAuditEmailAddressTextField.enterText("ThreedimensionalInsuranceLtd@lloyds.com");
        brokerContactNumberTextField.clear();
        brokerContactNumberTextField.enterText("+012199887709");
    }


    public void clickOnUpdateAuditorButton() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        updateAuditorButton.click();
    }

    public void clickOnUpdateCarrierButton() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        updateCarrierButton.click();
    }

    public void clickOnUpdateBrokerButton() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        updateBrokerButton.click();
    }

    public boolean isSuccessfulUpdateMessageDisplayed() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        WebElement displayMessage = getDriver().findElement(By.xpath("//div[text()='Update Successful!']"));
        String dM = displayMessage.getText();
        System.out.println(dM);
        return true;
    }

    public void clickOnCloseButton() throws InterruptedException {
        ReusableMethods.hardWait(1000);
        closeButton.click();
    }



}
