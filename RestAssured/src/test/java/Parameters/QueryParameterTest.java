package Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class QueryParameterTest {
	@Test
	public void queryParameterTest() {
		baseURI = "https://reqres.in/";
		given().queryParam("page", 2).when().get("/api/users").then().assertThat().log().all()
				.contentType(ContentType.JSON).statusCode(200);

	}

}
