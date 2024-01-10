package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//UserEndPints.java
// Created for perform Create, Read, Update, Delete requests t the user API.

public class UserEndPoints {

		public static Response createUser(User payload)
		{
			Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.create_URL);
				
			return response;
		}
		
		
		public static Response readUser(String username)
		{
			Response response=given()
							.pathParam("username",username)
			.when()
				.get(Routes.CRUD_URL);
				
			return response;
		}
		
		
		public static Response updateUser(String userName, User payload)
		{
			Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
			.when()
				.put(Routes.CRUD_URL);
				
			return response;
		}
		
		
		public static Response deleteUser(String userName)
		{
			Response response=given()
							.pathParam("username",userName)
			.when()
				.delete(Routes.CRUD_URL);
				
			return response;
		}	
				
		
}
