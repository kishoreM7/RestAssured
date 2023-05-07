package restAssured;

import io.restassured.response.Response;

public class RestAssuredUtility {
	public String getJsonData(Response response, String path) {
		return response.jsonPath().get(path);
	}
}