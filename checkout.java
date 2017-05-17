package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutNYC {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.gagacenter.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCheckoutNYC() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("View Programs")).click();
    driver.findElement(By.linkText("VIEW SCHEDULE FOR GRADES K-5")).click();
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.id("id_name")).clear();
    driver.findElement(By.id("id_name")).sendKeys("Testing Player");
    new Select(driver.findElement(By.id("id_grade"))).selectByVisibleText("4th");
    new Select(driver.findElement(By.id("id_birth_date_month"))).selectByVisibleText("February");
    new Select(driver.findElement(By.id("id_birth_date_day"))).selectByVisibleText("16");
    new Select(driver.findElement(By.id("id_birth_date_year"))).selectByVisibleText("2005");
    driver.findElement(By.id("id_school")).clear();
    driver.findElement(By.id("id_school")).sendKeys("testing");
    driver.findElement(By.id("id_address1")).clear();
    driver.findElement(By.id("id_address1")).sendKeys("testing address");
    driver.findElement(By.id("id_city")).clear();
    driver.findElement(By.id("id_city")).sendKeys("NY");
    driver.findElement(By.id("id_zip")).clear();
    driver.findElement(By.id("id_zip")).sendKeys("10010");
    driver.findElement(By.id("id_phone")).clear();
    driver.findElement(By.id("id_phone")).sendKeys("4564564565");
    driver.findElement(By.id("id_email")).clear();
    driver.findElement(By.id("id_email")).sendKeys("jhidalgo@cakeandarrow.com");
    driver.findElement(By.id("id_parent1_name")).clear();
    driver.findElement(By.id("id_parent1_name")).sendKeys("Test Parent1");
    driver.findElement(By.id("id_parent1_cell")).clear();
    driver.findElement(By.id("id_parent1_cell")).sendKeys("7897897898");
    driver.findElement(By.id("id_parent2_name")).clear();
    driver.findElement(By.id("id_parent2_name")).sendKeys("Test Parent2");
    driver.findElement(By.id("id_parent2_cell")).clear();
    driver.findElement(By.id("id_parent2_cell")).sendKeys("7897897898");
    driver.findElement(By.id("id_emergency_name")).clear();
    driver.findElement(By.id("id_emergency_name")).sendKeys("Test Emergency");
    driver.findElement(By.id("id_emergency_phone")).clear();
    driver.findElement(By.id("id_emergency_phone")).sendKeys("7537537535");
    driver.findElement(By.id("id_physician_name")).clear();
    driver.findElement(By.id("id_physician_name")).sendKeys("Test Physician");
    driver.findElement(By.id("id_physician_phone")).clear();
    driver.findElement(By.id("id_physician_phone")).sendKeys("9519519515");
    driver.findElement(By.id("id_allergies_concerns")).clear();
    driver.findElement(By.id("id_allergies_concerns")).sendKeys("Testing Allergies");
    driver.findElement(By.name("billing_as_shipping")).click();
    driver.findElement(By.id("id_cc_num")).clear();
    driver.findElement(By.id("id_cc_num")).sendKeys("4111111111111111");
    new Select(driver.findElement(By.id("id_cc_exp_mo"))).selectByVisibleText("04");
    new Select(driver.findElement(By.id("id_cc_exp_yr"))).selectByVisibleText("2017");
    driver.findElement(By.id("id_cc_cvv")).clear();
    driver.findElement(By.id("id_cc_cvv")).sendKeys("789");
    driver.findElement(By.id("id_agree_terms")).click();
    driver.findElement(By.cssSelector("button.button")).click();
    try {
      assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "You just signed up for the coolest game ever!");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Watch your inbox for an email confirming your enrollment from alex@schmelkin.com.");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.cssSelector("p")).getText(), "Name: Testing Player\n Session: NYC Winter-Spring Grades K-1, Mondays 3:30\n Start Date: Feb. 2, 2015\n Time: Mondays at 3:30pm\n Location: 230 East 93rd Street, New York, NY 10128\n Price: $532.00 - 14 sessions");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Please remember that all players must wear sneakers. See you in a pit!");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
