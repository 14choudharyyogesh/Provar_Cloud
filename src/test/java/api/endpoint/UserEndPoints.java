package api.endpoint;

import static io.restassured.RestAssured.*;
import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created for performing CRUD(Create read update delete) request

public class UserEndPoints {

	// Creating the user
	public static Response createUser(UserPayload payload) {
		Response reponse = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);
		return reponse;
	}

	// Reading the user info
	public static Response readuser(String username) {

		Response reponse = given().pathParam("username", username).when().get(Routes.get_url);
		return reponse;

	}
	
	// Updating the user
		public static Response updateUser(String userName ,UserPayload payload) {
			Response reponse = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", userName).body(payload).when()
					.put(Routes.update_url);
			return reponse;
		}
	
		// Deleting the user
				public static Response deleteUser(String userName) {
					Response reponse = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", userName).when()
							.delete(Routes.update_url);
					return reponse;
				}
	

}
