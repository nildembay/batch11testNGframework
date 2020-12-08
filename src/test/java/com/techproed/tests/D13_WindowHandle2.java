package com.techproed.tests;


import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;
/*
● Tests package’inda yeni bir class olusturun: D13_WindowHandle2
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”  olduğunu doğrulayın.
 */
public class D13_WindowHandle2 extends TestBase {
    @Test
    public void test(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaYazisi= driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(sayfaYazisi.getText(),"Opening a new window");


        //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        softAssert.assertEquals(driver.getTitle(),"The Internet");


        //   ● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        String ilkSayfaWindowHandle= driver.getWindowHandle();


        Set<String> tumHandleListesi=driver.getWindowHandles();

        String ikinciSayfaWindowHandle="";
        for (String w:tumHandleListesi
        ) {
            if (!w.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle=w;
            }

        }
        //   ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWindowHandle);
        softAssert.assertEquals(driver.getTitle(),"New Window");

        //  ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciYazi=driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(ikinciYazi.getText(),"New Window");

        //  ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”  olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle);
        softAssert.assertEquals(driver.getTitle(),"The Internet");


        softAssert.assertAll();
    }






}
