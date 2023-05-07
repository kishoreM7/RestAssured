package crudOperationsWithoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllProjectsTest {
	@Test
	public void getAllProjects() {
		Response g = RestAssured.get("http://rmgtestingserver:8084/projects");

		String str = g.getBody().prettyPrint();
		System.out.println(str);
	}
}
