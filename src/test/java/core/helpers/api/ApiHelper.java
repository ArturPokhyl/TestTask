package core.helpers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.ConfigReader;
import core.data_models.CreatePageResponse;
import core.data_models.StatusResponse;
import core.helpers.LoggerHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class ApiHelper {
    private final String baseUrl;
    private final String statusUrl;
    private final String publicKey;
    private final String secretKey;

    public ApiHelper() {
        this.baseUrl = ConfigReader.getProperty("api.properties", "base.url");
        this.statusUrl = ConfigReader.getProperty("api.properties", "status.url");
        this.publicKey = ConfigReader.getProperty("api.properties", "public.key");
        this.secretKey = ConfigReader.getProperty("api.properties", "secret.key");
    }

    private Logger log() {
        return LoggerHelper.log(this.getClass()).getLogger();
    }

    private RequestSpecification getBaseRequestSpec(String signature, String url) {
        log().info("Get base spec");
        return given()
                .baseUri(url)
                .header("Signature", signature)
                .header("Merchant", publicKey)
                .contentType(ContentType.JSON);
    }

    public CreatePageResponse createPaymentPage(String jsonBody) {
        log().info("Create payment page by sending request, Json => {}", jsonBody);
        String signature = SignatureGenerator.generateSignature(publicKey, jsonBody, secretKey);
        Response response = getBaseRequestSpec(signature, baseUrl)
                .body(jsonBody)
                .when()
                .post("/init");
        response.then().statusCode(200);

        return response.as(CreatePageResponse.class);
    }

    public StatusResponse getStatus(String jsonBody) {
        log().info("Get status => {}", jsonBody);
        String signature = SignatureGenerator.generateSignature(publicKey, jsonBody, secretKey);
        Response response = getBaseRequestSpec(signature, statusUrl)
                .header("Cache-Control", "no-cache")
                .body(jsonBody)
                .when()
                .post("/status");
        response.then().statusCode(200);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response.getBody().asString(), StatusResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
