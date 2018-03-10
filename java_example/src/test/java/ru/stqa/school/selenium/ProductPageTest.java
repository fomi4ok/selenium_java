package ru.stqa.school.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPageTest extends TestBase {

  @Test
  public void productPageTest() throws InterruptedException {

    driver.get("http://localhost/litecart/en/");

    List<WebElement> items  = driver.findElements(By.cssSelector("div#box-campaigns ul.listing-wrapper products"));
    //System.out.println(items);
    //String elementTitle = "";
    for (WebElement item : items) {
      item = item.findElement(By.cssSelector("div#box-campaigns li:first-child"));
      String elementTitle = item.getText();
      System.out.println(elementTitle);



//      for (int i = 0; i < element.size(); i++) {
//        element.get(0).getText();
//        element.get(0).click();

      }





  }}
