package org.testerfabrik.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Forms {
    // Instance an webdriver object
    static WebDriver driver;

    public static void main(String[] args) {
            // Declare variables
            String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
            String baseURL = "http://newtours.demoaut.com/";
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.get(baseURL);
            driver.manage().window().maximize();
        try {
            driver.findElement(By.linkText("REGISTER")).click();
            WebElement txtFirstName = driver.findElement(By.name("firstName"));
            txtFirstName.sendKeys("Ariel");
            Thread.sleep(1500);
            txtFirstName.clear();
            Thread.sleep(1500);
            txtFirstName.sendKeys("Grover");

            driver.findElement(By.name("address1")).sendKeys("Test Address");

            Select drpCountry = new Select(driver.findElement(By.name("country")));
            Thread.sleep(1500);
            drpCountry.selectByVisibleText("MEXICO");
            String email = "grover.ariel@test.com";
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.name("password")).sendKeys("123456");

            WebElement txtConfirmPass = driver.findElement(By.name("confirmPassword"));
            txtConfirmPass.sendKeys("123456");
            txtConfirmPass.submit();

            System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Note: Your user name is ')]")).getText().contains(email)?
                    "PRUEBA EXITOSA": "PRUEBA FALLIDA");

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
