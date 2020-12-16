package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
2. Bir metod olusturun : isEnabled()
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Textbox’in etkin olmadigini(enabled) dogrulayın
5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
7. Textbox’in etkin oldugunu(enabled) dogrulayın.
 */
public class D16_EnableTest extends TestBase {

    @Test
    public void isEnabled(){

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox=driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(textbox.isEnabled());

        //Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebDriverWait wait=new WebDriverWait(driver,30);
        WebElement enableButonu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='swapInput()']")));
        enableButonu.click();

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement enabledYazisi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        softAssert.assertTrue(enabledYazisi.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        softAssert.assertTrue(textbox.isEnabled());

        softAssert.assertAll();

    }
    @Test
    public void explityWait(){

        /*
        1. " https://demoqa.com/dynamic-properties” sayfasina gidin
        2. “Visible After 5 Seconds” butonunun gorunun oldugunu test edin
         */
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait=new WebDriverWait(driver,30);
        WebElement buton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        Assert.assertTrue(buton.isDisplayed());


    }



}
