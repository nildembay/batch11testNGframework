package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class D14_MouseActions3 extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        WebElement bekleGor=driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        actions.moveToElement(bekleGor).perform();
        WebElement list=driver.findElement(By.linkText("Create a List"));
        actions.click(list).perform();

        String sonucYazisi=driver.findElement(By.partialLinkText("Your Lists")).getText();
        Assert.assertEquals(sonucYazisi,"Your Lists");

    }

}
