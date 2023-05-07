package endToEnd;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EndToEndScenarioTest {
	static Connection con = null;

	@Test
	public void EndToEndScenarioTest() {

		String p_id = "TY_PROJ_" + new Random().nextInt(100);
		String actprojectName = "Selenium12" + new Random().nextInt(100);
		Connection con = null;
		List<String> list = new ArrayList<String>();
		try {
			Driver dbDriver;
			dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);

			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement sta = con.createStatement();
			int res = sta.executeUpdate(
					"insert into project(project_id,created_by,created_on,project_name,status,team_size)values('" + p_id
							+ "','kishore','08/06/1994','" + actprojectName + "','craeted',3);");
			if (res == 1) {

				System.out.println("Data added sucessfully");

			}
			ResultSet res2 = sta.executeQuery("select * from project");
			int colCount = res2.getMetaData().getColumnCount();
			System.out.println(colCount);
			for (int i = 1; i <= colCount; i++) {
				String na = res2.getMetaData().getColumnName(i);
				System.out.println(na);
			}

			while (res2.next())

			{
				String n = res2.getString("project_id");
				list.add(n);

				System.out.println(n);
				String projectName = res2.getString("project_name");
				if (projectName.equals(actprojectName)) {
					System.out.println("data present in database-->  " + projectName);
					break;
				}
			}

		} catch (Exception e) {

		}

		finally

		{

			try {
				con.close();
				System.out.println("connection closed");

			} catch (SQLException e) {

			}

		}

		System.out.println(list);
		for (String string : list) {
			if (string.equals(p_id)) {
				System.out.println("project added susscessfully");
				break;

			}

		}
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given().pathParam("project", p_id).when().get("/projects/{project}").then().log().all();
	}

}
