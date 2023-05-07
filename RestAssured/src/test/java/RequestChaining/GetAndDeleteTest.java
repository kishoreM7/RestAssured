package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import javax.annotation.meta.When;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAndDeleteTest {
	@Test
	public void GetAndDeleteTest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "mark henry");
		jobj.put("projectName", "wrestleMania");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 6);

		Response resp = given().pathParam("id", "TY_PROJ_3338").when().get("/projects/{id}");
		String pid = resp.jsonPath().get("projectId");
		System.out.println(pid);

	}

}
