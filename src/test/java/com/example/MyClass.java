package com.example;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.pages.LoginPage;
import com.example.pages.QualificationPage;

public class MyClass {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\\\All\\\\Софтік\\\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        // Відкрити сторінку
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        QualificationPage qualificationPage = new QualificationPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

        // Взаємодія зі сторінкою
        loginPage.enterLogin();
        loginPage.enterPassword();
        loginPage.clickLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/pim/viewMyDetails\"]")));
        qualificationPage.clickMyInfo();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/web/index.php/pim/viewQualifications/empNumber/7']")));
        qualificationPage.clickQualification();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Skills']/following::button[text()=' Add '][1]")));
        qualificationPage.clickAddSkill();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}