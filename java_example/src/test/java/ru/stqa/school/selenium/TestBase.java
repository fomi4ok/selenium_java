package ru.stqa.school.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestBase {

  public WebDriver driver;
  public  WebDriverWait wait;

  public  boolean isElementPresent (By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public boolean isSorted(List<String> list){

    for(int i=0;i< list.size()-1;i++)
    {
      if(list.get(i).compareTo(list.get(i+1))>0)
      {
        return false;
      }
    }
    return true;
  }


  @Before
  public void start() {

    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);

  }

  @After

  public void stop() {

    driver.quit();
    driver = null;
  }

}
