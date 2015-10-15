package myTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;


public class identifyOpenLayersTest_02 {

	private static WebDriver driver = null;

    public static void main(String[] args)  throws InterruptedException {
    	
    	//Create a new profile and load my Firefox default profile 
    	System.out.println("Creo un nuovo profilo e vi carico il profilo Firefox di default ...");
    	Thread.sleep(3000L);
    	ProfilesIni profile = new ProfilesIni();    	
    	FirefoxProfile ffProfile = profile.getProfile("default");
    	    	
    	// Create a new instance of the Firefox driver using my new Firefox profile  
    	System.out.println("Creo una nuova sessione del browser Firefox ...");
    	Thread.sleep(3000L);
    	driver = new FirefoxDriver(ffProfile);

        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // It is always advisable to Maximize the window before performing DragNDrop action
     	System.out.println("Maximize the window ...");
     	driver.manage().window().maximize();
     	Thread.sleep(3000L);    	
     	
        // Launch the OpenLayers 2.x marker sample 
        System.out.println("Launch the OpenLayers 2.x marker sample  ...");
        Thread.sleep(3000L); 
        driver.get("http://dev.openlayers.org/releases/OpenLayers-2.13.1/examples/markers.html");
        
        // Create a new Action instance 
        System.out.println("Create a new Action instance ...");
        Actions act = new Actions(driver);
        
        // Find the viewport inside in witch there is the map   
        System.out.println("Find the viewport inside in witch there is the map ...");
        Thread.sleep(3000L);
        //WebElement el = driver.findElement(By.id("OpenLayers_Map_2_OpenLayers_ViewPort"));
        WebElement el = driver.findElement(By.className("olAlphaImg"));
        
        // Start the action sequence 
        System.out.println("Start the action sequence  ...");
        Thread.sleep(3000L);
        act.click().perform();        
              
        // Perform the click operation that opens new window
        // Identify marker
        System.out.println("Identify marker at 285, 111 ...");
        Thread.sleep(3000L);
        act.moveToElement(el, 285, 111).click().build().perform();  
        
        // Print TEST = OK!!
        System.out.println("TEST = OK !!");
        //driver.quit();
        
            }
}

