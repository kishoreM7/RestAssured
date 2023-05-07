package CrudWithBddDifferantWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.testng.annotations.Test;

import Pojo.PopjoToCreateObject;
import io.restassured.http.ContentType;

public class UsingPojooTest {
	@Test
	public void usingPojooTest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		PopjoToCreateObject obj = new PopjoToCreateObject("kane", "Royal rumble 2" + new Random().nextInt(), "On Going",
				5);
		given().body(obj).contentType(ContentType.JSON).when().post("/addProject")
				// validation
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();

	}

}
