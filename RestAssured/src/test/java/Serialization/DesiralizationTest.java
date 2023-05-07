package Serialization;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import Pojo.EmpDetails;

public class DesiralizationTest {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		EmpDetails emp = obj.readValue(new File("./kishore123.json"), EmpDetails.class);
		System.out.println(emp.geteName());
	}

}
