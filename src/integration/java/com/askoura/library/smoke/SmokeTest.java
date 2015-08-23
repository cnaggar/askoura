package com.askoura.library.smoke;

import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import com.askoura.library.Launcher;
import com.jayway.restassured.RestAssured;

public class SmokeTest {
    
    @BeforeClass
    public static void launchServer() throws Exception {
        Launcher.main(new String[0]);
    }

    @Test
    public void check_that_isAlive_works() throws Exception {
        RestAssured
                .when()
                .get("http://localhost:9898/isalive")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
