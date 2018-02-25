package ru.stqa.school.selenium;


import javafx.beans.binding.SetExpression;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CountrySortingTest extends TestBase {

  @Test

  public void countrySortingTest() {

    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    WebElement table = driver.findElement(By.cssSelector("[name=countries_form]"));
    List<WebElement> rows = table.findElements(By.cssSelector(".row"));
    List<String> countries = new ArrayList<>();
    List<String> zones = new ArrayList<>();
    List<String> countriesStates = new ArrayList<>();

    for (WebElement row : rows) {
      String country = row.findElement(By.xpath("./td[5]")).getAttribute("outerText");
      countries.add(country);
    }
    assertTrue(isSorted(countries));

    for (WebElement row : rows) {
      if (Integer.parseInt(row.findElement(By.cssSelector("td:nth-child(6)")).getAttribute("outerText")) !=0) {
        String countryState = row.findElement(By.xpath("./td[5]")).getAttribute("outerText");
        countriesStates.add(countryState);
      }}

      for (int j = 0; j < countriesStates.size(); j++) {
          driver.findElement(By.xpath(String.format("//a[.='%s']",countriesStates.get(j)))).click();
          System.out.println( countriesStates.get(j)+ "\n");
          List<WebElement> rowsIn = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[not(@class='header')]"));
          for (WebElement rowIn : rowsIn) {
            String zone = rowIn.findElement(By.cssSelector("td:nth-child(3)")).getAttribute("outerText");
            zones.add(zone);
          }
        zones.remove(zones.size()-1);
        assertTrue(isSorted(zones));
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        zones.clear();

        }

      }


   }





