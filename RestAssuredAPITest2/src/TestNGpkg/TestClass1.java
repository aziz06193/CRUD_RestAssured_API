package TestNGpkg;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestClass1 {

	@BeforeTest
	public void initializer() {
		RestAssured.baseURI = "https://gorest.co.in/public/v2";
	}
	@Test
	public void getUser() {
		String token = "7647a7d121a8f84077f179e18dff8d3d5bd676adffc3da57490b031b158b46ae";
		Response response = RestAssured.given().auth().oauth2(token).get("/users");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.statusCode(), 200);
	}
	
//	@Test
	public void createmyuser() {
		String str = "{\"name\":\"LegionTech\", \"gender\":\"male\", \"email\":\"user@legiontech.com\", \"status\":\"active\"}";
//		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		String token = "7647a7d121a8f84077f179e18dff8d3d5bd676adffc3da57490b031b158b46ae";
		Response response = RestAssured.given().auth().oauth2(token)
				.header("Content-type", "application/json")
				.body(str).post("/users").then().extract().response();
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		//System.out.println(response.getHeaders());
		
		Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), "LegionTech");
        Assert.assertEquals(response.jsonPath().getString("email"), "user@legiontech.com");
        Assert.assertEquals(response.jsonPath().getString("status"), "active");
	}	
	
//	@Test
	public void updatemyuser() {
		String str = "{\"name\":\"LegionTechNew\"}";
//		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		String token = "7647a7d121a8f84077f179e18dff8d3d5bd676adffc3da57490b031b158b46ae";
		Response response = RestAssured.given().auth().oauth2(token)
				.header("Content-type", "application/json").and()
				.body(str).when().patch("/users/11675")
				.then().extract().response();
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		//System.out.println(response.getHeaders());
		
		Assert.assertEquals(response.statusCode(), 200);
//        Assert.assertEquals(response.jsonPath().getString("name"), "LegionTech");
//        Assert.assertEquals(response.jsonPath().getString("email"), "user1234@legiontech.com");
//        Assert.assertEquals(response.jsonPath().getString("status"), "active");
	}	
	
//	@Test
	public void getPost() {
		String token = "7647a7d121a8f84077f179e18dff8d3d5bd676adffc3da57490b031b158b46ae";
		Response response = RestAssured.given().auth().oauth2(token).get("/posts");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}
	
//	@Test
	public void InsertCommentInPost() {
		String str = "{\"user_id\":\"1122\",\"title\":\"Post by LegionTech22\", \"body\":\"LegionTech22\"}";
//		RestAssured.baseURI = "https://gorest.co.in/public/v2/posts";
		String token = "7647a7d121a8f84077f179e18dff8d3d5bd676adffc3da57490b031b158b46ae";
		Response response = RestAssured.given().auth().oauth2(token)
				.header("Content-type", "application/json").and()
				.body(str).when().post("/posts")
				.then().extract().response();
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		//System.out.println(response.getHeaders());
		
		Assert.assertEquals(response.statusCode(), 201);
//        Assert.assertEquals(response.jsonPath().getString("name"), "LegionTech");
//        Assert.assertEquals(response.jsonPath().getString("email"), "user1234@legiontech.com");
//        Assert.assertEquals(response.jsonPath().getString("status"), "active");
	}
	

//	@Test
	public void DeleteCommentInPost() {
		String token = "7647a7d121a8f84077f179e18dff8d3d5bd676adffc3da57490b031b158b46ae";
		Response response = RestAssured.given().auth().oauth2(token)
				.header("Content-type", "application/json").delete("/posts/2874")
				.then().extract().response();
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
		Assert.assertEquals(response.statusCode(), 204);
	}
	
	@Test
	public void DeleteUser() {
		String token = "7647a7d121a8f84077f179e18dff8d3d5bd676adffc3da57490b031b158b46ae";
		Response response = RestAssured.given().auth().oauth2(token)
				.header("Content-type", "application/json").delete("/users/11675")
				.then().extract().response();
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		//System.out.println(response.getHeaders());
		
		Assert.assertEquals(response.statusCode(), 204);
	}
	
	
}



