package com.vueJSBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class TestVueJSBrowser {

    public static void main(String[] args) {

        //Specify parameters here:
        String chromeDriverPath="D://LETHA//KATALON//chromedriver_win32//chromedriver.exe";
        String URL="https://todomvc.com/examples/vue/";
        String todoItem1="Read";
        String todoItem2="Travel";
        String todoItemCount="2 items left";

        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        //initialize chrome driver instance
        WebDriver driver = new ChromeDriver();


        //@Given("^User launch vue homepage$")
        //start a new chrome browser
        driver.get(URL);
        driver.manage().window().maximize();

        // check for 'what needs to be done element is available in browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element=driver.findElement(By.xpath("/html[1]/body[@class='learn-bar']/section[@class='todoapp']/header[@class='header']/input[@class='new-todo']"));
        boolean blElementPresent=element.isDisplayed();
        if (blElementPresent)
        {
            System.out.println("Pass - what needs to be done element is present");
        }
        else
        {
            System.out.println("Fail - what needs to be done element is not present");
        }

        //@Then("^Enter to do items")
        element.sendKeys(todoItem1);
        element.sendKeys(Keys.ENTER);
        element.sendKeys(todoItem2);
        element.sendKeys(Keys.ENTER);

        // Look for the count of items added
        WebElement totCount=driver.findElement(By.className("todo-count"));
        if (todoItemCount.equals(totCount.getText()))
        {
            System.out.println("Pass - Total items added count is as expected");
        }
        else
        {
            System.out.println("Fail - Total items added count is not as expected");
        }

        // Close the browser
        driver.quit();

    }
}
