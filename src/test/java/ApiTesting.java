import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTesting {

	@Test
	public void testUser() {
		 RestAssured.baseURI = "https://fake-json-api.mock.beeceptor.com";
		 
		 Response response = RestAssured.given()
		            .when().get("/users")
		            .then()
		            .statusCode(200)
		            .extract()
		            .response();
		 System.out.println(response.asString());
		 
		 int length = response.jsonPath().getList("").size();
		 
		 Assert.assertEquals(length, 10);
    }
}
