package ru.stqa.school.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class GeoZonesSortingTest extends TestBase {

  @Test

  public void geoZonesTest() throws InterruptedException {

    driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    WebElement table = driver.findElement(By.cssSelector("[name=geo_zones_form]"));
    List<WebElement> rows = table.findElements(By.cssSelector(".row"));
    List<String> links = new ArrayList<String>();
    List<String> countries = new ArrayList<>();
    List<String> zones = new ArrayList<>();


    for (WebElement row : rows) {
      String country = row.findElement(By.xpath("./td[3]")).getAttribute("outerText");
      countries.add(country);
    }

    for (int j = 0; j < countries.size(); j++) {
      driver.findElement(By.xpath(String.format("//a[.='%s']", countries.get(j)))).click();
      System.out.println(countries.get(j) + "\n");
      List<WebElement> rowsIn = driver.findElements(By.cssSelector("table.dataTable tr:not(.header)"));
      for (int i = 0; i < rowsIn.size() - 1; i++) {
        String zone = rowsIn.get(i).findElement(By.xpath(".//td[3]//option[@selected='selected']")).getText();
        System.out.println(zone);
        zones.add(zone);

      }
      assertTrue(isSorted(zones));

      driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
      zones.clear();


    }

  }
}











