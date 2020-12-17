package com.techproed.smokeTest;

import com.techproed.pages.CristalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;
/*
1) com.techproed altinda bir package olustur : smoketest
2) Bir Class olustur : PositiveTest
3) Bir test method olustur positiveLoginTest()
   http://qa-environment.crystalkeyhotels.com adresine git
  login butonuna bas
test data username: manager ,
test data password : Manager2!
Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
 */

public class PositiveTestWithPage extends TestBase {
    @Test
    public void test(){
        driver.get("http://qa-environment.crystalkeyhotels.com");
        CristalHotelPage cristalHotelPage=new CristalHotelPage(driver);
        cristalHotelPage.loginButonu.click();
        cristalHotelPage.userTextBox.sendKeys("manager");
        cristalHotelPage.passwordTextBox.sendKeys("Manager2!");
        cristalHotelPage.girisButton.click();

    }
}
