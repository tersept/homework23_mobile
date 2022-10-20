package drivers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static Config browserstack = ConfigFactory.create(Config.class, System.getProperties());

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", browserstack.getBrowserstackUser());
        mutableCapabilities.setCapability("browserstack.key", browserstack.getBrowserstackKey());
        mutableCapabilities.setCapability("app", browserstack.getApp());
        mutableCapabilities.setCapability("device", browserstack.getDevice());
        mutableCapabilities.setCapability("os_version", browserstack.getOsVersion());
        mutableCapabilities.setCapability("project", browserstack.getProject());
        mutableCapabilities.setCapability("build", browserstack.getBuild());
        mutableCapabilities.setCapability("name", browserstack.getName());

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

//    @SneakyThrows
//    @Override
//    public WebDriver createDriver(Capabilities capabilities) {
//        MutableCapabilities mutableCapabilities = new MutableCapabilities();
//        mutableCapabilities.merge(capabilities);
//
//        Config config = ConfigFactory.create(Config.class, System.getProperties());
//        Configuration.remote = config.getRemoteUrl();
//        // Set your access credentials
//        mutableCapabilities.setCapability("browserstack.user", "bsuser_1hMNrP");
//        mutableCapabilities.setCapability("browserstack.key", "LPxoq8J2r1pv4EBppgyz");
//
//        // Set URL of the application under test
//        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
//
//        // Specify device and os_version for testing
//        mutableCapabilities.setCapability("device", "Google Pixel 3");
//        mutableCapabilities.setCapability("os_version", "9.0");
//
//        // Set other BrowserStack capabilities
//        mutableCapabilities.setCapability("project", "First Java Project");
//        mutableCapabilities.setCapability("build", "browserstack-build-1");
//        mutableCapabilities.setCapability("name", "first_test");
//
//        // Initialise the remote Webdriver using BrowserStack remote URL
//        // and desired capabilities defined above
//        return new RemoteWebDriver(new URL("http://hub.browserstack.com/wd/hub"), mutableCapabilities);
//    }
}
