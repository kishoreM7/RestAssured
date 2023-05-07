package CrudWithBddDifferantWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UsingJsonObject {
	public void usingJsonObject() {
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
