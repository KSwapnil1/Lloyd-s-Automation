package utilities;

import com.incessant.bon34.core.Browser;
import com.incessant.bon34.core.BrowserProperties;
import com.incessant.bon34.core.WebDriverException;
import com.incessant.bon34.drivers.SupportedDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.logging.Level;

public enum DriverInitilization {
    CHROME {
        public void instantiateDriver(BrowserProperties browserProperties,boolean runInheadless) {
            ChromeOptions options = new ChromeOptions();
            if (runInheadless) {
                options.addArguments("--headless");
            }
           // options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
            options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            options.addArguments(new String[]{"--lang=en-GB"});
            Browser browser = null;
            ChromeDriver chromeDriver = null;
            boolean driverStarted = false;

            try {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                chromeDriver = new ChromeDriver(options);
                driverStarted = true;
            } catch (WebDriverException var8) {
            }

            if (!driverStarted) {
                try {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    chromeDriver = new ChromeDriver(options);
                    driverStarted = true;
                } catch (WebDriverException var7) {
                }
            }

            if (!driverStarted) {
                throw new WebDriverException("Could not load correct chromedriver");
            } else {
                SupportedDriver.getBrowsers().put(Thread.currentThread().getId(), new Browser(chromeDriver, browserProperties));
            }
        }
    },
     EDGE {
         public void instantiateDriver(BrowserProperties browserProperties,boolean runInheadless) {
             EdgeOptions capabilities = new EdgeOptions();
             System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
             capabilities.setCapability("requireWindowFocus", true);
             capabilities.setCapability("ie.browserCommandLineSwitches", "-private");
             EdgeDriver tempDriver = new EdgeDriver();
             tempDriver.setLogLevel(Level.FINEST);
             SupportedDriver.getBrowsers().put(Thread.currentThread().getId(), new Browser(tempDriver, browserProperties));
         }
     },
    WINIE {
        public void instantiateDriver(BrowserProperties browserProperties,boolean runInheadless) {
            InternetExplorerOptions capabilities =new InternetExplorerOptions();
            System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
            capabilities.setCapability("requireWindowFocus", true);
            capabilities.setCapability("ie.browserCommandLineSwitches", "-private");
            InternetExplorerDriver tempDriver = new InternetExplorerDriver(capabilities);
            tempDriver.setLogLevel(Level.FINEST);
            SupportedDriver.getBrowsers().put(Thread.currentThread().getId(), new Browser(tempDriver, browserProperties));
        }
    },
    FIREFOX {
        public void instantiateDriver(BrowserProperties browserProperties,boolean runInheadless) {
            FirefoxOptions capabilities = new FirefoxOptions();
            capabilities.setBinary("C:/Users/namithac.uthappa/AppData/Local/Mozilla Firefox/firefox.exe");
            capabilities.setCapability("requireWindowFocus", true);
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            if (runInheadless) {
                capabilities.addArguments("--headless");
            }
            capabilities.addArguments(new String[]{"--lang=en-GB"});
            FirefoxDriver firefoxDriver = null;
            boolean driverStarted = false;
            try {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//                C:\Users\namithac.uthappa\AppData\Local\Mozilla Firefox
                firefoxDriver = new FirefoxDriver(capabilities);
                driverStarted = true;
            } catch (WebDriverException var8) {
            }

            if (!driverStarted) {
                try {
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    firefoxDriver = new FirefoxDriver(capabilities);
                    driverStarted = true;
                } catch (WebDriverException var7) {
                }
            }
            if (!driverStarted) {
                throw new WebDriverException("Could not load correct gecko driver");
            } else {
                SupportedDriver.getBrowsers().put(Thread.currentThread().getId(), new Browser(firefoxDriver, browserProperties));
            }
        }
    },
    CHROMEGRID {
        public void instantiateDriver(BrowserProperties browserProperties,boolean runInheadless) {
            WebDriver webDriver = null;
            /*    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                HashMap<String, String> prefs = new HashMap();
                prefs.put("intl.accept_languages", "en-gb");
                options.setExperimentalOption("prefs", prefs);
                capabilities.setCapability("goog:chromeOptions", options);

                try {
                    webDriver = new RemoteWebDriver(new URL(""), capabilities);
                    SupportedDriver.getBrowsers().put(Thread.currentThread().getId(), new Browser(webDriver, browserProperties));
                } catch (MalformedURLException var7) {
                    System.out.println("Malformed URL Exception thrown!");
                }*/
        }
    };

    private DriverInitilization() {
    }

    public void instantiateDriver(BrowserProperties browserProperties,boolean runInheadless) {
    }
}

