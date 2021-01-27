package com.pyxispm.MediaPlanManagement;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getMediaPlans {
	@Test
	public void getMediaPlans1() {
		System.out.println("hi");
		/*
		 * RestAssured.baseURI = "https://dev-aiquire-dashboard.web.app/dashboard/api";
		 * RequestSpecification httpRequest = RestAssured.given(); Response response =
		 * httpRequest.get("/clients/media-plans"); int statusCode =
		 * response.getStatusCode(); Assert.assertEquals(statusCode actual value, 200
		 * expected value, "Correct status code returned");
		 */
	}
}
