package ru.stqa.school.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class StickersCheck extends TestBase {

  @Test

  public void stickersCheckTest () {

    driver.get("http://localhost/litecart/en/");

    List<WebElement> items = driver.findElements(By.cssSelector("div.image-wrapper"));

    for (WebElement item: items) {
      List<WebElement> sticker = item.findElements(By.cssSelector("div.image-wrapper div.sticker"));
      assertEquals(1, sticker.size());



  }
    }



  }

