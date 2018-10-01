package ru.stqa.school.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PaginationTest extends TestBase {

  @Test
  public void testPagination() {
    driver.get("http://pagination.js.org/");
    WebElement table = driver.findElement(By.cssSelector("#demo1"));
    List<WebElement> items = table.findElements(By.cssSelector(".data-container ul li"));
    List<WebElement> page = table.findElements(By.cssSelector(".paginationjs ul li"));
    page.get(2).click();
    wait.until(ExpectedConditions.stalenessOf(items.get(0)));
    items = table.findElements(By.cssSelector(".data-container ul li"));
    Assert.assertTrue(items.get(0).getText().equals("11"));




  }
}
