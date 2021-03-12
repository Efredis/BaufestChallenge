package com.baufest.challenge;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlazeLoginOut {
	
	//Declaración de Variables
	WebDriver driver = DemoBlazeTests.driver;
	String username = DemoBlazeTests.user;
	String password = DemoBlazeTests.pass;	
	
	
	//Declaración de localizadores.
	By signInLink = By.id("login2");
	By signInLocator = By.id("logInModalLabel");
	By usernameLogin = By.id("loginusername");
	By passwordLogin = By.id("loginpassword");
	By loginBtnLocator = By.xpath("//button[@onclick='logIn()']");
	By signOutPresent = By.id("logout2");
	
	//Test para realizar login y logout con el usuario dado de	alta
	@Test
	public void t2_signInOut() throws InterruptedException {
		//Inicializando variable para espera explícita.
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.findElement(signInLink).click();
		wait.until(ExpectedConditions.elementToBeClickable(signInLocator));
		if (driver.findElement(signInLocator).isDisplayed()) {			
			driver.findElement(usernameLogin).sendKeys(username);
			driver.findElement(passwordLogin).sendKeys(password);
			driver.findElement(loginBtnLocator).click();
			System.out.println("Usuario Logueado");
			wait.until(ExpectedConditions.elementToBeClickable(signOutPresent));
			assertTrue(driver.findElement(signOutPresent).isDisplayed());
			driver.findElement(signOutPresent).click();
			wait.until(ExpectedConditions.elementToBeClickable(signInLink));
			assertTrue(driver.findElement(signInLink).isDisplayed());
			System.out.println("Usuario cierra sesión");
		}
		else {
			System.out.println("Esta no es la página para loguearse");
		}
	}	
}
