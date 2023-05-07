package crudOperationsWithoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

//precondition
//action
//validation
/**
 * 
 * @author kishore mallarapu
 *
 */
public class AddProjectTest {

	@Test
	public void addProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "andrew tate");
		jObj.put("projectName", "avion insurance123456");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 7);
	

		RequestSpecification restAssure = RestAssured.given();
		restAssure.body(jObj);
		restAssure.contentType(ContentType.JSON);
		Response resp = restAssure.post("http://rmgtestingserver:8084/addProject");
		String contType = resp.getContentType();
		System.out.println(contType);
		ValidatableResponse vs = resp.then();
		System.out.println();
		;
		vs.assertThat().contentType(ContentType.JSON).and().statusCode(201).and().log().all();

	}

}
