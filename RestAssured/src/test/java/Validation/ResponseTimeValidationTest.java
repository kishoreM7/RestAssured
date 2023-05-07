package Validation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

public class ResponseTimeValidationTest {
	@Test
	public void responseTimeValidationTest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		when().get("/projects").then().assertThat().time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS);

	}

	
}
