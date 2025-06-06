// FileUploadTest.java
package com.example.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileUploadTest extends BaseTest {

    @Test
    public void shouldUploadFile() {
        WebElement fileInput = wait.until(d -> d.findElement(By.name("my-file")));
        String path = Paths.get("src/test/resources/exemplo.txt")
                .toAbsolutePath().toString();
        fileInput.sendKeys(path);
        assertTrue(fileInput.getAttribute("value").contains("exemplo.txt"));
    }
}
