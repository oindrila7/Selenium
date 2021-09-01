import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestSeleniumJunit {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver");
       ChromeOptions ops=new ChromeOptions();
        //ops.addArguments("--headed");
        ops.addArguments("--headless");//for not opening browser
        driver=new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void getTitle(){
        driver.get("https://demoqa.com");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("ToolsQA"));
    }

    @Test
    public void checkIfElementExists() throws InterruptedException {
        driver.get("https://demoqa.com");
        //Boolean status=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/images/ToolSqa.jpg']"))).isDisplayed();
        Boolean status = driver.findElement(By.xpath("//img[@src='/images/ToolSqa.jpg']")).isDisplayed();
        Assert.assertEquals(status,true);
    }

    @After
    public void finishTest(){
        driver.close();
    }
}
