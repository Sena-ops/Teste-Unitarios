// CheckboxTest.java
package com.example.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class CheckboxTest extends BaseTest {

    @Test
    public void shouldToggleCheckboxes() {
        WebElement cb1 = wait.until(d -> d.findElement(By.id("my-check-1")));
        WebElement cb2 = driver.findElement(By.id("my-check-2"));

        /* objetivo: cb1 = marcado, cb2 = desmarcado */
        if (!cb1.isSelected()) cb1.click();
        if (cb2.isSelected())  cb2.click();

        assertTrue(cb1.isSelected());
        assertFalse(cb2.isSelected());
    }
}
