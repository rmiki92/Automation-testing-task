package testsBE1andBE2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TestConfirmation {

	String apiKey = "5bdef77a-5b9e-4e22-8f1c-937c82b0c42e";

	@Test
	public void confirmationTest() {
		// setting base and main url path
		RestAssured.baseURI = "https://pro-api.coinmarketcap.com";
		String basePath = "/v1/cryptocurrency";
		RestAssured.basePath = basePath;

		RequestSpecification request = RestAssured.given();
		// print JSON body response
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addHeader("X-CMC_PRO_API_KEY", apiKey);
		builder.addHeader("Accepts", "application/json");
		builder.addParam("id", "3843");
		RequestSpecification requestSpec = builder.build();
		Response response = given().contentType(ContentType.JSON).log().all().spec(requestSpec).get("/info");
		response.prettyPrint();

		// confirm response values
		given().spec(requestSpec).when().get("/info").then().body("data.3843.symbol", equalTo("BOLT"))
				.body("status.error_message", equalTo(null))
				.body("data.3843.urls.source_code[0]", equalTo("https://github.com/SyQic-Ops/bolt"))
				.body("data.3843.date_added", equalTo("2019-04-05T00:00:00.000Z"))
				.body("data.3843.logo", equalTo("https://s2.coinmarketcap.com/static/img/coins/64x64/3843.png"))
				.body("data.3843.urls.website[0]", equalTo("https://bolt.global/"));
		response.prettyPrint();

		// then()
		// .body("data.symbol", equalTo("BOLT"))
		// .body("data.status", equalTo(null));
		// .statusCode(200);

		// ResponseBody bodyRes = response.getBody();

		// String body = bodyRes.asString();
		// System.out.println(body);

		//
		// RequestSpecification requestSpecs = new
		// RestAssuredConfiguration().getRequestSpecification();

		// int statusCode = RestAssured.given()
		// .header("X-CMC_PRO_API_KEY", apiKey)
		// .when()
		// .get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/info")
		// .getStatusCode()
		// System.out.println("Code is "+statusCode);

		// given().header("X-CMC_PRO_API_KEY", apiKey)
		// .header("Accepts", "application/json").log();
		// Response resp = RestAssured.get(baseURL);
		// int status = resp.getStatusCode();
		// System.out.println("status is" + status);
		// Assert.assertEquals(status, 200);
		// RequestSpecification httpRequest = RestAssured.given();

		// given().header("X-CMC_PRO_API_KEY", apiKey)
		// .header("Accepts", "application/json");
		// Response response = httpRequest.get("/symbol");
		// String boltSym = "BOLT";
		// Assert.assertEquals(boltSym,);

	}

	@Test
	public void ConvertCurrencies() {

		// setting base and main url path
		RestAssured.baseURI = "https://pro-api.coinmarketcap.com";
		String basePath1 = "/v1/cryptocurrency";
		RestAssured.basePath = basePath1;

		// USD 2781
		RequestSpecification request1 = RestAssured.given();
		// print JSON body response for BTC
		RequestSpecBuilder builder1 = new RequestSpecBuilder();
		// RestAssured.rootPath="data[0]";
		builder1.addHeader("X-CMC_PRO_API_KEY", apiKey);
		builder1.addHeader("Accepts", "application/json");
		builder1.addParam("symbol", "BTC");
		RequestSpecification requestSpec1 = builder1.build();
		Response response1 = given().contentType(ContentType.JSON).log().all().spec(requestSpec1).get("/map");
		response1.prettyPrint();

		RequestSpecification request2 = RestAssured.given();
		// print JSON body response for DEM
		RequestSpecBuilder builder2 = new RequestSpecBuilder();
		// RestAssured.rootPath="data[0]";
		builder2.addHeader("X-CMC_PRO_API_KEY", apiKey);
		builder2.addHeader("Accepts", "application/json");
		builder2.addParam("symbol", "DEM");
		RequestSpecification requestSpec2 = builder2.build();
		Response response2 = given().contentType(ContentType.JSON).log().all().spec(requestSpec2).get("/map");
		response2.prettyPrint();

		RequestSpecification request3 = RestAssured.given();
		// print JSON body response for ZER
		RequestSpecBuilder builder3 = new RequestSpecBuilder();
		// RestAssured.rootPath="data[0]";
		builder3.addHeader("X-CMC_PRO_API_KEY", apiKey);
		builder3.addHeader("Accepts", "application/json");
		builder3.addParam("symbol", "ZER");
		RequestSpecification requestSpec3 = builder3.build();
		Response response3 = given().contentType(ContentType.JSON).log().all().spec(requestSpec3).get("/map");
		response3.prettyPrint();

		
		// print JSON body response for tools/price/conversion
		String basePath2 = "/v1/tools";
		RestAssured.basePath = basePath2;
		RequestSpecification request4 = RestAssured.given();

		RequestSpecBuilder builder4 = new RequestSpecBuilder();
		// RestAssured.rootPath="data[0]";
		builder4.addHeader("X-CMC_PRO_API_KEY", apiKey);
		builder4.addHeader("Accepts", "application/json");
		builder4.addParam("amount",70);
		builder4.addParam("id","1");
		builder4.addParam("convert_id","2781");
		RequestSpecification requestSpec4 = builder4.build();
		Response response4 = given().contentType(ContentType.JSON).log().all().spec(requestSpec4).get("/price-conversion");
		//assertThat("data.quote.USD.price").isNotNull();
		response4.prettyPrint();
		//given().spec(requestSpec4).when().get("/tools/price-conversion").then().body("data.quote.USD.price", equalTo("BOLT"));

	}
}
