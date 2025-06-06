// DisabledReadonlyTest.java
package com.example.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class DisabledReadonlyTest extends BaseTest {

    @Test
    public void disabledInputShouldNotBeEditable() {
        WebElement disabled = wait.until(d -> d.findElement(By.name("my-disabled")));
        assertFalse("campo deve estar desabilitado", disabled.isEnabled());
    }

    @Test
    public void readonlyInputShouldNotChangeValue() {
        WebElement readOnly = wait.until(d -> d.findElement(By.name("my-readonly")));
        String original = readOnly.getAttribute("value");
        readOnly.sendKeys("xxx");
        assertEquals(original, readOnly.getAttribute("value"));
    }
}
