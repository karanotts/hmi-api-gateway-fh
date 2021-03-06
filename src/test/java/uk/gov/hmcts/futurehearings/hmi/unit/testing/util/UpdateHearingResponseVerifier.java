package uk.gov.hmcts.futurehearings.hmi.unit.testing.util;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UpdateHearingResponseVerifier {

    private static final String MISSING_SUB_KEY_ERROR = "Access denied due to missing subscription key. Make sure to include subscription key when making requests to an API.";

    public static void thenASuccessfulResponseForUpdateIsReturned(Response response, ExtentTest objStep) {

        try{
            Map<String, String> responseMap = response.getBody().jsonPath().getMap("$");
            //assertEquals(2, responseMap.size());
            assertEquals("Status Code Validation:",201, response.getStatusCode());
            objStep.pass("Got the expected response code: 201");
            assertEquals("Status Code Description Validation:","Hearings updated successfully", responseMap.get(("description")));
            objStep.pass("Got the expected description: " + responseMap.get(("description")));
        }
        catch (AssertionError e){
            objStep.fail("Exception in "+e.getMessage());
            objStep.info(e);
            throw e;
        }
        catch (Exception e){
            objStep.fail("Exception: "+e.getClass());
            objStep.info(e);
            throw e;
        }
    }

    public static void thenResponseForMissingHeaderOcpSubscriptionIsReturned(Response response, ExtentTest objStep) {

        try{
            Map<String, String> responseMap = response.getBody().jsonPath().getMap("$");
            //assertEquals(2, responseMap.size());
            assertEquals("Status Code Validation:",401, response.getStatusCode());
            objStep.pass("Got the expected response code: 401");
            assertEquals("Status Code Description Validation:",MISSING_SUB_KEY_ERROR, responseMap.get(("message")));
            objStep.pass("Got the expected description: " + responseMap.get(("message")));
        }
        catch (AssertionError e){
            objStep.fail("Exception in "+e.getMessage());
            objStep.info(e);
            throw e;
        }
        catch (Exception e){
            objStep.fail("Exception: "+e.getClass());
            objStep.info(e);
            throw e;
        }
    }

    public static void thenValidateUpdateHearingResponse(Response response, String missingField, ExtentTest objStep){
        try{
            Map<String, String> responseMap = response.getBody().jsonPath().getMap("$");
            //assertEquals(2, responseMap.size());
            assertEquals("Status Code Validation:",400, response.getStatusCode());
            objStep.pass("Got the expected response code: 400");
            assertEquals("Status Code Description Validation:","Missing/Invalid Header "+missingField, responseMap.get(("message")));
            objStep.pass("Got the expected description: " + responseMap.get(("message")));
        }
        catch (AssertionError e){
            objStep.fail("Exception in "+e.getMessage());
            objStep.info(e);
            throw e;
        }
        catch (Exception e){
            objStep.fail("Exception: "+e.getClass());
            objStep.info(e);
            throw e;
        }
    }

}
