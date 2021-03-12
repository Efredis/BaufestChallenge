package Test_Suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;

import com.baufest.challenge.DemoBlazeTests;
import com.baufest.challenge.BlazeAddCart;
import com.baufest.challenge.BlazeLoginOut;


@RunWith(Suite.class)
@SuiteClasses({ DemoBlazeTests.class, BlazeLoginOut.class, BlazeAddCart.class })

public class suiteSignupLoginOut {
	public static WebDriver driver;
	public static String user = "";
	public static String pass = "";	
}
