package CrudWithBdd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetSingleProjectTest {
	@Test
	public void getSingleProjectTest() {

		baseURI = "http://rmgtestingserver";
		port = 8084;
		when().get("/projects/TY_PROJ_999").then().assertThat().contentType(ContentType.JSON).log().all();

	}
}