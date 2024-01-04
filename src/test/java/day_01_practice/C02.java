package day_01_practice;

import com.fasterxml.jackson.databind.introspect.Annotated;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.annotation.Annotation;
import java.time.Duration;

public class C02 {


    // https://www.techproeducation.com/ sayfasina gidin
    // Title ve Url'ini alın ve yazdırın
    // Title'in "Techpro" kelimesini içerip içermedigini test edin
    // Url'in "techproeducation" kelimesini içerip içermedigini test edin
    // https://www.amazon.com/ sayfasına gidin
    // Title'ini alın ve yazdırın
    // Title'in "more" kelimesini içerip içermedigini test edin
    // techproeducation.com'a geri dönün
    // sayfayı yenileyin
    // amazon.com'a tekrar gelin

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void techprotest01() {
        driver.get("https://www.techproeducation.com/");

        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        String techproTitle =driver.getTitle();
        System.out.println("TECHPROEDUCATION TITLE : " + techproTitle);
        String techproUrl =driver.getCurrentUrl();
        System.out.println("TECHPROEDUCATION URL : " + techproUrl);

        Assert.assertTrue(techproTitle.contains("Techpro"));

        Assert.assertTrue(techproUrl.contains("techproeducation"));

        driver.get("https://www.amazon.com/");

        String amazonTitle = driver.getTitle();
        System.out.println("AMAZON TITLE : " + amazonTitle);
        Assert.assertTrue(amazonTitle.contains("more"));

        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }


}
