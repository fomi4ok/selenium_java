package ru.stqa.school.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

public class NewProductTest extends TestBase {

  @Test
   public void newProductTest(){

    driver.get("http://localhost/litecart/admin/");

    driver.findElement(By.xpath("//span[contains(.,'Catalog')]")).click();

  }
}
