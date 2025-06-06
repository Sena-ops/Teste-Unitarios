// TextInputTest.java
package com.example.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.*;

public class TextInputTest extends BaseTest {

    @Test
    public void shouldSubmitTextInput() {
        driver.findElement(By.id("my-text-id")).sendKeys("MeuTeste");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        /* aguarda a navegação para submitted-form.html */
        wait.until(ExpectedConditions.urlContains("submitted-form.html"));
        String msg = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Form submitted", msg.trim());

    }
}
