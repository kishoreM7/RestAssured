package CrudWithBddDifferantWaysToPost;

import static io.restassured.RestAssured.given;

import java.io.File;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PostWithJsonFile {
	@Test
	public void postWithJsonFile() {

		baseURI = "http://rmgtestingserver";
		port = 8084;
		File obj = new File("./src/test/resources/data.json");
		given().body(obj).contentType(ContentType.JSON)
				// action
				.when().post("/addProject")
				// validation
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

}
