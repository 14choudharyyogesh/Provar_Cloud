package practice;

import static io.restassured.RestAssured.*;
import java.io.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class RestnOauth  {

	public static String methodname;

	String uri = "https://jsonplaceholder.typicode.com";

	@Test
	public void test_get_noauth() throws IOException {

		// fetching executive method name
		String methodname = new Object() {
		}.getClass().getEnclosingMethod().getName();
		RestnOauth.methodname = methodname;

		// Sending Request and Fetching Response
		Response response = given().when().get(uri + "/posts/1");

		

		// Validating response
		response.then().assertThat().statusCode(201);

	}
}

