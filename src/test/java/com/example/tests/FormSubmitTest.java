// FormSubmitTest.java
package com.example.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class FormSubmitTest extends BaseTest {

    @Test
    public void shouldSubmitAllFields() throws Exception {
        driver.findElement(By.id("my-text-id")).sendKeys("Hello world");
        driver.findElement(By.name("my-password")).sendKeys("123456");
        driver.findElement(By.name("my-textarea")).sendKeys("algum texto");

        new Select(driver.findElement(By.name("my-select"))).selectByValue("3");
        driver.findElement(By.name("my-date")).sendKeys("2025-12-25");
        driver.findElement(By.name("my-range")).sendKeys("4");

        /* cria um txt temporário para upload */
        Path tmp = Files.createTempFile("upload-", ".txt");
        Files.writeString(tmp, "dummy");
        driver.findElement(By.name("my-file")).sendKeys(tmp.toString());

        if (!driver.findElement(By.id("my-check-1")).isSelected())
            driver.findElement(By.id("my-check-1")).click();

        wait.until(d -> d.findElement(By.cssSelector("button[type='submit']"))).click();

        wait.until(d -> d.getCurrentUrl().contains("submitted-form.html"));
        String h1 = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Form submitted", h1.trim());

    }
}
