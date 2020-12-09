package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Set;

public class D13_WindowsHandle1 extends TestBase {

   @Test
    public void test(){
       driver.get("https://the-internet.herokuapp.com/iframe");

       // 1.adım: driver ile gittiğimiz sayfanın handle ını alip bir String değişkene atayalım
       String ilkSayfaWindowHandle= driver.getWindowHandle();
       System.out.println(ilkSayfaWindowHandle);

       driver.findElement(By.linkText("Elemental Selenium")).click();

       //getWindowHandles() komutu ile açık olan tüm pencerelerin windowHandle larını kümeye ekler
       Set<String> tumHandleListesi=driver.getWindowHandles();

       //kume içerisindeki 2 windowhandledan 1. sayfanınkine eşit olmayanı alıp 2. olarak tanımlarız.
       String ikinciSayfaWindowHandle="";
       for (String w:tumHandleListesi
            ) {
           if (!w.equals(ilkSayfaWindowHandle)){
               ikinciSayfaWindowHandle=w;
           }

       }
       System.out.println(ikinciSayfaWindowHandle);

       //diğer tab a geçme
       driver.switchTo().window(ikinciSayfaWindowHandle);

        // h1 tagındaki yazının Elemental Selenium olduğunu test edelim
       WebElement yaziElementi= driver.findElement(By.tagName("h1"));
       Assert.assertEquals(yaziElementi.getText(),"Elemental Selenium");
   }
}
