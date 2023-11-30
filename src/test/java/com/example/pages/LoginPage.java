package com.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement input_login;

    @FindBy(name = "password")
    private WebElement input_password;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement login_button;



    // Конструктор
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    public void enterLogin() {
        input_login.sendKeys("Admin");
    }

    public void enterPassword() {
        input_password.sendKeys("admin123");;
    }
     public void clickLogin() {
        login_button.click();
    }
}
