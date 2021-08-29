package com.demoda;

import api.EndPoints;
import api.model.DataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class APITests extends APIBaseTest {


    @Test
    public void getBookByIsbnTest() {

        given()
                .spec(REQUEST_SPECIFICATION)
                .queryParam("ISBN", "9781593277574")
                .get(EndPoints.GET_BOOK)
                .then().assertThat().statusCode(200).log().all()
                .assertThat().body("title", Matchers.equalTo("Understanding ECMAScript 6"));


    }

    @Test
    public void getBookByIsbnErrorTest() {

        given()
                .spec(REQUEST_SPECIFICATION)
                .queryParam("ISBN", "wrong ISBN")
                .get(EndPoints.GET_BOOK)
                .then().assertThat().statusCode(400).log().all()
                .assertThat().body("message", Matchers.equalTo("ISBN supplied is not available in Books Collection!"));

    }

    @Test
    public void getBooksTest() {
        given()
                .spec(REQUEST_SPECIFICATION)
                .when().get(EndPoints.GET_BOOKS)
                .then().
                assertThat().body("books", Matchers.hasSize(8)).log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void autorizationTest() {

        given()
                .spec(REQUEST_SPECIFICATION)
                .body("{\"userName\": \"super\",\"password\": \"Super123+!\"}")
                .when().post(EndPoints.ACCOUNT_AUTHORIZED)
                .then().assertThat().statusCode(200);

    }

    @Test
    public void autorizationErrorTest() {

        given()
                .spec(REQUEST_SPECIFICATION)
                .body("{\"userName\": \"super\",\"password\": \"Pass\"}")
                .when().post(EndPoints.ACCOUNT_AUTHORIZED)
                .then().assertThat().statusCode(404).log().all().assertThat().body("message", Matchers.equalTo("User not found!"));


    }

    @Test
    public void getToken() {
        String token = given()
                .spec(REQUEST_SPECIFICATION)
                .body("{\"userName\": \"super\",\"password\": \"Super123+!\"}")
                .when().post(EndPoints.ACCOUNT_GENERATE_TOKEN)
                .then().extract().jsonPath().getString("token");

        given()
                .spec(REQUEST_SPECIFICATION)
                .header("Authorization", "Bearer " + token)
                .pathParam("UUID", DataProvider.getUUID())
                .when().get(EndPoints.GET_USER)
                .then().assertThat().body("userId", Matchers.equalTo(DataProvider.getUUID()))
                .assertThat().body("username", Matchers.equalTo(DataProvider.getUsername()));
        System.out.println(token);
    }
}
