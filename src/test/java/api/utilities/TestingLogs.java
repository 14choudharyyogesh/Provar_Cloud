package api.utilities;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import api.test.UsersTest;
import io.restassured.response.Response;

public class TestingLogs {
	

	private static Logger log = LogManager.getLogger(UsersTest.class.getName());
	
	public static void response_data(Response response)  {
		
		log.info("Response Header: - " + response.headers());
		log.info("Response body: - " + response.getBody().asString() );
		log.info("status code: - " + response.statusLine());
		log.info("Response time: - " + response.getTimeIn(TimeUnit.MILLISECONDS));
		log.info("Session id: - " + response.getSessionId());	

}
	}
