package api.test;

import java.io.IOException;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoint.UserEndPoints;
import api.payload.UserPayload;
import api.utilities.TestingLogs;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class UsersTest {

	Faker faker;
	UserPayload payload = new UserPayload();
	static Logger log = LogManager.getLogger(UsersTest.class.getName());

	@BeforeClass
	public void datasetup() {

		faker = new Faker();
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(2, 10));
		payload.setPhone(faker.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void testPostUser() throws IOException {

		log.info("********** Creating User ***********");

		Response response = UserEndPoints.createUser(payload);

		// fetching the logs into log file
		TestingLogs.response_data(response);

		// Validating the Status code
		response.then().statusCode(200);

	}

	@Test(priority = 2)
	public void testReadUserData() throws IOException {

		log.info("********** Reading User info ***********");

		Response response = UserEndPoints.readuser(this.payload.getUsername());

		// fetching the logs into log file
		TestingLogs.response_data(response);

		// Validating the Status code
		response.then().statusCode(200);

	}

	@Test(priority = 3)
	public void testUpdateUserData() throws IOException {

		log.info("********** Updating User info ***********");

		// Updating FirstName,LastName,Email address
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());

		// Updating the response with the help of UserName(UserName is constant refer to
		// current UserName)
		Response response = UserEndPoints.updateUser(this.payload.getUsername(), payload);

		// Fetching the logs into log file
		TestingLogs.response_data(response);

		// Validating the Status code
		response.then().statusCode(200);

		log.info("********** Reading the Updated User info ***********");

		// Reading the Updating User info
		Response responseAfterUpdate = UserEndPoints.readuser(this.payload.getUsername());

		// fetching the logs into log file
		TestingLogs.response_data(responseAfterUpdate);

		// Validating the Status code
		response.then().statusCode(200);

	}

	@Test(priority = 4)
	public void testDeletionUserData() throws IOException {

		log.info("********** Deleting the User ***********");

		Response response = UserEndPoints.deleteUser(this.payload.getUsername());

		// fetching the logs into log file
		TestingLogs.response_data(response);

		Assert.assertEquals(response.statusCode(), 200);

		log.info("********** Reading the deleting User info ***********");

		// Reading the deleting User info
		Response responseAfterDeletion = UserEndPoints.readuser(this.payload.getUsername());

		// fetching the logs into log file
		TestingLogs.response_data(responseAfterDeletion);

		// Validating the Response after deletion
		responseAfterDeletion.then().body("message", equalTo("User not found"));
		responseAfterDeletion.then().statusCode(404);

	}
}
