package Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticValidationTest {
	@Test
	public void staticValidationTest() {
		String expData = "06/01/2023";
		baseURI = "http://rmgtestingserver";
		port = 8084;

		Response resp = when().get("/projects");
		String ActData = resp.jsonPath().get("[0].projectId");
		Assert.assertEquals(ActData, expData);

		System.out.println("data verified");
		resp.then().log().all();
	}

}
