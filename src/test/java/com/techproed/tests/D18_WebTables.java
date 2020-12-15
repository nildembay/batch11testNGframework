package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


/*
● login() metodun oluşturun ve oturum açın.
● http://qa-environment.crystalkeyhotels.com/admin/HotelRoomAdmin adresine gidin ○ Username : manager2
 ○ Password : Man1ager2!
● table() metodu oluşturun
 ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
 ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.


 ● printRows() metodu oluşturun //tr
 ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
 ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
 ○ 4.satirdaki(row) elementleri konsolda yazdırın.

 //Listeden elemanı almadan locate ederek 4. satırı yazdırın
 */

public class D18_WebTables extends TestBase {

    public void login(){

        driver.get("http://qa-environment.crystalkeyhotels.com/admin/HotelRoomAdmin");

        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("manager");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Manager2!" );

        WebElement logIn=driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();

    }

    @Test
    public void table() throws InterruptedException {
    login();
    Thread.sleep(5000);

    WebElement table=driver.findElement(By.xpath("//tbody"));

        //tbody tek bir web element olarak locate edilebilir
        // getText ile yazdırıldığında body de bulunan tüm dataları yazdırır.
        //fakat bu datalar üzerinde manipulation yapılamaz

        List<WebElement> basliklarlistesi= driver.findElements(By.xpath("//thead//th"));
        System.out.println("Tablodaki sütun sayısı= "+basliklarlistesi.size());

        for (WebElement w:basliklarlistesi
             ) {
            System.out.print("["+w.getText()+"]"+ " ");

        }



    }
    @Test
    public void printRows() throws InterruptedException {
      login();
        Thread.sleep(5000);
        List<WebElement> satirlarlistesi= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki satir sayisi"+satirlarlistesi.size());
        System.out.println(satirlarlistesi.get(4).getText());

        WebElement dorduncuSatir= driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(dorduncuSatir.getText());

    }


}
