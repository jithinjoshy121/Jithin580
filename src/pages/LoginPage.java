package pages;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	/*public WebElement email=driver.findElement(By.id("login-username"));
	public WebElement emailNext=driver.findElement(By.name("signin"));
	public WebElement password=driver.findElement(By.id("login-passwd"));
	public WebElement passwordNext=driver.findElement(By.name("verifyPassword"));
	public WebElement emailError= driver.findElement(By.xpath("//p[@id='username-error']"));
	public WebElement passwordError=driver.findElement(By.xpath("//p[@class='error-msg']"));*/
	
	//driver is null
	
	@FindBy(id="login-username")
	public static WebElement email;
	
	@FindBy(name="signin")
	public static WebElement emailNext;
	
	@FindBy(id="login-passwd")
	public static WebElement password;
	
	@FindBy(name="verifyPassword")
	public static WebElement passwordNext;
	
	@FindBy(xpath="//p[@id='username-error']")
	public static WebElement emailError;
	
	@FindBy(xpath="//p[@class='error-msg']")
	public static WebElement passwordError;
	
	
	  
    
	
	public void openBrowser() throws IOException
	{
		FileInputStream fs=new FileInputStream("C:\\testing\\prop.properties");
		Properties prop =new Properties();
		prop.load(fs);
		String browser=prop.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Seleniumjars\\geckodriver.exe");
			 driver =new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Seleniumjars\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		PageFactory.initElements(driver, this);
		
	}
	
	public void openYahoo()
	{
		driver.get("https://login.yahoo.com/?.src=ym&.partner=none&.lang=en-CA&.intl=ca&.done=https%3A%2F%2Fmail.yahoo.com%2Fd%3F.intl%3Dca%26.lang%3Den-CA%26.partner%3Dnone%26.src%3Dfp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void enterEmail(String a) throws InterruptedException
	{
		email.sendKeys(a);
		emailNext.click();
	      Thread.sleep(2000);
	}
	
	public void enterPassword(String b) throws InterruptedException
	{
		password.sendKeys(b);
		passwordNext.click();
		Thread.sleep(2000);
	}
	
	public String readPasswordError()
	{
		String msg=passwordError.getText();
		System.out.println(msg);
		return msg;
	}
	
	public String readEmailError() {
		String msg = emailError.getText();
		System.out.println(msg);
		return msg;
	}
}
