package br.senai.sp.testegamemania;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	private WebDriver driver;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chapeleiro\\Documents\\projeto-eclipse\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();	
	}
	
	@Test
	public void TestarLogin() {
		driver.get("http://localhost:4200/");
		
		//primeiro teste
		WebElement inputEmail =  driver.findElement(By.id("email"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement botão = driver.findElement(By.id("login"));
		
		String[] listaSenhas = {"batata123","batatacombacon12","Isa123"};
		
		
		for(int tentativas = 0; tentativas <3; tentativas++) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inputEmail.clear();
			inputSenha.clear();
			
			inputEmail.sendKeys("Barbara@lorrane");
			inputSenha.sendKeys(listaSenhas[tentativas]);
			botão.click();
			
		}
		
		WebElement mensagem = driver.findElement(By.id("mensagem"));
		
		System.out.println(mensagem.getText());
		
	}

}
