package multipleBrowsers;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class Elements50 {
	private String url;
	private String username;
	private String password;
	private String usernameXPath;
	private String passwordXPath;
	private String loginButtonXPath;
	private String profileXPath;
	private String logoutXPath;
	private String continuesXpath;
	private WebDriver driver;
	
	//public String continuesXpath;
 
	public Elements50(String url, String username, String password, String usernameXPath, String passwordXPath,
			String loginButtonXPath, String profileXPath, String logoutXPath, String continuesXpath) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.usernameXPath = usernameXPath;
		this.passwordXPath = passwordXPath;
		this.loginButtonXPath = loginButtonXPath;
		this.profileXPath = profileXPath;
		this.logoutXPath = logoutXPath;
		//this.continues = continues;
		this.continuesXpath = continuesXpath;
		this.driver = new ChromeDriver(); // Make sure to set the path to the WebDriver executable
	}
 
	public void login() throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		WebElement usernameField = driver.findElement(By.xpath(usernameXPath));
		usernameField.sendKeys(username);
		if (continuesXpath != null) {
            WebElement continues = driver.findElement(By.xpath(continuesXpath));
            continues.click();
            Thread.sleep(1000); // Wait for the next page to load
        }
		WebElement passwordField = driver.findElement(By.xpath(passwordXPath));
		passwordField.sendKeys(password);
		WebElement loginButton = driver.findElement(By.xpath(loginButtonXPath));
		loginButton.click();
		Thread.sleep(2000);
 
	}
 
	public void logout() {
		WebElement profileButton = driver.findElement(By.xpath(profileXPath));
		profileButton.click();
		WebElement logoutButton = driver.findElement(By.xpath(logoutXPath));
		scrollToElement(logoutButton);
		logoutButton.click();
	}
 
	public void close() {
		driver.quit();
	}
 
	private void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
 
 
