package com.techproed.smokeTest;
/*
1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
3 Farkli test Methodunda 3 senaryoyu test et
  - yanlisSifre
  - yanlisKulllanici
  - yanlisSifreKullanici
2) http://qa-environment.crystalkeyhotels.com  adresine git
3) Login butonuna bas
4) Verilen senaryolar ile giris yapilamadigini test et
 */

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {

    Faker faker=new Faker();

    public void giris(){
        driver.get("http://qa-environment.crystalkeyhotels.com ");
        driver.findElement(By.linkText("Log in")).click();
    }

    @Test
    public void yanlisifre(){
        giris();
        driver.findElement(By.id("UserName")).sendKeys("manager");
        driver.findElement(By.id("Password")).sendKeys(faker.internet().password()+ Keys.ENTER);

        WebElement sonucYazisi=driver.findElement(By.id("divMessageResult"));
        Assert.assertTrue(sonucYazisi.getText().contains("Wrong password"));

    }
    @Test
    public void yanlisKullanici(){
        giris();
        driver.findElement(By.id("UserName")).sendKeys(faker.name().username());
        driver.findElement(By.id("Password")).sendKeys("Manager2!"+ Keys.ENTER);


        WebElement sonucYazisi=driver.findElement(By.id("divMessageResult"));
        Assert.assertTrue(sonucYazisi.getText().contains("Try again please"));

    }
    @Test
    public void yanlisKullaniciSifre(){
        giris();
        driver.findElement(By.id("UserName")).sendKeys(faker.name().username());
        driver.findElement(By.id("Password")).sendKeys(faker.internet().password()+ Keys.ENTER);


        WebElement sonucYazisi=driver.findElement(By.id("divMessageResult"));

        Assert.assertTrue(sonucYazisi.getText().contains("Try again please"));

    }


}
