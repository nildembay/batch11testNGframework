package com.techproed.smokeTest;

import com.techproed.pages.CristalHotelPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class PositiveTestPom extends TestBase {

    //1) com.techproed altinda bir package olustur : smoketest
    //2) Bir Class olustur : PositiveTest
    //3) Bir test method olustur positiveLoginTest()
    //		 http://qa-environment.crystalkeyhotels.com adresine git
    //		login butonuna bas
    //test data username: manager ,
    //test data password : Manager2!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void Test(){
        //		 http://qa-environment.crystalkeyhotels.com adresine git
        driver.get(ConfigReader.getProperty("c_url"));
        //		login butonuna bas
        CristalHotelPage crsytalHotelPage=new CristalHotelPage(driver);
        crsytalHotelPage.loginButonu.click();
        //test data username: manager ,
        crsytalHotelPage.userTextBox.sendKeys(ConfigReader.getProperty("valid_user"));
        //test data password : Manager2!
        crsytalHotelPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));

        crsytalHotelPage.girisButton.click();
    }
}