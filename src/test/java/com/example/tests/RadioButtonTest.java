// RadioButtonTest.java
package com.example.tests;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class RadioButtonTest extends BaseTest {

    @Test
    public void shouldSelectDefaultRadio() {
        assertTrue(driver.findElement(By.id("my-radio-1")).isSelected());
    }
}
