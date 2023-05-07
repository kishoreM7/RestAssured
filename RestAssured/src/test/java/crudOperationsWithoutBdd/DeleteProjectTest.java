package crudOperationsWithoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {

	@Test
	public void deleteProjectTest() {
		Response g = RestAssured.delete("http://rmgtestingserver:8084/projects/Ty_ROJ_-555156215");
		System.out.println(g.getStatusCode());

	}

}