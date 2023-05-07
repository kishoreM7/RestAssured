package CrudWithBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
	@Test
	public void updateProjectTest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "mark henry");
		jobj.put("projectName", "wrestleMania");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 6);
		given().body(jobj).contentType(ContentType.JSON).when().put("/projects/TY_PROJ_999").then().assertThat()
				.statusCode(200).log().all();

	}

}
