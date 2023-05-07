package Validation;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

public class Hello {
	public static void main(String[] args) {
		Response r = when().get("https://reqres.in/api/users?page=2");
	List<String> b = r.jsonPath().get("data.email");
		r.then().log().all();	
		System.out.println(b);

	}

}
