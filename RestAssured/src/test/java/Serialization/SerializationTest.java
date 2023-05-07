package Serialization;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import Pojo.EmpDetails;

public class SerializationTest {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		EmpDetails emp = new EmpDetails("kishore", 1, 80089145, "kishore.@gmail.com", "hyderabad");
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("./kishore123.json"), emp);

	}

}
