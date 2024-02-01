package utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class httpHelper extends jsonHelper
{
	ValidatableResponse response;
	
	public void post(HashMap<String, String> payloadData) {
		try {
			response = given().baseUri("https://localhost:8080").contentType(ContentType.JSON).body(updateJsonBody(payloadData))
	        .when().post("/api/bank/" + payloadData.get("RESOURCE"))
	        .then().assertThat().statusCode(201);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void put(HashMap<String, String> payloadData) {
		try {
			response = given().baseUri("https://localhost:8080").contentType(ContentType.JSON).body(updateJsonBody(payloadData))
	        .when().put("/api/bank/" + payloadData.get("RESOURCE"))
	        .then().assertThat().statusCode(201);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(String accountNumber) {
		try {
			response = given().baseUri("https://localhost:8080").contentType(ContentType.JSON)
		            .when().delete("/api/bank/deleteAccount/" + accountNumber)
		            .then().assertThat().statusCode(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getAccountId() {
		return response.extract().body().path("Id");
	}
	
	public void validateResponseCode(String statusCode) {
		assertEquals(response.extract().statusCode(), Integer.parseInt(statusCode));
	}
	
	public void validateResponseMessage(String responseMessage) {
		assertTrue(response.extract().body().asString().contains(responseMessage));
	}
	
}