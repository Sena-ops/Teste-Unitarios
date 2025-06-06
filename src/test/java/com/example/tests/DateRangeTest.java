// DateRangeTest.java
package com.example.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DateRangeTest extends BaseTest {

    @Test
    public void shouldSetDatePicker() {
        WebElement date = wait.until(d -> d.findElement(By.name("my-date")));
        String tomorrow = LocalDate.now().plusDays(1).toString();   // yyyy-MM-dd
        date.clear();
        date.sendKeys(tomorrow);
        assertEquals(tomorrow, date.getAttribute("value"));
    }

    // DateRangeTest.java  (substitua apenas este método)
    @Test
    public void shouldSetRangeSlider() {
        WebElement range = wait.until(d -> d.findElement(By.name("my-range")));
        String max = range.getAttribute("max");          // ex.: "10"
        if (max == null || max.isBlank()) max = "5";

        /* muda o valor via JavaScript, que funciona em qualquer browser */
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));",
                        range, max);

        assertEquals(max, range.getAttribute("value"));
    }
}
