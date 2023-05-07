package pet;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UploadImageTest {
	@Test
	public void upload() {

		baseURI = "https://petstore.swagger.io/v2";
		// pre condition
		given().multiPart("file", new File("./images/4436127.jpg"), "application/json")
				// action
				.when().post("/pet/10/uploadImage")
				// validationGB
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}

}
