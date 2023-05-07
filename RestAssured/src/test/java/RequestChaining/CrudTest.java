package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CrudTest {
	@Test
	public void crudTest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "mark henry");
		jobj.put("projectName", "wrestleMania");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 6);
		JSONObject jobj2 = new JSONObject();
		jobj.put("createdBy", "mark wood");
		jobj.put("projectName", "wrestleMania");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 6);
		Response resp1 = given().body(jobj).contentType(ContentType.JSON).when().post("/addProject");
		String s = resp1.jsonPath().get("projectId");
		given().body(jobj2).contentType(ContentType.JSON).pathParam("project", s).when().put("/projects/{project}")
				.then().log().all();
		given().pathParam("project", s).when().get("/projects/{project}");
		given().pathParam("project", s).when().delete("/projects/{project}").then().assertThat().statusCode(204).log()
				.all();

	}

}
