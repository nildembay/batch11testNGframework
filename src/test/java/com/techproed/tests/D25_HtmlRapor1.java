package com.techproed.tests;

import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseRapor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D25_HtmlRapor1 extends TestBaseRapor {


    /*
1- Test class’ini extends ile TestBaseRapor Class’ina child yapalim
2- extentTest=extentReports.createTest(“Test ismi”, “Tanim”); rapor olusturalim
3- Gerekli/istedigimiz satirlara extentTest.info(“Aciklama”) ekleyelim
4- Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz
     */
    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("global home Page", "sayfaya girebilmeliyim");
        Driver.getDriver().get(ConfigReader.getProperty("gt_signUp_url"));
       extentTest.info("ana sayfaya gidildi");
        GlbHomePage glbHomePage=new GlbHomePage();
        glbHomePage.signInButonu.click();
        glbHomePage.mail.sendKeys(ConfigReader.getProperty("gt_email"));
        extentTest.info("doğru mail girildi");
        glbHomePage.password.sendKeys(ConfigReader.getProperty("gt_pasword"));
        glbHomePage.loginButonu.click();
        Thread.sleep(3000);
        Assert.assertEquals(glbHomePage.girisBasarili.getText(),ConfigReader.getProperty("gt_giris_basarili_yazi"));
        extentTest.pass("doğrulama işlemi yapıldı");

        Driver.closeDriver();

    }

    @Test
    public void signUp(){
          /*
1- Test class’ini extends ile TestBaseRapor Class’ina child yapalim
2- extentTest=extentReports.createTest(“Test ismi”, “Tanim”); rapor olusturalim
3- Gerekli/istedigimiz satirlara extentTest.info(“Aciklama”) ekleyelim
4- Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz
     */
        extentTest=extentReports.createTest("global home Page", "sign in yapma");
        Driver.getDriver().get(ConfigReader.getProperty("gt_signUp_url"));
        extentTest.info("ana sayfaya gidildi");
        GlbSignUpPage glbSignUpPage=new GlbSignUpPage();

        glbSignUpPage.email.sendKeys(ConfigReader.getProperty("gt_email"));
        extentTest.info("doğru mail girildi");
        glbSignUpPage.name.sendKeys(ConfigReader.getProperty("gt_name"));
        glbSignUpPage.mobile.sendKeys(ConfigReader.getProperty("gt_tel"));
        glbSignUpPage.passText.sendKeys(ConfigReader.getProperty("gt_pasword"));
        glbSignUpPage.repassText.sendKeys(ConfigReader.getProperty("gt_pasword"));
        extentTest.pass("aynı password girildi");
        glbSignUpPage.loginButton.click();

        Assert.assertEquals(glbSignUpPage.successTex.getText(),"Success! !");
        extentTest.pass("doğrulama işlemi yapıldı");


    }


}
