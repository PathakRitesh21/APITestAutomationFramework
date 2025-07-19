package client;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
public class RestClient {
	String apiKey = "reqres-free-v1";
	
	public Response SendGetRequest(String uri) {
		return given().header("x-api-key", apiKey).when().get(uri);
	}
	
	public Response SendPostRequest(String uri,Object requestPayLoad) {
		return given().header("x-api-key", apiKey).contentType(ContentType.JSON).when().body(requestPayLoad).post(uri);
	}
	
	public Response SendPatchRequest(String uri,Object requestPayLoad) {
		return given().header("x-api-key", apiKey).contentType(ContentType.JSON).when().body(requestPayLoad).patch(uri);
	}
	
	public Response SendPutRequest(String uri,Object requestPayLoad) {
		return given().header("x-api-key", apiKey).contentType(ContentType.JSON).when().body(requestPayLoad).put(uri);
	}
	
	public Response SendDeleteRequest(String uri) {
		return given().header("x-api-key", apiKey).when().delete(uri);
	}

}
