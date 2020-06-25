package org.testerfabrik.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo1 {
    public static void main(String [] args){
        // Instance an webdriver object
        WebDriver driver;

        // Declare variables
        String baseURL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";
        String chromePath = System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);
        // Open chrome browser
        driver = new ChromeDriver();
        // Browse to the page
        driver.get(baseURL);
        driver.manage().window().maximize();
        // Get page title
        actualResult = driver.getTitle();

        if(actualResult.contentEquals(expectedResult)) {
            System.out.println(actualResult +" es igual a " + expectedResult);
        } else {
            System.out.println(actualResult +" "+ expectedResult);

            System.out.println("Prueba fallada");
        }
        driver.close();
    }
}
