package com.demoda;




import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import api.ReadProperties;



public class APIBaseTest {


    protected static final RequestSpecification REQUEST_SPECIFICATION =
            new RequestSpecBuilder()
                    .setBaseUri(ReadProperties.getProperty("api_url"))
                    .setContentType(ContentType.JSON)
                    .build();


    }
