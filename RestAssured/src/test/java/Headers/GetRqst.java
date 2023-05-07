package Headers;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetRqst {
	@Test
	public void getRequest() {

	Response r = when().get("https://reqres.in/api/users/?page=2");
	int v =r.body().jsonPath().get("page");
	System.out.println(v);
	
		//.then().assertThat().log().all().contentType(ContentType.JSON)
//				.statusLine("HTTP/1.1 200 OK").time(Matchers.lessThan(200000L), TimeUnit.MILLISECONDS)
//				.header("Connection", "keep-alive").statusCode(200);

	}

}
