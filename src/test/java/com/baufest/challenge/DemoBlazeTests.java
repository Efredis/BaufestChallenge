package com.baufest.challenge;
import org.junit.Before;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Anotación para orden de ejecución de los test
public class DemoBlazeTests {
	private WebDriver driver;
	//Declaración de localizadores.
	By SignUpLink = By.id("signin2");
	By registerPageLocator = By.xpath("//h5[@id='signInModalLabel']");
	By usernameLocator = By.id("sign-username");
	By passwordLocator = By.id("sign-password");
	By signUpBtnLocator = By.xpath("//button[@onclick='register()']");
	By SignInLink = By.id("login2");
	By SignInLocator = By.xpath("//h5[@id='logInModalLabel']");
	By usernameLogin = By.id("loginusername");
	By passwordLogin = By.id("loginpassword");
	By LoginBtnLocator = By.xpath("//button[@onclick='logIn()']");
	By SignOutPresent = By.xpath("//a[@id='logout2']");
	By laptopLink = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
	By laptopPageLocator = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div ");
	By firstLaptopLink = By.xpath("//a[@href=\"prod.html?idp_=8\"]");
	By LaptopDescPage = By.xpath("//div[@id=\"more-information\"]");
	By AddToCartBtn = By.xpath("//a[@onclick='addToCart(8)']");
	By cartLinkPage = By.id("cartur");
	By deletePresent = By.linkText("Delete");
	
	//Pre-Ejecución del test. Llamadon a url de prueba.
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");	
		
	}
	
	//Post-Ejecución del test
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	//Test para realizar el alta un usuario.
	@Test
	public void t1_DemoBlazeTest() throws InterruptedException {
		driver.findElement(SignUpLink).click();
		Thread.sleep(3000);
		if (driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(usernameLocator).sendKeys("UserBaufest1");
			driver.findElement(passwordLocator).sendKeys("whatIwant");
			driver.findElement(signUpBtnLocator).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			assertEquals("STORE", driver.getTitle());
			}
		else {
			System.out.print("Página de registro no encontrada");
		}
		
	}
	
	//Test para realizar Login y logout con el usuario dado de	alta
	@Test
	public void t2_signInOut() throws InterruptedException {
		driver.findElement(SignInLink).click();
		Thread.sleep(3000);
		if (driver.findElement(SignInLocator).isDisplayed()) {			
			driver.findElement(usernameLogin).sendKeys("UserBaufest1");
			driver.findElement(passwordLogin).sendKeys("whatIwant");
			driver.findElement(LoginBtnLocator).click();
			Thread.sleep(3000);
			assertTrue(driver.findElement(SignOutPresent).isDisplayed());
			driver.findElement(SignOutPresent).click();
			Thread.sleep(3000);
			assertTrue(driver.findElement(SignInLink).isDisplayed());
		}
		else {
			System.out.print("Esta no es la Página del logueo");
		}
	}
	
	//Test para agregar una laptop al carrito y comprobar que se agregó al carrito.
	@Test
	public void t3_addCart() throws InterruptedException {
		driver.findElement(laptopLink).click();
		Thread.sleep(3000);
		if (driver.findElement(laptopPageLocator).isDisplayed()) {			
			driver.findElement(firstLaptopLink).click();
			Thread.sleep(3000);
			assertTrue(driver.findElement(LaptopDescPage).isDisplayed());
			driver.findElement(AddToCartBtn).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.findElement(cartLinkPage).click();
			Thread.sleep(3000);
			assertTrue(driver.findElement(deletePresent).isDisplayed());
		}
		else {
			System.out.print("Página No Esperada");
		}
	}
}
