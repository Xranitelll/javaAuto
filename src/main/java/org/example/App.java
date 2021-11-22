package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        // 1 - Make Agency
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // first part - auth part
        driver.get("https://crm.geekbrains.space");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

        // second part
        WebElement mainClickAgency = driver.findElement(By.xpath("//a[@href=\"#\"]/span[@class=\"title\"] [text()='Контрагенты']"));
        mainClickAgency.click();
        driver.findElement(By.xpath("//a[@href=\"/company/\"]/span[@class=\"title\"] [text()='Организации']")).click();
        driver.findElement(By.linkText("Создать организацию")).click();

        // Изменяем переменные sendKeys для повторного запуска
        driver.findElement(By.xpath("//input[@name=\"crm_company[name]\"]")).sendKeys("Тестя32");
        driver.findElement(By.xpath("//input[@name=\"crm_company[shortName]\"]")).sendKeys("Тестя32");

        driver.findElement(By.xpath("//input[@name=\"crm_company[companyType][]\"] [@value=\"2\"]")).click();
        driver.findElement(By.xpath("//select[@name=\"crm_company[industry]\"]/option[@value=\"1\"]")).click();
        driver.findElement(By.linkText("Добавить адрес")).click();
        driver.findElement(By.xpath("//input[@name=\"crm_company[addresses][1][postIndex]\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@name=\"crm_company[addresses][1][street]\"]")).sendKeys("Иванова");
        driver.findElement(By.xpath("//input[@name=\"crm_company[addresses][1][building]\"]")).sendKeys("152");
        driver.findElement(By.linkText("Добавить телефон")).click();
        driver.findElement(By.xpath("//select[@name=\"crm_company[phones][1][type]\"]/option[@value=\"office\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"crm_company[phones][1][prefixCode]\"]")).sendKeys("085");
        driver.findElement(By.xpath("//input[@name=\"crm_company[phones][1][phone]\"]")).sendKeys("1234567");
        driver.findElement(By.xpath("//select[@name=\"crm_company[manager]\"]/option[@value=\"115\"]")).click();
        driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();
        Thread.sleep(5000);
        driver.quit();

        // 2 - Make agency contact person
        WebDriver driverSecondTest = new ChromeDriver();
        driverSecondTest.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // first part - auth part
        driverSecondTest.get("https://crm.geekbrains.space");
        driverSecondTest.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driverSecondTest.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driverSecondTest.findElement(By.id("_submit")).click();

        // second part
        driverSecondTest.findElement(By.xpath("//a[@href=\"#\"]/span[@class=\"title\"] [text()='Контрагенты']")).click();
        driverSecondTest.findElement(By.xpath("//a[@href=\"/contact/\"]/span[@class=\"title\"] [text()='Контактные лица']")).click();
        driverSecondTest.findElement(By.xpath("//div[@class=\"btn-group\"]/div[@class=\"pull-left btn-group icons-holder\"]/a[@href=\"/contact/create\"]")).click();
        driverSecondTest.findElement(By.xpath("//input[@name=\"crm_contact[lastName]\"]")).sendKeys("TestOnes");
        driverSecondTest.findElement(By.xpath("//input[@name=\"crm_contact[firstName]\"]")).sendKeys("TestOnes one");
        driverSecondTest.findElement(By.xpath("//a[@class=\"select2-choice select2-default\"]")).click();

        // Изменяем переменные sendKeys для повторного запуска
        driverSecondTest.findElement(By.xpath("//input[@class=\"select2-input select2-focused\"]")).sendKeys("Тестя32");

        driverSecondTest.findElement(By.xpath("//span[@class=\"select2-match\"]")).click();
        driverSecondTest.findElement(By.xpath("//input[@name=\"crm_contact[jobTitle]\"]")).sendKeys("Tester tester");
        driverSecondTest.findElement(By.xpath("//button[@class=\"btn btn-success action-button\"]")).click();
        Thread.sleep(5000);
        driver.quit();

        // 3 - Make project
        WebDriver driverTherdTest = new ChromeDriver();
        driverTherdTest.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // first part - auth part
        driverTherdTest.get("https://crm.geekbrains.space");
        driverTherdTest.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driverTherdTest.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driverTherdTest.findElement(By.id("_submit")).click();

        // second part
        WebElement mainClickProject = driverTherdTest.findElement(By.xpath("//a[@href=\"#\"]/span[@class=\"title\"] [text()='Проекты']"));
        mainClickProject.click();
        driverTherdTest.findElement(By.xpath("//a[@href=\"/project/my\"]/span[@class=\"title\"] [text()='Мои проекты']")).click();
        driverTherdTest.findElement(By.linkText("Создать проект")).click();

        // Изменяем переменную sendKeys для повторного запуска
        driverTherdTest.findElement(By.xpath("//input[@name=\"crm_project[name]\"]")).sendKeys("My test test 11");

        driverTherdTest.findElement(By.xpath("//a[@class=\"select2-choice select2-default\"]/span[@class=\"select2-arrow\"]")).click();

        // Изменяем переменные sendKeys для повторного запуска
        driverTherdTest.findElement(By.cssSelector(".select2-focused")).sendKeys("Тестя32");

        driverTherdTest.findElement(By.xpath("//span[@class=\"select2-match\"]")).click();
        driverTherdTest.findElement(By.xpath("//select[@name=\"crm_project[businessUnit]\"]/option[@value=\"1\"]")).click();
        driverTherdTest.findElement(By.xpath("//select[@name=\"crm_project[curator]\"]/option[@value=\"115\"]")).click();
        driverTherdTest.findElement(By.xpath("//select[@name=\"crm_project[rp]\"]/option[@value=\"115\"]")).click();
        driverTherdTest.findElement(By.xpath("//select[@name=\"crm_project[manager]\"]/option[@value=\"115\"]")).click();
        driverTherdTest.findElement(By.xpath("//div[@class=\"select2-container select2\"]/a[@href=\"javascript:void(0)\"]/span[@class=\"select2-arrow\"]")).click();
        driverTherdTest.findElement(By.xpath("//div[@class=\"select2-result-label\"]")).click();
        driverTherdTest.findElement(By.xpath("//button[@class=\"btn btn-success action-button\"]")).click();
        Thread.sleep(5000);
        driverTherdTest.quit();
    }
}
