package com.techproed.smokeTest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
1) com.techproed altinda bir package olustur : smoketest
2) Bir Class olustur : PositiveTest
3) Bir test method olustur positiveLoginTest()
   http://qa-environment.crystalkeyhotels.com adresine git
  login butonuna bas
test data username: manager ,
test data password : Manager2!
Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
 */
public class PositiveTest extends TestBase {
    @Test
    public void positiveLoginTest(){
        driver.get("http://qa-environment.crystalkeyhotels.com ");
        driver.findElement(By.linkText("Log in")).click();
        WebElement userName=driver.findElement(By.id("UserName"));
        userName.sendKeys("manager");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("Manager2!");

        driver.findElement(By.id("btnSubmit")).click();

        WebElement giris=driver.findElement(By.xpath("//span[@class='title']"));

        Assert.assertTrue(giris.isDisplayed());


    }
}
