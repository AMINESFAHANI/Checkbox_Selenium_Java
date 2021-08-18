
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Handling_Check_Boxes {

        public static void main(String[] args) throws InterruptedException {

            File file = new File("src/main/resources/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            WebDriver driver = new ChromeDriver();// ChomeDriver is an implementation of a web driver interface

            WebDriverWait wait=new WebDriverWait(driver, 5);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;

            // Navigate to the spicejet website
            driver.manage().window().maximize();
            driver.navigate().to("https://www.spicejet.com/");
            wait.until(ExpectedConditions.titleIs("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets"));
            driver.navigate().refresh();



            ///html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[12]/div[2]/input : It is Absolute Xpath that related to Senior Citizen
            ///*[@id="ctl00_mainContent_chk_SeniorCitizenDiscount"] : Relative Xpath that is related to Senior Citizen Checkbox
            //input[id*='SeniorCitizenDiscount'] CSS selector (It is combined by tag name and id)


            ///html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[12]/div[1]/input : It is Absolute Xpath that is related to Family and Friends
            ////*[@id="ctl00_mainContent_chk_friendsandfamily"] : Relative Xpath that is related to Friends and Families Checkbox
            // input[id*='ctl00_mainContent_chk_friendsandfamily'] : It is combined by the tag name


            WebElement seniorCitizen = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
            System.out.println(seniorCitizen.isSelected());
            System.out.println(seniorCitizen.getAttribute("id"));

            seniorCitizen.click();
            wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_chk_SeniorCitizenDiscount\"]"))));
            System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());


            List<WebElement> checkboxes = driver.findElements(By.xpath("/html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[12]/div/input"));

            //Iterating through the checkboxes
            System.out.println(checkboxes.size());
            for (WebElement checkBox: checkboxes){
                wait.until(ExpectedConditions.visibilityOf(checkBox));
                System.out.println(checkBox.isSelected());
                System.out.println(checkBox.getAttribute("id"));
                checkBox.click();
                System.out.println(checkBox.isSelected());
                Thread.sleep(1000);
            }

            driver.close();




        }
    }

