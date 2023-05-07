package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import Pojo.EmployeePojo;

public class EmpDeserializxationTest {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		EmployeePojo sp = obj.readValue(new File("./emp.json"), EmployeePojo.class);
		System.out.println(sp.getEmpId());
		System.out.println(sp.getSd().getSpouseName());
		System.out.println(sp.getSd().getPhnNum()[1]);

	}
}
