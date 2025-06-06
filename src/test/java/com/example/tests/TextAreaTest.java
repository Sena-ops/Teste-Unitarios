// TextAreaTest.java
package com.example.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class TextAreaTest extends BaseTest {

    @Test
    public void shouldSubmitTextArea() {
        WebElement area = wait.until(d -> d.findElement(By.name("my-textarea")));
        area.clear();
        area.sendKeys("Texto grande");
        assertEquals("Texto grande", area.getAttribute("value"));
    }
}
