package Serialization;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import Pojo.EmployeePojo;
import Pojo.SpouseDetails;

public class EmpSerializationTest {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		int[] spPhn = { 1542, 4555 };
		String[] spmail = { "hgxhaCHA", "Akhgchashs" };

		SpouseDetails sd = new SpouseDetails("spouse", spmail, spPhn);

		String[] empMail = { "hkdhus", "jachisgs" };
		int[] empPhnNum = { 4545455, 445545 };

		EmployeePojo emp = new EmployeePojo("kishore", empMail, empPhnNum, 2, sd);

		ObjectMapper objMapper = new ObjectMapper();
		objMapper.writeValue(new File("./emp.json"), emp);
		

	}

}
