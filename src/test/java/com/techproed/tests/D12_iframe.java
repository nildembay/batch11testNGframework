package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class D12_iframe {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
    @Test
    public void test(){
        // https://html.com/tags/iframe/ sitesine gidin ve sayfada açılan youtube videosunun
        // play tuşuna basınız

        driver.get("https://html.com/tags/iframe/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();


        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

    }

    @AfterClass
    public void tearDown(){

        driver.close();
    }


}
