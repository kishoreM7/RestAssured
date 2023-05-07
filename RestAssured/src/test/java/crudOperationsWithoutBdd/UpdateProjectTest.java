package crudOperationsWithoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test
	public void updateProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "tate");
		jObj.put("projectName", "avion insurance123");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 7);

		RequestSpecification restAssure = RestAssured.given();
		restAssure.body(jObj);
		restAssure.contentType(ContentType.JSON);
		Response resp = restAssure.put("http://rmgtestingserver:8084/projects/Ty_ROJ_-555156215");
		String contType = resp.getContentType();
		System.out.println(contType);
		System.out.println(resp.getBody().prettyPrint());
		System.out.println(resp.getBody().jsonPath().getString("status"));
		ValidatableResponse vs = resp.then();
		vs.assertThat().contentType(ContentType.JSON).and().statusCode(201).and().log().all();

	}

}
