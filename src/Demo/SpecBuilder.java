package Demo;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class SpecBuilder {

	public static void main(String[] args) {
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
		
		RequestSpecification Req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Content-Type","application/json")
				.addQueryParam("key", "qaclick123").build();
		
		RequestSpecification res = given().spec(Req).body(ap);
		ResponseSpecification ResSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();
		Response response = res.when().log().all().post("/maps/api/place/add/json")
		.then().spec(ResSpec).extract().response();
		
		
		System.out.println(response.asString());

	}

}
