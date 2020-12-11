package com.techproed.tests;
/*
1."https://facebook.com" Adresine gidin
2.“create new account” butonuna basin
3.“firstName” giris kutusuna bir isim yazin
4.“surname” giris kutusuna bir soyisim yazin
5.“email” giris kutusuna bir email yazin
6.“email” onay kutusuna emaili tekrar yazin
7.Bir sifre girin
8.Tarih icin gun secin
9.Tarih icin ay secin
10.Tarih icin yil secin
11.Cinsiyeti secin
12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
13.Sayfayi kapatin
 */

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class D16_FacebookFakeTest extends TestBase {

    @Test
    public void test(){

//        1."https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

//        2.“create new account” butonuna basin
        driver.findElement(By.xpath("//a[@role='button']")).click();

//        3.“firstName” giris kutusuna bir isim yazin

//        4.“surname” giris kutusuna bir soyisim yazin
//        5.“email” giris kutusuna bir email yazin
//        6.“email” onay kutusuna emaili tekrar yazin
//        7.Bir sifre girin

        WebElement isimKutusu = driver.findElement(By.id("u_1_b"));
        isimKutusu.click();
        Actions actons=new Actions(driver);
        Faker faker = new Faker();
        String name=faker.name().firstName();
        String surname=faker.name().lastName();
        String email=faker.internet().emailAddress();
        String password=faker.internet().password();
        actons.sendKeys(name)
                .sendKeys(Keys.TAB)
                .sendKeys(surname)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(password).perform();

        //        8.Tarih icin gun secin
        WebElement day=driver.findElement(By.name("birthday_day"));
        Select select = new Select(day);
        select.selectByValue("15");

        //        9.Tarih icin ay secin

        WebElement ay=driver.findElement(By.name("birthday_month"));
        Select select1=new Select(ay);
        select1.selectByValue("12");

        //        10.Tarih icin yil secin

        WebElement yil=driver.findElement(By.name("birthday_year"));
        Select select2=new Select(yil);
        select2.selectByValue("1990");

//        11.Cinsiyeti secin

        WebElement kadin= driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
        kadin.click();
  //        12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.

        Assert.assertTrue(kadin.isSelected());

        WebElement erkek= driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        WebElement other= driver.findElement(By.xpath("(//input[@name='sex'])[3]"));
        Assert.assertFalse(erkek.isSelected());
        Assert.assertFalse(other.isSelected());

//        13.Sayfayi kapatin
    }

}
