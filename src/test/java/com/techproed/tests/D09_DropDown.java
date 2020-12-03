package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class D09_DropDown {
    /*
  ● https://the-internet.herokuapp.com/dropdown adresine gidin.
  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin
  ve yazdırın
  4.Tüm dropdown değerleri(value) yazdırın
  5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
  True , degilse False yazdırın.
     */

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void dropdownTesti(){
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdownlist=new Select(dropdown);

        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        dropdownlist.selectByIndex(1);
        System.out.println(dropdownlist.getFirstSelectedOption().getText());

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        dropdownlist.selectByValue("2");
        System.out.println(dropdownlist.getFirstSelectedOption().getText());

       // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        dropdownlist.selectByVisibleText("Option 1");
        System.out.println(dropdownlist.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> liste=new ArrayList<WebElement>();


    }


    @AfterClass
    public void tearDown(){
        driver.close();
    }





}
