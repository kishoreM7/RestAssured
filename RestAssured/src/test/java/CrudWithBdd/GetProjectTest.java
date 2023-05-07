package CrudWithBdd;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProjectTest {
	@Test
	public void getProjectTest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		when().get("/projects").then().assertThat().contentType(ContentType.JSON).log().all();
	}

}
