package com.techproed.tests;
/*
1. Tests packagenin altına class olusturun: CreateHotel
2. Bir metod olusturun: createHotel
3. qa-environment.crystalkeyhotels.com adresine git.
4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri  girin.
 a. Username : manager
 b. Password : Manager2!
5. Login butonuna tıklayın.
6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
8. Save butonuna tıklayın.
9. “Hotel was inserted successfully” textinin göründüğünü test edin.
10. OK butonuna tıklayın.
 */

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class D17_EndtoEndCreateHotel extends TestBase {
    @Test
    public void createHotel() throws InterruptedException {

        driver.get("http://qa-environment.crystalkeyhotels.com ");
        driver.findElement(By.linkText("Log in")).click();
        WebElement userName=driver.findElement(By.id("UserName"));
        userName.sendKeys("manager");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("Manager2!"+ Keys.ENTER);

        WebElement hotelManagement= driver.findElement(By.xpath("//*[text()='Hotel Management']"));
        hotelManagement.click();
        driver.findElement(By.linkText("Hotel List")).click();

        driver.findElement(By.xpath("//*[text()='Add Hotel '] ")).click();
        WebElement codeAlani=driver.findElement(By.id("Code"));
        codeAlani.sendKeys("123");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB)
                .sendKeys("Yildiz")
                .sendKeys(Keys.TAB)
                .sendKeys("Ankara")
                .sendKeys(Keys.TAB)
                .sendKeys("1234578925")
                .sendKeys(Keys.TAB)
                .sendKeys("a@gmail.com")
                .sendKeys(Keys.PAGE_DOWN).perform();
        WebElement dropdown=driver.findElement(By.id("IDGroup"));
        Select select=new Select(dropdown);
        select.selectByIndex(1);
        driver.findElement(By.id("btnSubmit")).submit();
        Thread.sleep(5000);
        WebElement uyariyazisi=driver.findElement(By.xpath("//div[@class='bootbox-body']"));
        Assert.assertEquals(uyariyazisi.getText(),"Hotel was inserted successfully");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    }
}
