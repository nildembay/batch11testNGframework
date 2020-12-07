package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/*
● Bir class olusturun: D12_IframeTest
● https://the-internet.herokuapp.com/iframe adresine gidin.
● Bir metod olusturun: iframeTest
 ○ “An IFrame containing….” textini konsolda yazdirin.
 ○ Text Box’a “Merhaba Dunya!” yazin.
 ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda  yazdirin.
 */
public class D12_iFrameTest {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
    @Test
    public void iFrameTest(){
//        https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

// ○ “An IFrame containing….” textini ulaşılabilir olduğunu doğrulayın

        SoftAssert softAssert=new SoftAssert();
        WebElement anIframeYazisi= driver.findElement(By.tagName("h3"));
        System.out.println(anIframeYazisi.getText());
        softAssert.assertTrue(anIframeYazisi.isEnabled());

// ○ Text Box’a “Merhaba Dunya!” yazin.

        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox=driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dünya");
// ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda  yazdirin.

        driver.switchTo().defaultContent(); //iframeden ana frame e geçiş yapıyoruz.
        WebElement altYazi= driver.findElement(By.linkText("Elemental Selenium"));
        softAssert.assertTrue(altYazi.isDisplayed());
        System.out.println(altYazi.getText());

        softAssert.assertAll();
    }


    @AfterClass
    public void tearDown(){

       // driver.close();
    }

}
