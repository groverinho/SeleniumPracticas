package org.testerfabrik.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExceptions {
    // Instance an webdriver object
    static WebDriver driver;

    public static void main(String[] args) {
        try {
            // Declare variables
            String baseURL = "http://live.guru99.com/index.php/checkout/cart";
            String expectedResult = "$615.00";
            String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.get(baseURL);
            driver.manage().window().maximize();

            // click on TV link
            WebElement lnkTV = driver.findElement(By.linkText("TV"));
            lnkTV.click();

            // click on ADD button
            WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span"));
            btnAddToCart.click();

            // get the price
            WebElement lblSubtotal = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span"));
            lblSubtotal.getText();
            if (lblSubtotal.getText().contentEquals(expectedResult)) {
                System.out.println(lblSubtotal.getText() + " es igual a" + expectedResult);
            } else {
                System.out.println("Prueba fallada");
            }
        } catch(NoSuchElementException ne) {
            System.err.println(("No se encontró el WebElement")+ ne.getMessage());
        } catch(WebDriverException we) {
            System.err.println(("WebDriver Falló")+ we.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        finally{
            driver.close();
        }
    }
}
