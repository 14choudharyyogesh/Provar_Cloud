package practice;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import api.resource.testdata;

public class BasicAuth {

	testdata data = new testdata();

	@Test
	public void basic_auth() {

		ValidatableResponse res=given().auth().basic(data.baseauth_username, data.baseauth_username).when().contentType(ContentType.JSON)
				.get(data.baseauth_uri).then().assertThat().statusCode(290);
		
		System.out.println(res);
		
		

	}

}