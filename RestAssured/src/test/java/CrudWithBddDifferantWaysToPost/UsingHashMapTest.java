package CrudWithBddDifferantWaysToPost;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingHashMapTest {
	@Test
	public void UsingHashMapTest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		HashMap map = new HashMap<>();
		map.put("createdBy", "john cena");
		map.put("projectName", "ipl" + new Random().nextInt());
		map.put("status", "On Going");
		map.put("teamSize", 4);
		// pre condition
		given().body(map).contentType(ContentType.JSON).when().post("/addProject")
				// validation
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();

	}

}
