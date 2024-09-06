package Demo;
import org.testng.Assert;
import org.testng.annotations.Test;

import File.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	@Test
	public void sumOfCourses()
	{
		JsonPath js = new JsonPath(payload.CoursePrice());
		int CourseCount = js.getInt("courses.size()");
		System.out.println("Total Course count is: "+CourseCount);
		int PurchasedAmount=js.getInt("dashboard.purchaseAmount");
		int sum = 0;
		for (int i=0; i < CourseCount;i++)
		{
			sum+=(js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies"));
		}
		System.out.println("Sum of total Courses Price: "+sum);
		Assert.assertEquals(sum, PurchasedAmount);
	}

}
