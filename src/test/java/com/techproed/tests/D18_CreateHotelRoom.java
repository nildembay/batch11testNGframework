package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
2. Bir metod olusturun: RoomCreateTest()
3. qa-environment.crystalkeyhotels.com adresine gidin.
4. Username textbox ve password metin kutularını locate edin ve aşağıdaki
verileri girin.
a. Username : manager2 b. Password : Man1ager2!
5. Login butonuna tıklayın.
6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
8. Save butonuna basin.
9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
10. OK butonuna tıklayın.
11. Hotel rooms linkine tıklayın.
12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
 */
public class D18_CreateHotelRoom extends TestBase {

    @Test
    public void roomCreateTest() throws InterruptedException {

        driver.get("http://qa-environment.crystalkeyhotels.com ");
        driver.findElement(By.linkText("Log in")).click();
        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("manager");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Manager2!" + Keys.ENTER);

        WebElement hotelManagement = driver.findElement(By.xpath("//*[text()='Hotel Management']"));
        hotelManagement.click();

        driver.findElement(By.partialLinkText("Hotel Rooms")).click();
        driver.findElement(By.xpath("//span[@class='hidden-480']")).click();

        WebElement dropdown1=driver.findElement(By.id("IDHotel"));
        Select select=new Select(dropdown1);
        select.selectByIndex(2);

        Actions actions=new Actions(driver);
        WebElement code= driver.findElement(By.id("Code"));
        code.sendKeys("123");
        actions.sendKeys(Keys.TAB)
                .sendKeys("tip1")
                .sendKeys(Keys.TAB)
                .sendKeys("Adana")
                .sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("cok guzel oda");
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement priceKutusu=driver.findElement(By.id("Price"));
        WebElement fiyat=driver.findElement(By.partialLinkText("600"));
        actions.dragAndDrop(fiyat,priceKutusu).perform();

        WebElement roomTypeDropdown=driver.findElement(By.id("IDGroupRoomType"));
        Select select2=new Select(roomTypeDropdown);
        select2.selectByIndex(3);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
        actions.sendKeys(Keys.TAB)
                .sendKeys("3").perform();

        driver.findElement(By.id("uniform-IsAvailable")).click();
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(5000);
        WebElement uyaripenceresi=driver.findElement(By.xpath("//div[@class='bootbox-body']"));

        Assert.assertTrue(uyaripenceresi.isDisplayed());

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Hotel Rooms")).click();

        WebElement listofHotelRoomsYazisi=driver.findElement(By.xpath("//*[text()='List Of Hotelrooms']"));
        Assert.assertTrue(listofHotelRoomsYazisi.isDisplayed());









    }


}
