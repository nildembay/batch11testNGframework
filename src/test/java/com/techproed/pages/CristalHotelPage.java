package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CristalHotelPage {
    WebDriver driver;
    public CristalHotelPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(linkText = "Log in")
    public WebElement loginButonu;

    @FindBy(id = "UserName")
    public WebElement userTextBox;

    @FindBy(id = "Password")
    public WebElement passwordTextBox;

    @FindBy(id = "btnSubmit")
    public WebElement girisButton;

    @FindBy(xpath = "//span[text()='Try again please']")
    public WebElement sonucYazisi;

}
