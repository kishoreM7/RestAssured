package dataProvider;

import org.testng.annotations.*;

import Pojo.PopjoToCreateObject;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProviderPractice {
	@Test(dataProvider = "getData")
	public void dataproviderTest(String createdBy, String projectName, String status, int teamSize) {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		PopjoToCreateObject pojoClassForCreatingProject = new PopjoToCreateObject(createdBy, projectName, status,
				teamSize);
		given().body(pojoClassForCreatingProject).contentType(ContentType.JSON).when().post("/addProject").then()
				.assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] a = new Object[2][4];
		a[0][0] = "Aswini jetti";
		a[0][1] = "hello world";
		a[0][2] = "On Going";
		a[0][3] = 1;
		a[1][0] = "Aswini kumar";
		a[1][1] = "Hello world 2";
		a[1][2] = "Completed";
		a[1][3] = 1;
		return a;
	}

}
