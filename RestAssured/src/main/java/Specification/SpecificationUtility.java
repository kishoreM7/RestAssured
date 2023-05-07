package Specification;

import org.testng.annotations.BeforeSuite;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationUtility {
	public RequestSpecification rqspc;
	public ResponseSpecification respSpec;

	@BeforeSuite
	public void requestSpecification() {
		RequestSpecBuilder rs = new RequestSpecBuilder();
		rs.setBaseUri("http://localhost");
		rs.setPort(8084);
		rs.setContentType(ContentType.JSON);
		rqspc = rs.build();

	}

	@BeforeSuite
	public void setResponseSpec() {
		ResponseSpecBuilder resp = new ResponseSpecBuilder();
		respSpec = resp.expectStatusCode(201).expectContentType(ContentType.JSON).build();

	}

}
