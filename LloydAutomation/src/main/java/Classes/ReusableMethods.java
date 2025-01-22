package Classes;


import com.incessant.bon34.tests.CucumberGenericTest;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;


public class ReusableMethods extends CucumberGenericTest {

    public static String RandomString;

    public void writeCSVFile() throws IOException {
        String path = "C:\\Automation\\Testmvn_\\Testmvn\\TestData\\TestDataLGIM.csv";

        RandomString =ReusableMethods.generateRandomString();

        // code to input data in .csv file
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Proposal Request ID", "Proposal Request Name", "Opportunity: Opportunity Name", "Engagement Status", "Organisation: Organisation Name", "Client/Prospect Name", "Registered Domicile", "Client/Prospect Type", "Existing Client or Prospect", "Current LGIM Assets", "Extra Product Details", "GIPS Composite Records / Scope or Quasar"
                , "LGIM Contracting Entity", "Currency", "Scheme Domicile", "Requires Solution team engagement?", "Consultancy: Organisation Name", "Portal", "Segregated or Pooled?", "Vehicle Type", "Sales Channel", "Scheme Type", "Total Estimated Revenue (converted) Currency", "Total Estimated Revenue (converted)", "Total Mandate Size (converted) Currency", "Total Mandate Size (converted)", "Vanilla?,If Non Vanilla - Approved?"
                , "If Non Vanilla - Who Approved?", "Request Details", "Client or LGIM Europe led solution?", "Client Direction ? Preferences", "Product Proposal Adaptation", "Recording Preferences", "Engagement Requestor: Full Name", "Owner: Full Name", "Client Director: Full Name", "Distribution Lead: Full Name", "Distribution Team", "LGIM Business Area", "Engagement Received (from Client)", "Engagement Deadline (Client)", "Engagement Submission"
                , "Record Type", "Record URL", "Created Date", "Last Modified Date", "Parent Proposal Request: Proposal Request Name", "Is Service Request", "Is Parent", "Is Child", "# Child Proposals", "Type", "Source", "D&I Questions?", "ESG Questions?", "Complexity", "Proposal Request Product ID", "Name", "Opportunity Product: Opportunity Product Number", "Business Area: Business Area Name", "Strategic Product Group: Strategic Product Group Name", "Product Type: Product Type Name"
                , "Fee Rate/Flat Fee", "Mandate Size (converted) Currency", "Mandate Size (converted)", "Fee Basis", "Revenue (converted) Currency", "Revenue (converted)\n"));

        csvPrinter.printRecord(RandomString, "PR-00000040", "Sears LDI and B&M", "In Progress", "Barnett Waddingham LLP", "Barnett Waddingham LLP", "United Kingdom", "Corporate ? Other", "New Client", "n/a", "Pooled/bespoke/seg yet to be determined", "n/a", "LGIM Limited", "GBP", "United Kingdom", "Yes", "", "", "Pooled", "Pooled PMC", "UK - DB Pension (Corporate)", "DB Pension (Corporate)", "GBP", "313300", "GBP", "257000000", "Vanilla", "Approved_to_Proceed", "", "Client deadline MIDDAY 28th March. Previously a client in 2005"
                , "", "", "", "", "Sam O'Riordan,Thomas Doggett", "", "", "IB UK Distribution", "Distribution Manager", "09-03-2023 15:00", "28-03-2023 12:00", "10-03-2023 17:11", "Sales RFP", "https://lgim-inst--lgimqa.sandbox.my.salesforce.com/a5v3z00000GeS1V", "10-03-2023 15:00", "29-05-2023 12:45", "", "0", "0", "0", "", "", "", "", "", "", "a5u3z000000DEsy", "PRP-00000047", "OP-28273", "LDI Solutions", "LDI", "", "9", "GBP", "172000000", "Basis Points", "GBP", "154800");

        csvPrinter.flush();
        csvPrinter.close();


    }

    public void generateRandomInt() {
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(10000);
        int rand_int2 = rand.nextInt(10000);

        System.out.println(rand_int1);
    }

    public static void hardWait(int milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
    }

    public static String generateRandomString() {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int length = 8;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        String randomstring = sb.toString();
        System.out.println(randomstring);
        return randomstring;
    }

}













