package com.pyxispm.Examples;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.mongodb.util.JSON;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import io.restassured.matcher.RestAssuredMatchers;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class TestExamples {
	
	//@Test
	public void test1() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	//@Test   
	public void test2() {
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id",Matchers.equalTo(8))
			.log().all();
		
	}
	
	//@Test
	public void testGet() {
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name",Matchers.equalTo("George")).
			body("data.first_name",Matchers.hasItems("George","Rachael"))
			.log().all();
		
	}
	
	//@Test
	public void testPost() {
		Map<String , Object > map = new HashMap<String, Object>() ; 
		/*
		 * map.put("name",
		 * "Aditi"); map.put("job","Teacher");
		 */
		
		//System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("name","Aditi");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		RestAssured.given().
			header("Content-Type","applcation/json").
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201)
			.log().all();
	}
	
	//@Test
	public void testPut() {
		JSONObject request = new JSONObject();
		
		request.put("Name", "Aditi");
		request.put("Profession", "Teacher");
		
		System.out.println(request.toJSONString());
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		RestAssured.given().
			header("Content-Type","applcation/json").
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200)
			.log().all();
		
	}

	
	@Test
	public void testPatch() {
		JSONObject request = new JSONObject();
		
		request.put("Name", "Aditi");
		request.put("Profession", "Teacher");
		
		System.out.println(request.toJSONString());
		
		RestAssured.baseURI = "https://reqres.in";
		
		RestAssured.given().
			header("Content-Type","applcation/json").
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200)
			.log().all();
	}
	
	@Test
	public void testDelete() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		RestAssured.when().
			delete("/api/users/2").
		then().
			statusCode(204)
			.log().all();
		
	}




}
