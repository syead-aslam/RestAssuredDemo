package Demo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import File.ReusableMethods;

public class JiraApi {
	public static void main(String[] args) {
		RestAssured.baseURI="https://aslamdhanbad.atlassian.net";
		String response = given().header("Content-Type","application/json")
		.header("Authorization","Basic YXNsYW0uZGhhbmJhZEBnbWFpbC5jb206QVRBVFQzeEZmR0YwaElFOElJSE5XMENpMW1UU2RPbHpQNUc4c3REYXNhcEdxMGY3R1M5MUxLZXdSZ1luUzVsa2p1aWpHcFgxc0VmRGxBWFl6ejhCMWE2bDBRZUVsaVg4dk4zXzEtUkc2cXc1ci1OdnV0c1E4bW9QTzdXNXZxQ0c5cVlyWE1oR3pyNERPVWJ4TmZlRGtvbEZtSzhmYVpnSkRqdjh4TmNBV0tIN19UTmNRQWVlNkowPTc1MzcwOTYz")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Mobile App  is Not Working.\",\r\n"
				+ "       \"description\": \"Mobile App is not working while selecting\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}")
		.when().log().all().post("rest/api/2/issue")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = ReusableMethods.rawToJson(response);
		String Id = js.getString("id");
		System.out.println("Bug Id is: "+Id);
		
		given().header("X-Atlassian-Token","no-check")
		.header("Authorization","Basic YXNsYW0uZGhhbmJhZEBnbWFpbC5jb206QVRBVFQzeEZmR0YwaElFOElJSE5XMENpMW1UU2RPbHpQNUc4c3REYXNhcEdxMGY3R1M5MUxLZXdSZ1luUzVsa2p1aWpHcFgxc0VmRGxBWFl6ejhCMWE2bDBRZUVsaVg4dk4zXzEtUkc2cXc1ci1OdnV0c1E4bW9QTzdXNXZxQ0c5cVlyWE1oR3pyNERPVWJ4TmZlRGtvbEZtSzhmYVpnSkRqdjh4TmNBV0tIN19UTmNRQWVlNkowPTc1MzcwOTYz")
		.pathParam("key", Id)
		.multiPart("file",new File("C:\\Users\\Khushi\\Downloads\\Screenshot_20210720-121846_Edumall - Online learning for professionals.jpg")).log().all()
		.when().log().all().post("rest/api/3/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
	}
}