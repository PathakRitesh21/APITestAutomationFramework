package request;

import client.RestClient;
import io.restassured.response.Response;

public class RequestFactory {

    private RestClient restClient;

    // ✅ Constructor to initialize restClient
    public RequestFactory() {
        this.restClient = new RestClient();
    }

    public Response getAllUsers() {
        return restClient.SendGetRequest("/users");
    }

    public Response addUsers(Object requestPayLoad) {
        return restClient.SendPostRequest("/users", requestPayLoad);
    }

    public Response updateUsers(Object requestPayLoad) {
        return restClient.SendPutRequest("/users", requestPayLoad); 
    }

    public Response deleteUser() {
        return restClient.SendDeleteRequest("users"); 
    }

    public Response patchUser(Object requestPayLoad) {
        return restClient.SendPatchRequest("/users", requestPayLoad);
    }
    
    public Response getUserById(String userId) {
        return restClient.SendGetRequest("/users" + userId);
    }

    public Response updateUsers(String userId, Object requestPayload) {
        return restClient.SendPutRequest("/users" + userId, requestPayload);
    }

    public Response deleteUser(String userId) {
        return restClient.SendDeleteRequest("/users" + userId);
    }

}
