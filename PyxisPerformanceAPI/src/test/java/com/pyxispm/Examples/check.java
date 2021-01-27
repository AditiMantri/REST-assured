package com.pyxispm.Examples;
import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class check {
	
	@Test
	public void getWeatherDetails() {
		// Specify the base URL to the RESTful web service
		 RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
		 
		 // Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 // Make a request to the server by specifying the method Type and the method URL.
		 // This will return the Response from the server. Store the response in a variable.
		 Response response = httpRequest.request(Method.GET, "/Hyderabad");
		 
		 // Now let us print the body of the message to see what response
		 // we have received from the server
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		 
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, 200, "Correct status code returned");
		 
	}
	

	
	@Test
	public void GetWeatherDetailsInvalidCity()
	{
	 RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/78789798798");
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode /*actual value*/, 400 /*expected value*/, "Correct status code returned");
	}
	
	
	@Test
	public void GetWeatherStatusLine()
	{
	 RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Hyderabad");
	 
	 // Get the status line from the Response and store it in a variable called statusLine
	 String statusLine = response.getStatusLine();
	 Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
	}
}
