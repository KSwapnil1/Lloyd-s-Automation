package Classes;

import com.incessant.bon34.controls.*;
import com.incessant.bon34.tests.CucumberGenericTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ARFForm extends CucumberGenericTest {
    private final TextField addressLine1TextField;
    private final TextField regionTextField;
    private final TextField postalCodeTextField;
    private final Dropdown countryDropdown;
    private final Button typeOfCompanyButton;
    private final Button partOfGroupButton;
    private final TextField pcContactNameTextField;
    private final TextField pcTelephoneTextField;
    private final TextField pcEmailTextField;
    private final Dropdown typeOfInsuranceDropdown;
    private final TextField insurerTextField;
    private final Dropdown currencyDropdown;
    private final Datefield startDateDateField;
    private final TextField territorialLimitsTextField;
    private final TextField legalJurisdictionTextField;
    private final Button policyCoverSubContractorButton;
    private final Button madeAClaimButton;
    private final TextField employeeNameTextField;
    private final Button employementStatusButton;
    private final Dropdown primaryOfficeLocationDropdown;
    private final TextField professionalServiceTextField;
    private final Link coverholderAuditsLink;
    private final TextField classOfBusinessTextField;
    private final Link aadiLink;
    private final TextField auditingInTextField;
    private final Link asiaLink;
    private final TextField languageTextField;
    private final Link polishFluentLink;
    private final TextField firstNameTextField;
    private final Link statementOfTruthLink;
    private final TextField positionAtFirmTextField;
    private final Button clickToConfirmButton;
    private final Button submitButton;
    private final Link clickOnLink;
    private final Link acceptLink;
    private final Button submitOfCAFButton;
    private final Button uploadDocButton;
    private final Dropdown docTypeDropdown;
    private final Button saveAndCloseButton;


    public ARFForm() {
        addressLine1TextField = new TextField(By.xpath("//input[@id='7157559a']"));
        regionTextField = new TextField(By.xpath("//input[@id='12103341']"));
        postalCodeTextField = new TextField(By.xpath("//input[@id='3c198ba3']"));
        countryDropdown = new Dropdown(By.id("RegisteredOffcCountry"));
        typeOfCompanyButton = new Button(By.xpath("//label[text()='Public']"));
        partOfGroupButton = new Button(By.xpath("//label[@for='2e4320c4No']"));
        pcContactNameTextField = new TextField(By.xpath("//input[@id='940c5f2e']"));
        pcTelephoneTextField = new TextField(By.xpath("//input[@id='b260f448']"));
        pcEmailTextField = new TextField(By.xpath("//input[@id='d2edfbaf']"));
        typeOfInsuranceDropdown = new Dropdown(By.id("ca0ed66a"));
        insurerTextField = new TextField(By.xpath("//input[@id='9d3721ae']"));
        currencyDropdown = new Dropdown(By.id("97541316"));
        startDateDateField = new Datefield((By.id("fbc05f55")));
        territorialLimitsTextField = new TextField(By.xpath("//input[@id='5013a070']"));
        legalJurisdictionTextField = new TextField(By.xpath("//input[@id='978bcfe5']"));
        policyCoverSubContractorButton = new Button(By.xpath("//label[@for='a70637b8No']"));
        madeAClaimButton = new Button(By.xpath("//label[@for='296fbd91No']"));
        employeeNameTextField = new TextField(By.xpath("//input[@id='ba2208bf']"));
        employementStatusButton = new Button(By.xpath("//label[text()='Employed']"));
        primaryOfficeLocationDropdown = new Dropdown(By.id("c1ee2abc"));
        professionalServiceTextField = new TextField(By.id("ee3c1015"));
        coverholderAuditsLink = new Link(By.xpath("//span[text()='Coverholder Audits']"));
        classOfBusinessTextField = new TextField(By.id("8aaad482"));
        aadiLink = new Link(By.xpath("//span[text()='Accident and Disability Insurance']"));
        auditingInTextField = new TextField(By.xpath("(//input[@id='f9ee4d3f'])[1]"));
        asiaLink = new Link(By.xpath("(//span[text()='Asia'])[2]"));
        languageTextField = new TextField(By.id("1ce2faf8"));
        polishFluentLink = new Link(By.xpath("//span[text()='Polish fluent']"));
        firstNameTextField = new TextField(By.xpath("//input[@id='ee0d5f14']"));
        statementOfTruthLink = new Link(By.xpath("//span[text()='Statement of truth']"));
        positionAtFirmTextField = new TextField(By.id("217caa09"));
        clickToConfirmButton = new Button(By.xpath("//div[text()='Click to confirm']"));
        submitButton = new Button(By.xpath("//div[contains(text(),'Submit')]"));
        clickOnLink = new Link(By.xpath("//span[text()='Confirmed on:']"));
        acceptLink = new Link(By.xpath("//label[@for='a5764789Accept']"));
        submitOfCAFButton = new Button(By.xpath("//div[text()='Submit']"));
        uploadDocButton = new Button(By.xpath("(//button[text()='Upload documents'])[3]"));
        docTypeDropdown = new Dropdown(By.xpath("//select[@name='$PdragDropFileUpload$ppxResults$l1$pFileType1']"));
        saveAndCloseButton = new Button(By.xpath("//button[text()='Save and close']"));
    }


    public void enterMandatoryData() throws InterruptedException {
        addressLine1TextField.clear();
        addressLine1TextField.enterText("21 Street, Kesklinn 2");
        regionTextField.clear();
        regionTextField.enterText("Tallinn");
        postalCodeTextField.clear();
        postalCodeTextField.enterText("14323");
        countryDropdown.selectFromDropdown("Canada");
        typeOfCompanyButton.click();
        partOfGroupButton.click();
        pcContactNameTextField.clear();
        pcContactNameTextField.enterText("Evin Lewis");
        pcTelephoneTextField.clear();
        pcTelephoneTextField.enterText("+37255946399");
        pcEmailTextField.clear();
        pcEmailTextField.enterText("evinlewis112@lloyds.com");
        typeOfInsuranceDropdown.selectFromDropdown("Errors & Omissions (E&O)");
        insurerTextField.clear();
        insurerTextField.enterText("SBI General");
        currencyDropdown.selectFromDropdown("CAD");
        ReusableMethods.hardWait(1000);
        WebElement limitsOfCoverTextField = getDriver().findElement(By.xpath("//input[@name='$PpyWorkPage$pAuditorInfo$pInsuranceDetails$l1$pLimitsOfCover']"));
        limitsOfCoverTextField.clear();
        limitsOfCoverTextField.sendKeys(Keys.NUMPAD5);
        ReusableMethods.hardWait(1000);
        WebElement deductibleTextField = getDriver().findElement(By.xpath("//input[@name='$PpyWorkPage$pAuditorInfo$pInsuranceDetails$l1$pDeductibleRFI']"));
        deductibleTextField.clear();
        deductibleTextField.sendKeys(Keys.NUMPAD2);
        startDateDateField.clear();
        startDateDateField.enterDate(2024, 11, 13);
        territorialLimitsTextField.clear();
        territorialLimitsTextField.enterText("United Kingdom");
        legalJurisdictionTextField.clear();
        legalJurisdictionTextField.enterText("Birmingham");
        policyCoverSubContractorButton.click();
        madeAClaimButton.click();
        employeeNameTextField.clear();
        employeeNameTextField.enterText("Luna Bijoy");
        employementStatusButton.click();
        primaryOfficeLocationDropdown.selectFromDropdownByIndex(1);
        professionalServiceTextField.enterText(String.valueOf(Keys.ARROW_DOWN));
        coverholderAuditsLink.click();
        classOfBusinessTextField.enterText(String.valueOf(Keys.ARROW_DOWN));
        aadiLink.click();
        auditingInTextField.enterText(String.valueOf(Keys.ARROW_DOWN));
        asiaLink.click();
        languageTextField.enterText(String.valueOf(Keys.ARROW_DOWN));
        polishFluentLink.click();
        uploadPoliciesAndProceduresDoc("ConflictsofInterestLog.docx","Conflicts of Interest + Log" );
        uploadPoliciesAndProceduresDoc("DataProtection.docx","Data Protection" );
        uploadPoliciesAndProceduresDoc("Informationsecurity.docx","Information security" );
        uploadPoliciesAndProceduresDoc("Privacynotice.docx","Privacy notice" );
        uploadPoliciesAndProceduresDoc("QualityAssuranceProcess.docx","Quality Assurance Process" );
        firstNameTextField.clear();
        firstNameTextField.enterText("Andrew Simon");
        statementOfTruthLink.click();
        positionAtFirmTextField.enterText("CEO");
        statementOfTruthLink.click();
        clickToConfirmButton.click();
        ReusableMethods.hardWait(1000);
        submitButton.click();
        ReusableMethods.hardWait(2000);
    }

    private void uploadPoliciesAndProceduresDoc(String documentName, String documentType) throws InterruptedException {
        String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\UploadDocuments\\"+documentName;
        System.out.println("Path........."+filePath);
        uploadDocButton.click();
        ReusableMethods.hardWait(1000);
        WebElement selectFile = getDriver().findElement(By.xpath("//input[@name='$PpyAttachmentPage$ppxAttachName']"));
        selectFile.sendKeys(filePath);
        ReusableMethods.hardWait(1000);
        docTypeDropdown.selectFromDropdown(documentType);
        ReusableMethods.hardWait(1000);
        saveAndCloseButton.click();
        ReusableMethods.hardWait(1000);
    }

    public void acceptAndSubmitARFFormByCAFManager() throws InterruptedException {
        clickOnLink.click();
        acceptLink.click();
        submitOfCAFButton.click();
    }

    public String getArfIdStatus() {
        WebElement arfStatus = getDriver().findElement(By.xpath("//span[text()='Status']/following-sibling::div/span"));
        return arfStatus.getText();
    }
}
