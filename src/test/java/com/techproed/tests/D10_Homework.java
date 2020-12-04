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
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
control edin.

 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D10_Homework {
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
    public void signInButonu(){
        WebElement signinLinki= driver.findElement(By.id("signin_button"));
        signinLinki.click();

        WebElement loginText= driver.findElement(By.id("user_login"));
        loginText.sendKeys("username");

        WebElement passwordText= driver.findElement(By.id("user_password"));
        passwordText.sendKeys("password");

        WebElement signInButon= driver.findElement(By.xpath("//input[@type='submit']"));
        signInButon.submit();

    }

    @Test(dependsOnMethods ="signInButonu" )
    public void payBills(){
        WebElement payBillsLinki= driver.findElement(By.id("pay_bills_tab"));
        payBillsLinki.click();

        WebElement pucrhaseForeignCurrencyLinki=driver.findElement(By.xpath("//a[@href='#ui-tabs-3']"));
        pucrhaseForeignCurrencyLinki.click();

        WebElement currencyDropDown=driver.findElement(By.id("pc_currency"));
        Select select=new Select(currencyDropDown);
        select.selectByValue("EUR");

        WebElement amountTextBox=driver.findElement(By.id("pc_amount"));
        amountTextBox.sendKeys("100");

        WebElement usDolarsCheckBox=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDolarsCheckBox.isSelected());

        WebElement selectedCurrencyCheckBox=driver.findElement(By.id("pc_inDollars_false"));
        selectedCurrencyCheckBox.click();

        WebElement calculateCostButonu=driver.findElement(By.id("pc_calculate_costs"));
        calculateCostButonu.click();

        WebElement purchaseButonu=driver.findElement(By.id("purchase_cash"));
        purchaseButonu.click();

        WebElement sonucYazisi=driver.findElement(By.id("alert_content"));
        String expectedResult="Foreign currency cash was successfully purchased.";
        Assert.assertEquals(sonucYazisi.getText(),expectedResult);

    }
    @AfterClass
    public void tearDown(){

        driver.close();
    }
}
