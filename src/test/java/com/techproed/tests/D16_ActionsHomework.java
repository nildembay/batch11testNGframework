package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
1."http://webdriveruniversity.com/Actions" sayfasina gidin
2."Hover over Me First" kutusunun ustune gelin
3."Link 1" e tiklayin
4.Popup mesajini yazdirin
5.Popup'i tamam diyerek kapatin
6."Click and hold" kutusuna basili tutun
7. "Click and hold" kutusunda cikan yaziyi yazdirin
8. "Double click me" butonunu cift tiklayin
 */
public class D16_ActionsHomework extends TestBase {
    @Test
    public void test(){
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions=new Actions(driver);
        WebElement buton1 =driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(buton1).perform();
        driver.findElement(By.linkText("Link 1")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement clickHold=driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHold).perform();
        System.out.println(clickHold.getText());



        WebElement doubleclick=driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleclick).perform();






    }



}
