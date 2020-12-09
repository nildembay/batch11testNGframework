package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
/*
1- Bir Class olusturalim D14_KeyboardActions1
2- https://www.facebook.com sayfasina gidelim
3- Kullanici adi : Mehmet , sifre : 12345 degerlerini girip login tusuna basalim
4- basarili login olmadigini test edin
 */

public class D14_KeyBoardAction2 extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.facebook.com");
        WebElement emailKutusu= driver.findElement(By.id("email"));
        emailKutusu.sendKeys("Mehmet");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        String sonucYazisi=driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
        Assert.assertTrue(sonucYazisi.contains("The password that you've entered is incorrect"));





    }

}
