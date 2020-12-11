package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
1. Bir class olusturun : WaitTest
2. Iki tane metod olusturun : implicitWait() , explicitWait()
  Iki metod icin de asagidaki adimlari test edin.
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Remove butonuna basin.
5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
6. Add buttonuna basin
7. It’s back mesajinin gorundugunu test edin
 */
public class D16_SeleniumWaits extends TestBase {
//    2. Iki tane metod olusturun : implicitWait() , explicitWait()
//    Iki metod icin de asagidaki adimlari test edin.
    @Test
    public void implicitWait(){
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement sonucYazisi=driver.findElement(By.id("message"));
        Assert.assertEquals(sonucYazisi.getText(),"It's gone!");

        //Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //It’s back mesajinin gorundugunu test edin
        WebElement sonucYazisi2=driver.findElement(By.id("message"));
        Assert.assertEquals(sonucYazisi2.getText(),"It's back!");

    }
    @Test
    public void expilicitWait(){

    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    // 4. Remove butonuna basin.
        WebDriverWait wait=new WebDriverWait(driver,30);
        WebElement removeButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='swapCheckbox()']")));
        removeButton.click();
    // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement sonucYazisi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(sonucYazisi.getText(),"It's gone!");

    // 6. Add buttonuna basin
        WebElement addButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='swapCheckbox()']")));
        addButton.click();
    // 7. It’s back mesajinin gorundugunu test edin
        WebElement sonucYazisi2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(sonucYazisi2.getText(),"It's back!");

    }



}
