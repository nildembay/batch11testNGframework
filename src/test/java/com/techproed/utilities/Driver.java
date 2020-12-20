package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //singleton class: obje oluşturulması kontrol altına alınan (genelde izin verilmeyen) class
    // bunun için başka yerlerden Driver classından object üretmeye yarayan
    // default constructor ı private yaparız
    private Driver(){

    }
    static private WebDriver driver;

    static  public WebDriver getDriver(){

        if (driver==null){

            switch(ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver=new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "opera":
                    OperaDriverManager.operadriver().setup();
                    driver=new OperaDriver();
                    break;

            }


        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
    static public void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }

    }


}
