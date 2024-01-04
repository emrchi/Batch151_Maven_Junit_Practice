package day_01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {

    // https://ebay.com sayfasına gidiniz
    // electronics bolumune tıklayınız
    // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız.

    WebDriver driver;
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void ebay() {
        driver.get("https://ebay.com");
        driver.findElement(By.xpath("(//*[@class='hl-cat-nav__js-tab'])[1]")).click();
        List<WebElement> pictures=driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for (int i = 0; i < pictures.size() ; i++){
            pictures=driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            pictures.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }

    }
}
