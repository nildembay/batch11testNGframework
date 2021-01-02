package com.techproed.tests;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class D25_WindowHandle {
    @Test
    public void test(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe\n");
        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();
        ReusableMethods.waitFor(5);
        //Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro
        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");
        WebElement yaziElementi=Driver.getDriver().findElement(By.tagName("h1"));
        Assert.assertEquals(yaziElementi.getText(),"Elemental Selenium");
    }
}

