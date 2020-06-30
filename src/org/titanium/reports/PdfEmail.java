package org.titanium.reports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.naming.NamingException;
import java.sql.SQLException;

@Listeners(JyperionListener.class)
public class PdfEmail extends BaseClass {
    WebDriver driver = getDriver();

    @Test
    public void testOne(){
        driver.get("https://www.google.com/");
        Assert.assertTrue(false);
    }
    @Test
    public void testTwo(){
        driver.get("https://www.facebook.com/");
        Assert.assertTrue(true);
    }
    @Test
    public void testThree(){
        driver.get("https://www.instagram.com/");
        Assert.assertTrue(false);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
    @AfterSuite
    public void sendEmail() throws SQLException, NamingException {
        sendPdfReportByEmail("titaniumsoltest@gmail.com","titanium619","titaniumsoltest@gmail.com", "Reporte pdf pruebas","Esto es una prueba");
    }
}
