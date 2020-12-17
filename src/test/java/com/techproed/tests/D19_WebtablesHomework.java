package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/*
1. “https://demoqa.com/webtables” sayfasina gidin
2. Headers da bulunan department isimlerini yazdirin
3. 3.sutunun basligini yazdirin
4. Tablodaki tum datalari yazdirin
5. Tabloda kac cell (data) oldugunu yazdirin
6. Tablodaki satir sayisini yazdirin
7. Tablodaki sutun sayisini yazdirin
8. Tablodaki 3.kolonu yazdirin
9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
sayisini girdigimde bana datayi yazdirsin
 */
public class D19_WebtablesHomework extends TestBase {

    @Test
    public void test(){
        driver.get("https://demoqa.com/webtables");

        //Headers da bulunan department isimlerini yazdirin
        List<WebElement> depertmanIsimleri= driver.findElements(By.xpath("(//div[@class='rt-td'][6])"));
        for (WebElement w:depertmanIsimleri
             ) {
            System.out.println(w.getText());
        }

        //3. 3.sutunun basligini yazdirin
        System.out.println(driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]")));

        //4. Tablodaki tum datalari yazdirin
        //5. Tabloda kac cell (data) oldugunu yazdirin
        int sayac=0;
        List<WebElement> tumDatalar= driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement w:tumDatalar
             ) {
            if (!w.getText().equals("")) {
                System.out.println(w.getText());
                sayac += 1;
            }
        }
        System.out.println("tablodaki data sayisi= "+sayac);

        // 6. Tablodaki satir sayisini yazdirin

        List<WebElement> tumSatirlar= driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki satir sayisi: "+tumDatalar.size());

        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> tumSutunlar=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("Tablodaki sütun sayısı: "+tumSutunlar.size());

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolon= driver.findElements(By.xpath("(//div[@class='rt-td'][3])"));
        for (WebElement w:ucuncuKolon
        ) {
            System.out.println(w.getText());
        }

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr -odd'])[2]//div[5]")).getText());

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin

        girilenData(1,3);


    }
    public void girilenData(int row,int column){
        String result=driver.findElement(By.xpath("(//div[@class='rt-tr-group'])["+row+"]//div["+column+"]")).getText();
        System.out.println(result);
    }
}
