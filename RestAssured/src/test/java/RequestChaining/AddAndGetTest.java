package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddAndGetTest {
	@Test
	public void addAndGetTest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "mark henry");
		jobj.put("projectName", "wrestleMania");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 6);

		Response resp = given().body(jobj).contentType(ContentType.JSON).post("/addProject");
		String pid = resp.jsonPath().get("projectId");
		System.out.println(pid);

		given().pathParam("project", pid).when().get("projects/{project}").then().contentType(ContentType.JSON).log()
				.all();

	}

}
