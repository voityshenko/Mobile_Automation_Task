package com.learn.atm.utils;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class RequestUtils {

    private static final Logger LOG = LogManager.getRootLogger();
    private static final String AUTHORIZATION_NAME = "Authorization";
    private static final String AUTHORIZATION_VALUE = "Bearer %s";
    private static final String STATUS_CODE_MESSAGE = "Status code is {}";

    private RequestUtils() {
    }

    public static void takeDevice(String url, String serial, String key) {
        LOG.info("Attempt to take a device with serial {}", serial);
        Response response = given()
                .header(AUTHORIZATION_NAME, format(AUTHORIZATION_VALUE, key))
                .header("Content-type", "application/json")
                .when()
                .post(format("%s/device/%s", url, serial));
        LOG.info(STATUS_CODE_MESSAGE, response.getStatusCode());
        response.getBody().prettyPrint();
    }

    public static void installApp(String url, String serial, String key, String appPath) {
        LOG.info("Attempt to install app on the {} device", serial);
        Response response = given()
                .header(AUTHORIZATION_NAME, format(AUTHORIZATION_VALUE, key))
                .param("file", new File(appPath))
                .when()
                .post(format("%s/storage/install/%s", url, serial));
        LOG.info(STATUS_CODE_MESSAGE, response.getStatusCode());
        response.getBody().prettyPrint();
    }
}
