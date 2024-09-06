package Demo;
import org.testng.Assert;

import File.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	public static void main(String[] args) {
		JsonPath js = new JsonPath(payload.CoursePrice());
		int CourseCount = js.getInt("courses.size()");
		System.out.println("Total Course count is: "+CourseCount);
		int PurchasedAmount=js.getInt("dashboard.purchaseAmount");
		
		System.out.println("Purchase Amout is: "+ js.getInt("dashboard.purchaseAmount"));
		System.out.println("Title of first Course: "+js.getString("courses[0].title"));
		
		for (int i=0; i < CourseCount;i++)
		{
			System.out.println("Course Title: "+js.getString("courses["+i+"].title"));
			System.out.println("Course Price: "+js.getInt("courses["+i+"].price"));
		}
		for (int i=0; i < CourseCount;i++)
		{
			if (js.getString("courses["+i+"].title").equals("RPA"))
			{
				System.out.println("Sold RPA Copies: "+js.getInt("courses["+i+"].copies"));
				break;
			}		
		}
		int sum = 0;
		for (int i=0; i < CourseCount;i++)
		{
			sum+=(js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies"));
		}
		System.out.println("Sum of total Courses Price: "+sum);
		Assert.assertEquals(sum, PurchasedAmount);

	}

}
