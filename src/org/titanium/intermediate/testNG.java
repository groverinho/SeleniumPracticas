package org.titanium.intermediate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNG {
    String baseURL = "https://cnnespanol.cnn.com/";
    WebDriver driver;
    String expectedResult = "";
    String actualResult = "";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @BeforeTest
    public void verifyHomePageTitle() {
        expectedResult = "Últimas noticias en español | CNN en Español";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"Title is not equals");
    }

    @AfterMethod
    public void goToBackHomePage() {
        driver.navigate().back();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority =  1)
    public void mundoLink() {
        driver.findElement(By.linkText("Mundo")).click();
        expectedResult = "Noticias del mundo hoy ▷ Últimas noticias mundiales en español en CNN";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"Title is not equals");
    }

    @Test(priority =  2)
    public void latamLink(){
        driver.findElement(By.linkText("Latam")).click();
        expectedResult = "Latinoamérica: últimas noticias sobre Latinoamérica | CNN";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"Title is not equals");
    }

}
