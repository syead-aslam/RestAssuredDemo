package Demo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import File.ReusableMethods;
import File.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","text/plain")
		.body(payload.addplace()).when().log().all().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		JsonPath js = new JsonPath(Response);
		String PlaceId = js.get("place_id");
		System.out.print(PlaceId);
		
		//Update Check
		String ActAddress = "70 winter walk, USA";
		 given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		 .body("{\r\n"
		 		+ "\"place_id\":\""+ PlaceId +"\",\r\n"
		 		+ "\"address\":\""+ ActAddress  +"\",\r\n"
		 		+ "\"key\":\"qaclick123\"\r\n"
		 		+ "}").
		 when().log().all().put("maps/api/place/update/json")
		 .then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		 
		 System.out.print("put verified");
		 //Get Check
		 System.out.print("Get verification started");
		String GetPlace= given().log().all().queryParam("place_id", PlaceId).queryParam("key", "qaclick123")
		 .when().log().all().get("maps/api/place/get/json")
		 .then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		//JsonPath js1 = new JsonPath(GetPlace);
		JsonPath js1 = ReusableMethods.rawToJson(GetPlace);
		String address= js1.get("address");
		System.out.print(address);
		Assert.assertEquals(ActAddress, address);
		
		//Delete Check
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+ PlaceId +"\"\r\n"
				+ "}")
		.when().log().all().delete("maps/api/place/delete/json")
		.then().log().all().assertThat().statusCode(200);

	}

}
