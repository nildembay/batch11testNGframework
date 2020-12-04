package com.techproed.tests;
/*
1. “http://zero.webappsecurity.com/” Adresine gidin
 2. Sign in butonuna basin
 3. Login kutusuna “username” yazin
 4. Password kutusuna “password.” yazin
 5. Sign in tusuna basin
 6. Pay Bills sayfasina gidin
 7. “Purchase Foreign Currency” tusuna basin
 8. “Currency” drop down menusunden Eurozone’u secin
 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
 "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
 "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
 "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
 "Thailand (baht)"
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class D11_SoftAssert2 {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/");
    }
    @Test
    public void test01() {
        WebElement signinLinki = driver.findElement(By.id("signin_button"));
        signinLinki.click();

        WebElement loginText = driver.findElement(By.id("user_login"));
        loginText.sendKeys("username");

        WebElement passwordText = driver.findElement(By.id("user_password"));
        passwordText.sendKeys("password");

        WebElement signInButon = driver.findElement(By.xpath("//input[@type='submit']"));
        signInButon.submit();

        WebElement payBillsLinki= driver.findElement(By.id("pay_bills_tab"));
        payBillsLinki.click();

        WebElement pucrhaseForeignCurrencyLinki=driver.findElement(By.xpath("//a[@href='#ui-tabs-3']"));
        pucrhaseForeignCurrencyLinki.click();

        WebElement currencyDropDown=driver.findElement(By.id("pc_currency"));
        Select select=new Select(currencyDropDown);
        select.selectByValue("EUR");

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(select.getFirstSelectedOption().getText(),"Eurozone (Euro)","Eurozone");

        List<WebElement> tumOpsiyonlar= select.getOptions();

        List<String> tumOpsiyonlarString=new ArrayList<String>();
        for (WebElement w:tumOpsiyonlar ) {

            tumOpsiyonlarString.add(w.getText());

        }
        System.out.println(tumOpsiyonlarString);

        List<String> expectedOptionList= Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
                "Thailand (baht)");

        System.out.println(expectedOptionList);

        softAssert.assertEquals(tumOpsiyonlarString,expectedOptionList,"options listesi actual ile uyuşmuyor");


        softAssert.assertAll();

    }
    @AfterClass
    public void tearDown(){

        driver.close();
    }

}
