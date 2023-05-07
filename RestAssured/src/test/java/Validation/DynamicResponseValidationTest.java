package Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest {
	@Test
	public void dynamicResponseValidationTest() {
		String expData = "06/01/2023";
		baseURI = "http://rmgtestingserver";
		port = 8084;
		boolean flag  = false;
		
		Response resp = when().get("/projects");
		List<String> pid = resp.jsonPath().get("projectId");

		for (String projectId : pid) {
			if(projectId.equalsIgnoreCase(expData)) {
				flag = true;
				
			}
			
		}
		Assert.assertTrue(flag);
		System.out.println("data verified");
		resp.then().log().all();
	}

}
