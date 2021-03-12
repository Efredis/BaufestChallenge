package com.baufest.challenge;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BlazeAddCart {
	
	//Declaración de Variables
	WebDriver driver = DemoBlazeTests.driver;
	String username = DemoBlazeTests.user;
	String password = DemoBlazeTests.pass;	
	
	//Declaración de localizadores.

	By laptopLink = By.xpath("//*[@onclick=\"byCat('notebook')\"]");
	By firstLaptopLink = By.xpath("//*[@href='prod.html?idp_=8']");
	By laptopDescPage = By.id("more-information");
	By addToCartBtn = By.xpath("//*[@onclick='addToCart(8)']");
	By cartLinkPage = By.id("cartur");
	By deletePresent = By.linkText("Delete");


	//Test para agregar una laptop al carrito y comprobar que se agregó al carrito.
	@Test
	public void t3_addCart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(laptopLink));
		driver.findElement(laptopLink).click();
		wait.until(ExpectedConditions.elementToBeClickable(firstLaptopLink));
		if (driver.findElement(firstLaptopLink).isDisplayed()) {			
			driver.findElement(firstLaptopLink).click();
			wait.until(ExpectedConditions.elementToBeClickable(laptopDescPage));
			assertTrue(driver.findElement(laptopDescPage).isDisplayed());
			driver.findElement(addToCartBtn).click();
			wait.until(ExpectedConditions.alertIsPresent());
			String alerta = driver.switchTo().alert().getText();
			if((alerta).contains("Product added")) {
				driver.switchTo().alert().accept();
				System.out.println("Laptop agregada al carrito");
		}
		else{
			driver.quit();
			System.out.println("No se pudo agregar el producto");
		}   
	        driver.findElement(cartLinkPage).click();
	        wait.until(ExpectedConditions.elementToBeClickable(deletePresent));
	        assertTrue(driver.findElement(deletePresent).isDisplayed());
			System.out.println("Laptop en carrito y lista para comprar");
		}
		else {
			System.out.print("No es la página del carrito");
		}

	}
	
    //Post-Ejecución del test
	@After
	public void tearDown() throws Exception {
	driver.quit();
	}
}
