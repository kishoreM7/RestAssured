package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
	@Test
	public void pathParameterTest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given().pathParam("pid", "TY_PROJ_2947").when().get("/projects/{pid}").then().assertThat().statusCode(200).log()
				.all();

	}

}