package com.baufest.challenge;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeTests {
	//Declaración de variables, las estáticas son las compartidas para su uso con las otras clases.
	public static WebDriver driver;
	public static String user = "";
	public static String pass = "";
	int username = (int)(Math.random()*(8-6)+6);	
	int password = (int)(Math.random()*(8-6)+6);	
	
	
	//Declaración de localizadores.
	By signUpLink = By.id("signin2");
	By registerPageLocator = By.id("signInModalLabel");
	By usernameLocator = By.id("sign-username");
	By passwordLocator = By.id("sign-password");
	By signUpBtnLocator = By.xpath("//button[@onclick='register()']");
	
	//Pre-Ejecución del test. Llamando a url de prueba.
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");	
		assertEquals("STORE", driver.getTitle());
	}
	
	//Test para realizar el alta un usuario.
	@Test
	public void t1_DemoBlazeTest() throws InterruptedException {
		//Inicializando variable para espera explícita.
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Ejecutando ciclo para generar entre 6 y 8 caracteres alfabéticos aleatorios que formarán el usuario.
		for (int i=0; i<username; i++){ 
		     int codigoAscii = (int)Math.floor(Math.random()*(122 -97)+97); 
		     user = user + (char)codigoAscii; 
		} 		
		     System.out.println("El usuario creado es: " + user);
		//Ejecutando ciclo para generar entre 6 y 8 caracteres alfabéticos aleatorios que formarán el password.     
		for (int i=0; i<password; i++){ 
			 int codigoAscii = (int)Math.floor(Math.random()*(122-97)+97); 
			 pass = pass + (char)codigoAscii; 
		}		     
		driver.findElement(signUpLink).click();
		wait.until(ExpectedConditions.elementToBeClickable(registerPageLocator));
		if (driver.findElement(registerPageLocator).isDisplayed()) {			
			driver.findElement(usernameLocator).sendKeys(user);
			driver.findElement(passwordLocator).sendKeys(pass);
			driver.findElement(signUpBtnLocator).click();
			/*Se espera hasta que la alerta aparezca, luego se valida que es la alerta esperada según su mensaje y a continuación 
			acepta si es correcto o envía mensaje correspondiente si es incorrecto y sale.*/
			wait.until(ExpectedConditions.alertIsPresent());
			String alerta = driver.switchTo().alert().getText();
			if((alerta).contains("Sign up successful.")) {
				driver.switchTo().alert().accept();
				System.out.println("Usuario Registrado");
			}
			else{
				System.out.println("Usuario registrado, por favor, registre uno nuevo");
				driver.quit();
			} 
		}
		else {
			 System.out.print("Página de registro no encontrada");
		}		
	}	
}
