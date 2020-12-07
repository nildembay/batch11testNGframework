package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
/*
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
 ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
 “You successfuly clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
 ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
 “successfuly” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
 ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
 OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
 */

public class D12_AlertTesti {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @Test
    public void acceptAlert(){
//● Bir metod olusturun: acceptAlert
// ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
// “You successfuly clicked an alert” oldugunu test edin.

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String sonucYazisi= driver.findElement(By.id("result")).getText();

        Assert.assertEquals(sonucYazisi,"You successfuly clicked an alert");


    }

    @Test
    public void dismissAlert(){

// ● Bir metod olusturun: dismissAlert
// ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
// “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String sonucYazisi= driver.findElement(By.id("result")).getText();
        Assert.assertFalse(sonucYazisi.contains("successfuly"));
    }

    @Test
    public void sendKeysAlert(){

// Bir metod olusturun: sendKeysAlert
// ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
// OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Nilufer");
        driver.switchTo().alert().accept();
        String sonucYazisi= driver.findElement(By.id("result")).getText();
        Assert.assertTrue(sonucYazisi.contains("Nilufer"));

    }


    @AfterClass
    public void tearDown(){

        driver.close();
    }

}
