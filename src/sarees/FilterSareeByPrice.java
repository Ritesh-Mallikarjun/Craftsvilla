package sarees;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
public class FilterSareeByPrice
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.craftsvilla.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[.='SAREES']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(text(),'2000-5000')])[2]")).click();
		Thread.sleep(5000);
		/*driver.findElement(By.xpath("(//div[@class='col-xs-12 product'])[3]")).click();
		or*/
		driver.findElements(By.xpath("//a[@class='product-name truncate']")).get(2).click();
		
		Thread.sleep(5000);
		String price=driver.findElement(By.xpath("//span[@class='pdp-offer-price']")).getText().replaceAll("₹","").replaceAll(" ", "");
		Thread.sleep(3000);
		int actualPrice=Integer.parseInt(price);
		try
		{
			Assert.assertTrue(actualPrice>=2000 && actualPrice<=5000,"Price is not within the range...");
			Reporter.log("Price is within the range...",true);
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
		driver.close();
	}
}
