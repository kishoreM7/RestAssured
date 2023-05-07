package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddAndUpdateTest {
	public void addAndUpdateTest() {
		int ran = new Random().nextInt(100);
		System.out.println(ran);
		baseURI = "http://rmgtestingserver";
		port = 8084;

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "mark henry");
		jobj.put("projectName", "wrestleMania" + ran);
		jobj.put("status", "On Going");
		jobj.put("teamSize", 5);
		JSONObject jobj2 = new JSONObject();
		jobj.put("createdBy", "mark ");
		jobj.put("projectName", "wrestleMania" + ran);
		jobj.put("status", "On Going");
		jobj.put("teamSize", 5);
		// pre condition
		Response resp = given().body(jobj).contentType(ContentType.JSON)
				// action
				.when().post("/addProject");
		String pid = resp.jsonPath().get("projectId");
		System.out.println(pid);

		given().body(jobj2).contentType(ContentType.JSON).when().put("/projects/{projectid}").then().statusCode(200);

	}

}
