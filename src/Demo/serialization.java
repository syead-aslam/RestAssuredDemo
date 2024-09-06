package Demo;
import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddPlace ap = new AddPlace();
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		ap.setAccuracy(50);
		ap.setAddress("29, side layout, cohen 09");
		ap.setLanguage("French-IN");
		ap.setName("Frontline house");
		ap.setWebsite("http://google.com");
		ap.setPhone_number("(+91) 983 893 3937");
		List<String> al = new ArrayList<>();
		al.add("shoe park");
		al.add("shop");
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Response response = given().queryParam("key", "qaclick123").body(ap).header("Content-Type","text/plain")
		.when().log().all().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		System.out.println(response.asString());
		
	}
}
