package com.askoura.library.smoke;

import org.apache.http.HttpStatus;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.askoura.library.Launcher;
import com.jayway.restassured.RestAssured;

public class SmokeTest {

    private static Launcher launcher;

    @BeforeClass
    public static void launchServer() throws Exception {
        launcher = new Launcher();
        launcher.start(new String[0]);
    }
    
    @AfterClass
    public static void destroyServer() throws Exception {
        launcher.stop();
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
