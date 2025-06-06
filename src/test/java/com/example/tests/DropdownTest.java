// DropdownTest.java
package com.example.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class DropdownTest extends BaseTest {

    @Test
    public void shouldSelectOptionTwo() {
        /* o <select> não tem id – usa name */
        Select select = new Select(wait.until(
                ExpectedConditions.elementToBeClickable(By.name("my-select"))));

        select.selectByValue("2");
        assertEquals("2", select.getFirstSelectedOption().getAttribute("value"));
    }
}
