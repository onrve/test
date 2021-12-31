package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSite {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.beymen.com/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement searchelement = driver.findElement(By.className("default-input"));
        searchelement.click();
        searchelement.sendKeys("pantolon");
        searchelement.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("o-productList__item")));
        WebElement more = driver.findElement(By.xpath("//div[@class='o-productList__item']"));


//        jse.executeScript("window.scrollBy(0,1000)");
        jse.executeScript("arguments[0].scrollIntoView();", more);

        WebElement emore = driver.findElement(By.xpath("//button[@id='moreContentButton']"));
        emore.click();

//        WebDriverWait wait1 = new WebDriverWait(driver, 10);
//        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("m-productCard__detail")));

        WebElement randomelement = driver.findElement(By.cssSelector("a[href*='/p_']"));
        randomelement.click();


        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("m-variation__item")));
        WebElement size = driver.findElement(By.xpath("//span[@class='m-variation__item']"));
        size.click();

        WebElement add = driver.findElement(By.xpath("//button[@id='addBasket']"));
        add.click();

        WebElement price = driver.findElement(By.id("priceNew"));
        String price1 = price.getText();

        Thread.sleep(2000);

        driver.get("https://www.beymen.com/cart");

        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("m-productPrice__salePrice")));
        WebElement price2 = driver.findElement(By.className("m-productPrice__salePrice"));
        String price2p = price2.getText();

        // Fiyat doğrulama
        if (price1.equals(price2p)) {
            System.out.println("Fiyat eşit!");
        }
        else {
            System.out.println("Fiyat eşit değil!");
        }

        Thread.sleep(1000);
        Select two = new Select(driver.findElement(By.id("quantitySelect0")));
        two.selectByIndex(1);
        WebElement option = two.getFirstSelectedOption();
        //Kaç adet olduğunun teyiti
        System.out.println(option.getText());
        Thread.sleep(3000);

        WebElement deleteelement = driver.findElement(By.id("removeCartItemBtn0"));
        deleteelement.click();











    }

}
