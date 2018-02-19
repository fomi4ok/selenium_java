package ru.stqa.school.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class MenuAdminTest extends TestBase {

  @Test

  public void menuAdminTest() throws InterruptedException {


    driver.get(" http://localhost/litecart/admin/");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    
    List<WebElement> elements = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-"));
    int count = elements.size();
    for (int i = 0; i < count; i++) {
      elements = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-"));
      elements.get(i).click();
      assertTrue(isElementPresent(By.tagName("h1")));
      List<WebElement> subelements = driver.findElements(By.cssSelector(".docs li"));
      int subcount = subelements.size();

      if (subcount > 0) {
        for (int j = 0; j < subcount; j++) {
          subelements = driver.findElements(By.cssSelector(".docs li"));
          subelements.get(j).click();
          assertTrue(isElementPresent(By.tagName("h1")));
        }


      }
    }

    }
  }






