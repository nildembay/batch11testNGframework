package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
/*
1. https://www.amazon.com/ adresine gidin
2. softassert kullanarak amazon websitesine gittiginizi dogrulayin
3. kategori dropdown'indan Books kategorisini secin
    arama kutusuna history yazdirip aratin
4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin
5. cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin
 */

public class D11_Homework {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void Test01(){

        //1. https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //softassert kullanarak amazon websitesine gittiginizi dogrulayin
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());

        //3. kategori dropdown'indan Books kategorisini secin
        //arama kutusuna history yazdirip aratin
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDown);
        select.selectByValue("search-alias=stripbooks-intl-ship");
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.click();
        String arananKelime="history";
        searchbox.sendKeys(arananKelime+ Keys.ENTER);


        //4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin
        WebElement ikinciKitap=driver.findElement(By.xpath("(//div[@class='s-include-content-margin s-border-bottom s-latency-cf-section'])[2]"));
        softAssert.assertTrue(ikinciKitap.getText().contains("History"));

        WebElement besinciKitap=driver.findElement(By.xpath("(//div[@class='s-include-content-margin s-border-bottom s-latency-cf-section'])[5]"));
        softAssert.assertTrue(besinciKitap.getText().contains("History"));

        //5. cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin

        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonuc=sonucYazisi.getText();

        sonuc=(sonuc.substring(13,20)).replace(",","") ;
        int sonucson=Integer.parseInt(sonuc);
        System.out.println(sonuc);

        softAssert.assertTrue(sonucson>50000);

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){

       driver.close();
    }
}
