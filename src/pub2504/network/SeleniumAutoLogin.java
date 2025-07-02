package pub2504.network;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAutoLogin {
	
// [Selenium을 활용한 자동로그인]
// https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\pub2504\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try {
			
			// 웹브라우저 시작하고 웹페이지 로딩
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			Thread.sleep(2000);
			
			// 아이디 입력 input 엘리먼트
			WebElement usernameInput = driver.findElement(By.name("username"));
			// 아이디 입력 
			usernameInput.sendKeys("Admin");
			
			// 비밀번호 입력 input 엘리먼트
			WebElement passwordInput = driver.findElement(By.name("password"));
			// 비밀번호 입력 
			passwordInput.sendKeys("admin123");
			
			// 로그인 button 엘리먼트
			WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
			loginButton.click();
			
			Thread.sleep(3000);
			
			// [실습] 사용자 추가
			// 1. 페이지 이동
			// https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser
			// 2. Username 입력, User Role 선택, Employee Name 입력, Status 선택 후
			// 3. Add눌러서 추가
			
			// 페이지 이동
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser");

			Thread.sleep(2000);
			
			// select 선택
			List<WebElement> selectList = driver.findElements(By.cssSelector(".oxd-select-text[data-v-13cf171c]"));
			selectList.get(0).click();
			Thread.sleep(1000);
			
			// User Role dropdown 선택
			List<WebElement> optionList1 = driver.findElements(By.cssSelector(".oxd-select-dropdown"));
			optionList1.get(0).click();
			Thread.sleep(1000);
			
			// Status 선택
			selectList.get(1).click();
			// Status dropdown 선택
			List<WebElement> optionList2 = driver.findElements(By.cssSelector(".oxd-select-dropdown"));
			optionList2.get(0).click();
			
			Thread.sleep(2000);
			
			// 입력 input 엘리먼트들
			List<WebElement> inputList = driver.findElements(By.tagName("input"));
			
			// Employee Name
			inputList.get(1).sendKeys("John");
			Thread.sleep(3000);
			List<WebElement> optionList3 = driver.findElements(By.cssSelector(".oxd-autocomplete-dropdown"));
			optionList3.get(0).click();
			
			Thread.sleep(2000);
			
			WebElement empInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[placeholder='Type for hints...']")
			));
			
			
			// Username, Password, ConfirmPassword
			inputList.get(2).sendKeys("testtest1");
			inputList.get(3).sendKeys("testtest123");
			inputList.get(4).sendKeys("testtest123");

			Thread.sleep(2000);

			WebElement saveButton = driver.findElement(By.cssSelector(".oxd-button--secondary[data-v-10d463b7]"));
			saveButton.click();
			
			System.out.println("사용자 추가 완료!");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
//			driver.quit();
		}
		
	} // main
	
} // class
