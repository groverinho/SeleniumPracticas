package org.testerfabrik.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String [] args){
        // Instance an webdriver object
        WebDriver driver;

        // Declare variables
        String baseURL = "http://live.guru99.com/index.php/checkout/cart";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        // click on TV link
        driver.findElement(By.linkText("TV")).click();

        // click on ADD button
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click();

        // get the price
        actualResult = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span")).getText();
        if(actualResult.contentEquals(expectedResult)) {
            System.out.println(actualResult +" es igual a" + expectedResult);
        } else {
            System.out.println(actualResult +" "+ expectedResult);

            System.out.println("Prueba fallada");
        }
        driver.close();
    }
}
