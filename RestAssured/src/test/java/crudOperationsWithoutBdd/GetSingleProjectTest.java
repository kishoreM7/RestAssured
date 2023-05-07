package crudOperationsWithoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetSingleProjectTest {
	@Test
	public void getSingleProjectTest() {
		Response g = RestAssured.get("http://rmgtestingserver:8084/projects/Ty_ROJ_-555156215");
		ResponseBody str = g.getBody().prettyPeek();
		System.out.println(str);

	}

}
