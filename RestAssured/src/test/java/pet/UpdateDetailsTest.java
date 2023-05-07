package pet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UpdateDetailsTest {
	@Test
	public void update() {
		baseURI = "https://petstore.swagger.io/v2";

		JSONObject categoryObj = new JSONObject();
		categoryObj.put("id", 100);
		categoryObj.put("name", "pet1bh");

		JSONArray photoUrlsArray = new JSONArray();
		photoUrlsArray.add("url1");
		photoUrlsArray.add("url2");

		JSONArray tagsObjectArray = new JSONArray();
		tagsObjectArray.add(categoryObj);

		JSONObject jobj = new JSONObject();
		jobj.put("id", 100);
		jobj.put("category", categoryObj);
		jobj.put("name", "pet1");
		jobj.put("photoUrls", photoUrlsArray);
		jobj.put("tags", tagsObjectArray);
		jobj.put("status", "available");

		// pre condition
		given().body(jobj).contentType(ContentType.JSON)
				// action
				.when().put("/pet")
				// validation
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}

}
