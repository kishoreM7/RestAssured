import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ToCharaArray {
	@Test
	public void toCharArrayTest() throws IOException {
		baseURI = "https://www.shoppersstack.com/shopping";
//		HashMap map = new HashMap<>();
//		map.put("email", "harshithahrngowda@gmail.com");
//		map.put("password", "Harshitha@12");
//		map.put("role", "MERCHANT");

		Response response = given().auth().oauth2(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJzaGl0aGFocm5nb3dkYUBnbWFpbC5jb20gTUVSQ0hBTlQiLCJleHAiOjE2ODE5MjY2NTUsImlhdCI6MTY4MTg5MDY1NX0.pQoUWXmTNVuyCgH43MgzX6GIwxhd65C8py3Qi1PWcUA")
				.queryParam("zoneId", "MYSURU20282").when().get("/products");

		byte[] responseAsByteArray = response.asByteArray();
		response.then().log().all();
		// Creating a target file
		File targetFileForByteArray = new File("src/main/resources/targetFileForByteArray.json");
		// Writing into files
		Files.write(responseAsByteArray, targetFileForByteArray);

	}

}
