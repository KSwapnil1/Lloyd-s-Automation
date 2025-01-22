package utilities;

import com.incessant.bon34.core.BrowserProperties;
import com.incessant.bon34.core.Environment;
import com.incessant.bon34.core.GenericMethods;
import com.incessant.bon34.drivers.DriverType;
import com.incessant.bon34.utilities.PropertyManager;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;

public class BrowserUtil extends GenericMethods {

    PropertyManager propertyManager = new PropertyManager();
    Properties properties = propertyManager.getPropertyValues(this.propertiesFile);
    public void initialiseBrowser(String testName) {

//        Constants.HEADLESS = properties.getProperty("headless");
        Date date = new Date();
        System.out.println("Start Time:" + date.toString());
        this.readProperties();
        Environment environmentObj = new Environment(getEnvironment());
        this.setStartTime((double)System.currentTimeMillis());
        DriverType tempDriverType;
        DriverInitilization tempDriverType2;
        if (System.getProperty("browser")==null) {
             tempDriverType = DriverType.valueOf(this.driverType);
             tempDriverType2 = DriverInitilization.valueOf(this.driverType);
        }else {
            tempDriverType = DriverType.valueOf(System.getProperty("browser"));
            tempDriverType2 = DriverInitilization.valueOf(System.getProperty("browser"));
        }
            BrowserProperties browserProperties = new BrowserProperties(this.maxAttempts, this.timeout, tempDriverType, environmentObj.getEnvironment(), environmentObj.getEnvURL());

        this.setHappyPath(false);
        tempDriverType2.instantiateDriver(browserProperties,Boolean.parseBoolean("false"));
        try {
            this.getBrowser().getLogWriter().instantiateLogger(this.getTestName());
        }catch (Exception e){
            System.out.println("log not initilalized");
        }
        this.log("Start Time:" + date.toString(), Level.INFO);
        this.log("Environment: " + environmentObj.getEnvironment());
        this.log("Environment URL: " + environmentObj.getEnvURL());
        setDriverType(tempDriverType);
        this.log("Browser Type: " + this.getBrowser().getDriverType().toString());
        this.setOriginalBrowser(this.getBrowser().getDriverType());
        this.setTestName(testName);
    }


}
