package specification;

import org.testng.annotations.Test;

import AutoConstants.EndPoints;
import AutoConstants.Iconstants;
import Pojo.PopjoToCreateObject;
import Specification.SpecificationUtility;
import static io.restassured.RestAssured.*;

public class SpecificationPractice extends SpecificationUtility {
	@Test
	public void SpecificationPractice() {
		PopjoToCreateObject p = new PopjoToCreateObject("kishore", "royalRumble900", "On going", 5);
		given().spec(rqspc).body(p)
		.when().post(EndPoints.project_addProject).then().spec(respSpec).and().and().log().all();
	}

}
