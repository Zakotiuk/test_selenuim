package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualificationPage {
    @FindBy(xpath = "//a[@href=\"/web/index.php/pim/viewMyDetails\"]")
    private WebElement myInfoButton;

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewQualifications/empNumber/7']")
    private WebElement qualificationButton;

    @FindBy(xpath = "//h6[text()='Skills']/following::button[text()=' Add '][1]")
    private WebElement addSkillButton;

    @FindBy(xpath = "//div[@class='oxd-select-wrapper'][preceding::label[text()='Skill']]")
    private WebElement droppDownList;

    @FindBy(xpath = "//input[contains(@class, 'oxd-input')][preceding::label[text()='Years of Experience']]")
    private WebElement experienceInput;

    @FindBy(xpath = "//button[text()=' Save '][preceding::label[text()='Years of Experience']]")
    private WebElement saveButton;

    private WebDriver driver;
    public QualificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMyInfo() {
        myInfoButton.click();
    }

    public void clickQualification() {
        qualificationButton.click();

    }

    public void clickAddSkill() {
        addSkillButton.click();
        experienceInput.sendKeys("2");
        saveButton.click();
    }
}
