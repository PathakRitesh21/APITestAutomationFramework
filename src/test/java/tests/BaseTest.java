package tests;

import java.util.Properties;

import org.testng.annotations.*;

import io.restassured.RestAssured;
import request.RequestFactory;
import utils.ConfigRead;
import utils.ExtentReportManager;

public class BaseTest {
	
	RequestFactory requestFactory;
	
	String configFilename;
	
	Properties configProperties;
	
	String currentWorkingDir;
	
	@BeforeSuite
	public void preSetup() throws Exception {
		currentWorkingDir = System.getProperty("user.dir");
		
		configFilename = currentWorkingDir + "/resources/config/config.properties";
		
		configProperties = ConfigRead.readConfigProperties(configFilename);
		
	}
	
	
	@BeforeClass
	public void setUp() {
		
		ExtentReportManager.initReport();
		RestAssured.baseURI = configProperties.getProperty("baseURI");
		
		requestFactory = new RequestFactory();
		
	}
	
	@AfterClass
	public void cleanUp() {
		ExtentReportManager.flushReport();
		RestAssured.reset();
	}
	
}
