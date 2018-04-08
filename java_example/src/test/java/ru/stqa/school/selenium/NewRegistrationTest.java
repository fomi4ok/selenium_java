package ru.stqa.school.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewRegistrationTest extends TestBase{

  @Test

  public void testNewReg() {

    driver.get("http://localhost/litecart/en/");
    WebElement regButton = driver.findElement(By.linkText("New customers click here"));
    regButton.click();
    driver.findElement(By.name("tax_id")).sendKeys("12345");
    driver.findElement(By.name("company")).sendKeys("Company LLC");
    driver.findElement(By.name("firstname")).sendKeys("Jane");
    driver.findElement(By.name("lastname")).sendKeys("Miller");
    driver.findElement(By.name("address1")).sendKeys("123 abc av");
    driver.findElement(By.name("address2")).sendKeys("2b");
    driver.findElement(By.name("postcode")).sendKeys("12345");
    driver.findElement(By.name("city")).sendKeys("New York");

    Select countryDropDown = new Select(driver.findElement(By.name("country_code")));
    countryDropDown.selectByVisibleText("United States");

    Select stateDropDown = new Select(driver.findElement(By.name("zone_code")));
    stateDropDown.selectByVisibleText("New York");

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    String email= "test"+ timeStamp + "@test.com";
    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("phone")).sendKeys("+16464646444");
    driver.findElement(By.name("password")).sendKeys("Password1");
    WebElement confirmed_password = driver.findElement(By.name("confirmed_password"));
    confirmed_password.sendKeys("Password1");
    driver.findElement(By.name("create_account")).click();

    WebElement logout = driver.findElement(By.linkText("Logout"));
    logout.click();
    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("password")).sendKeys("Password1");
    driver.findElement(By.name("login")).click();

    driver.findElement(By.linkText("Logout")).click();

  }
}
