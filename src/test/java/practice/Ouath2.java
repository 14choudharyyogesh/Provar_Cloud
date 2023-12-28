package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import api.resource.testdata;

public class Ouath2 {

	
	public void Ouath() {
		testdata data = new testdata();
		String accesstokenurl = data.endurl + "?CONSUMER KEY=" + data.Consumerkey + "&CONSUMER SECRET="
				+ data.Consumersecret + "&CALLBACK URL=+" + data.callbackurl;

		System.setProperty("webdriver.chrome,driver", "RestAssuredPoc/Provar_Cloud/src/Drivers");

		WebDriver driver = new ChromeDriver();
		driver.get(accesstokenurl);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ravindra.yadav@testmanager.qa");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Provar04");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		

		String codeurl = driver.getCurrentUrl();

		System.out.println(codeurl);

	}
}


