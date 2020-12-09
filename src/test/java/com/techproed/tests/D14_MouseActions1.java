package com.techproed.tests;

/*
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu
   test edelim.
5- Tamam diyerek alert’I kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
 */

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Set;

public class D14_MouseActions1 extends TestBase {

    @Test
    public void test()  {

        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliAlan= driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();



        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String alert1Yazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(alert1Yazisi,"You selected a context menu");

        // 5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        // 6- Elemental Selenium linkine tiklayalim
        WebElement seleniumLinki=driver.findElement(By.linkText("Elemental Selenium"));
        actions.click(seleniumLinki).perform();

        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String ilkSayfaWindowHandle= driver.getWindowHandle();
        Set<String> tumHandleListesi=driver.getWindowHandles();
        String ikinciSayfaWindowHandle="";
        for (String w:tumHandleListesi
        ) {
            if (!w.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle=w;
            }

        }
        driver.switchTo().window(ikinciSayfaWindowHandle);
        WebElement yaziElementi= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(yaziElementi.getText(),"Elemental Selenium");

    }

}
