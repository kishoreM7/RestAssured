package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddAndDeleteTest {
	@Test
	public void addAndDeleteTest() {
		int ran = new Random().nextInt(1000);

		baseURI = "http://rmgtestingserver";
		port = 8084;

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "mark henry");
		jobj.put("projectName", "wrestleMania" + ran);
		jobj.put("status", "On Going");
		jobj.put("teamSize", 5);

		// pre condition
		Response response = given().body(jobj).contentType(ContentType.JSON)
				// action
				.when().post("/addProject");
		// validation
		String pid = response.jsonPath().get("projectId");
		System.out.println(pid);
		given().pathParam("project", pid).when().delete("/projects/{project}").then().assertThat().statusCode(200).log()
				.all();

	}

}
