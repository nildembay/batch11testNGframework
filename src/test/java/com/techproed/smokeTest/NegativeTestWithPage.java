package com.techproed.smokeTest;

import com.techproed.pages.CristalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestWithPage extends TestBase {

    @Test
    public void test(){
        driver.get("http://qa-environment.crystalkeyhotels.com");
        CristalHotelPage cristalHotelPage=new CristalHotelPage(driver);
        cristalHotelPage.loginButonu.click();
        cristalHotelPage.userTextBox.sendKeys("manager1");
        cristalHotelPage.passwordTextBox.sendKeys("Manager2!");
        cristalHotelPage.girisButton.click();
        Assert.assertEquals(cristalHotelPage.sonucYazisi.getText(),"Try again please");

    }
}
