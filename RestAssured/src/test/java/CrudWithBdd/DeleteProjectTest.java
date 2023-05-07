package CrudWithBdd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
	@Test
	public void deleteProjectTest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		// action
		when().delete("/projects/101").
		// validation
				then().assertThat().statusCode(204).log().all();

	}
}
