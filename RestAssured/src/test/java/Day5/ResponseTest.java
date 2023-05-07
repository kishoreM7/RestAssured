package Day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

public class ResponseTest {
	@Test
	public void responseTest() {
		String contentType = "application/json";
		String pragme = "no-cache";
		baseURI = "http://rmgtestingserver";
		port = 8084;
		Response resp = when().get("/projects");
		resp.prettyPeek();
		Assert.assertEquals(resp.getContentType(), contentType);
		Assert.assertEquals(resp.getHeader("pragma"), pragme);

	}

}
