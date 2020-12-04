package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/*
Yeni bir Class Olusturun : D11_SoftAssert1
1. “http://https://www.sahibinden.com/” Adresine gidin
2. Basliginin "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri" oldugunu  dogrulayin
3. search kutusuna araba yazip arattirin
4. bulunan sonuc sayisini yazdirin
5. sonuc yazisinin "araba" icerdigini dogrulayin
6. Tumunu temizle linkini tiklayin
7. Bulunan sonucu yazdirin
8. Sonuc yazisinin “araba” kelimesi icermedigini dogrulayin
 */

public class D11_SoftAssert1 {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void sahibinden(){
       driver.get("https://www.sahibinden.com/");
        SoftAssert softAssert=new SoftAssert();
        String expectedTitle="Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri";
        String actualTitle= driver.getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"anasayfa title i istedigimiz gibi degil");

        WebElement searchBox= driver.findElement(By.id("searchText"));
        searchBox.sendKeys("araba"+ Keys.ENTER);

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='result-text estimated-result-text']"));
        System.out.println(sonucYaziElementi.getText());

        softAssert.assertTrue(sonucYaziElementi.getText().contains("araba"),"arama sonuc sayisi araba icermiyor");


        driver.findElement(By.linkText("Tümünü Temizle")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement sonucYazisi= driver.findElement(By.xpath("//div[@class='result-text']"));
        System.out.println(sonucYazisi.getText());

        softAssert.assertFalse(sonucYazisi.getText().contains("araba"));




        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){

        driver.close();
    }
}
