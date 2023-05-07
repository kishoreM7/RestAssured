package Day5;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pojo.PopjoToCreateObject;
import genericUtility.ExcelUtility;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Abc {
	
	@Test(dataProvider = "getData1")
	public void dataproviderTest(String createdBy, String projectName, String status, String teamSize) {
		baseURI = "http://rmgtestingserver";
		System.out.println(createdBy);
		port = 8084;
		int size = Integer.parseInt(teamSize);

		PopjoToCreateObject pojoClassForCreatingProject = new PopjoToCreateObject(createdBy, projectName, status, size);
		given().body(pojoClassForCreatingProject).contentType(ContentType.JSON).when().post("/addProject").then()
				.assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

	@DataProvider
	public Object[][] getData1() throws EncryptedDocumentException, IOException  {
		ExcelUtility e = new ExcelUtility(DEFAULT_BODY_ROOT_PATH);
		return e.getData("Sheet3");
		

	}
}
