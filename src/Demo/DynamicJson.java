package Demo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import File.ReusableMethods;
import File.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class DynamicJson {
	
	ArrayList<String> arrlist = new ArrayList<>();
			
	@Test(dataProvider="BookData")
	public void AddBook(String isbn,String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		String Response = given().header("Content-Type","text/plain").
		body(payload.addBook(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReusableMethods.rawToJson(Response);
		String Id = js.getString("ID");
		System.out.println(Id);
		arrlist.add(Id);
		
	}
	@Test
	public void DeleteBook()
	{
		if (!arrlist.isEmpty())
		{
			for (String id : arrlist)
			{
				RestAssured.baseURI = "http://216.10.245.166";
				String Response = given().header("Content-Type","text/plain").
				body("{\r\n"
						+ "  \"ID\": \""+id+"\"\r\n"
						+ "}")		
				.when().post("/Library/DeleteBook.php")
				.then().assertThat().statusCode(200).extract().response().asString();
				
				JsonPath js = ReusableMethods.rawToJson(Response);
				String msg = js.getString("msg");
				System.out.println(msg);
				Assert.assertEquals("book is successfully deleted", msg);
			}
		}
	}
	
	@DataProvider(name="BookData")
	public Object[][] getData()
	{
		return new Object[][] {{"rrdy","9832"},{"uuwdy","608"},{"yuyw","863"}};
	}

}
