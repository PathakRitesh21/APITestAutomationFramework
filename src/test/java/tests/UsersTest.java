package tests;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.response.Response;
import utils.ExtentReportManager;


public class UsersTest extends BaseTest {
	
	@Test
	public void verifyGetUser() {
		ExtentTest test = ExtentReportManager.createTest("verifyGetUser");
		requestFactory.getAllUsers().then().log().all().statusCode(200);
		test.pass("Get All The Users");
	}
	
	@Test
	public void verifyAddUser() {
		ExtentTest test = ExtentReportManager.createTest("verifyAddUser");
		String requestPayLoad = "{\r\n"
				+ "    \"name\": \"johnwick\",\r\n"
				+ "    \"job\": \"boss\"\r\n"
				+ "}";
		requestFactory.addUsers(requestPayLoad).then().log().all().statusCode(201);
		test.pass("User created");
	}
	
	@Test
	public void verifyAddUserUsingMap() {
		ExtentTest test = ExtentReportManager.createTest("verifyAddUserUsingMap");
		Map<String , Object> requestPayLoad =new HashMap<>();
		requestPayLoad .put("name", "babayaga");
		requestPayLoad .put("job", "leader");
		requestFactory.addUsers(requestPayLoad).then().log().all().statusCode(201);
		test.pass("User created using Map");
	}
	
	@Test
	public void verifyEndToEndFlow() {
	    ExtentTest test = ExtentReportManager.createTest("End-to-End User CRUD Flow");

	    try {
	        // Create User
	        Map<String, Object> requestPayLoad = new HashMap<>();
	        requestPayLoad.put("name", "boogeyman");
	        requestPayLoad.put("job", "leader");

	        Response response = requestFactory.addUsers(requestPayLoad);
	        test.info("Create User Response: " + response.getBody().asString());
	        response.then().log().all().statusCode(201);

	        String userId = response.jsonPath().getString("id");
	        Assert.assertNotNull(userId, "User ID should not be null");
	        test.pass("User created with ID: " + userId);

	        // Get User After Create — should return 404 (mock)
	        Response responseGet = requestFactory.getUserById(userId);
	        test.info("GET After Create Response Code: " + responseGet.statusCode());
	        Assert.assertEquals(responseGet.statusCode(), 404);
	        test.pass("Verified user not found after creation, as expected (mock API)");

	        // Update User
	        Map<String, Object> updatePayLoad = new HashMap<>();
	        updatePayLoad.put("name", "john");
	        updatePayLoad.put("job", "leader");

	        Response responsePut = requestFactory.updateUsers(userId, updatePayLoad);
	        test.info("Update User Response: " + responsePut.getBody().asString());
	        responsePut.then().log().all().statusCode(200);
	        Assert.assertEquals(responsePut.jsonPath().getString("name"), "john");
	        test.pass("User updated successfully");

	        // Get User After Update — still 404 due to mock nature
	        Response responseUpdate = requestFactory.getUserById(userId);
	        test.info("GET After Update Response Code: " + responseUpdate.statusCode());
	        Assert.assertEquals(responseUpdate.statusCode(), 404);
	        test.pass("Verified user not found after update, as expected (mock API)");

	        // Delete User
	        Response responseDel = requestFactory.deleteUser(userId);
	        test.info("Delete User Response Code: " + responseDel.statusCode());
	        Assert.assertEquals(responseDel.statusCode(), 204);
	        test.pass("User deleted successfully");

	        // Get User After Delete — 404 again
	        Response responseFin = requestFactory.getUserById(userId);
	        test.info("GET After Delete Response Code: " + responseFin.statusCode());
	        Assert.assertEquals(responseFin.statusCode(), 404);
	        test.pass("Verified user not found after deletion, as expected");

	    } catch (AssertionError | Exception e) {
	        test.fail("Test failed: " + e.getMessage());
	        test.fail(e);
	        throw e; // Rethrow to let TestNG mark it as failed
	    }
	}

}
