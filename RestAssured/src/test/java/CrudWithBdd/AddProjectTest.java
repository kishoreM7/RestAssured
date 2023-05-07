package CrudWithBdd;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class AddProjectTest {
	@Test
	public void addProjectTest() {
		int ran = new Random().nextInt(100);
		System.out.println(ran);
		baseURI = "http://rmgtestingserver";
		port = 8084;

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "mark henry");
		jobj.put("projectName", "wrestleMania" + ran);
		jobj.put("status", "On Going");
		jobj.put("teamSize", 5);
		// pre condition
		given().body(jobj).contentType(ContentType.JSON)
				// action
				.when().post("/addProject")
				// validation
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();

	}

}
