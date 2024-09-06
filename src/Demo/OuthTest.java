package Demo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.GetCourses;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import File.ReusableMethods;

public class OuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] as = {"Selenium Webdriver Java","Cypress","Protractor"};
		
		String Response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		JsonPath js = ReusableMethods.rawToJson(Response);
		String token = js.getString("access_token");
		
		GetCourses gc= given().queryParam("access_token", token)
		.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourses.class);
		System.out.println(gc.getLinkedIn());
		System.out.print(gc.getExpertise());
		System.out.print(gc.getCourses().getWebAutomation().get(0).getCourseTitle());
		
		List<pojo.WebAutomation> wb = gc.getCourses().getWebAutomation();
		ArrayList<String> ArrList = new ArrayList<>();
		for(int i = 0; i<wb.size(); i++)
		{
			ArrList.add(gc.getCourses().getWebAutomation().get(i).getCourseTitle());
		}
		
		List<String> Expected = (Arrays.asList(as));
		Assert.assertTrue(ArrList.equals(Expected));
		Assert.assertEquals(ArrList, Expected);
		

	}

}
