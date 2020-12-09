package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
1- http://uitestpractice.com/Students/Actions adresine gidelim
 2- Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini  gorelim
 3- Click Me butonuna click yapalim ve cikan alertteki mesajin  "Clicked !!" oldugunu dogrulayalim
 4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double  Clicked !!" oldugunu dogrulayalim
 5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
 */
public class D14_MouseActions2 extends TestBase {

    @Test
    public void test()  {
//        1- http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

//        2- Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini  gorelim
        Actions actions=new Actions(driver);
        WebElement maviKutu= driver.findElement(By.id("div2"));
        actions.moveToElement(maviKutu).perform();


//        3- Click Me butonuna click yapalim ve cikan alertteki mesajin  "Clicked !!" oldugunu dogrulayalim
        WebElement clickMe= driver.findElement(By.name("click"));
        actions.click(clickMe).perform();
        SoftAssert softAssert=new SoftAssert();
        String alertYazisi=driver.switchTo().alert().getText();
        softAssert.assertEquals(alertYazisi,"Clicked !!");
        driver.switchTo().alert().accept();


//        4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double  Clicked !!" oldugunu dogrulayalim
        WebElement doubleclick= driver.findElement(By.name("dblClick"));
        actions.doubleClick(doubleclick).perform();

        String doubleAlertYazisi=driver.switchTo().alert().getText();
        softAssert.assertEquals(doubleAlertYazisi,"Double Clicked !!");
        driver.switchTo().alert().accept();

//        5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement tasinacakElement=driver.findElement(By.id("draggable"));
        WebElement tasimaHedefElementi = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(tasinacakElement,tasimaHedefElementi).perform();
        String hedefElementYazisi=tasimaHedefElementi.getText();
        softAssert.assertEquals(hedefElementYazisi,"Dropped!");

        softAssert.assertAll();
    }

}
