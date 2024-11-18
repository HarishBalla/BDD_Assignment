package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {

    }
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quit() {
        DriverManager.driver.get().quit();
        driver.remove();
    }

    public static void close() {
        DriverManager.driver.get().close();
    }


}