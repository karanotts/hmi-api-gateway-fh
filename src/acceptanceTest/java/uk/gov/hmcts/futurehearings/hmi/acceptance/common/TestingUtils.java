package uk.gov.hmcts.futurehearings.hmi.acceptance.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.util.ResourceUtils;

@Slf4j
public class TestingUtils {

    public static String readFileContents (final String path) throws IOException {

        File file = ResourceUtils.getFile("classpath:"+path);
        //File is found
        log.debug("File Found : " + file.exists());
        return new String(Files.readAllBytes(Paths.get(file.toURI())));
    }

    public static void comparePayloads(final String expectedPayloadPath, final Response response) {
        try {
            String output =
                    readFileContents(expectedPayloadPath);
            JSONAssert.assertEquals(output,
                    response.getBody().asString(), JSONCompareMode.STRICT);
        } catch (JSONException jsonException) {
            throw new AssertionError("Payloads have not matched");
        } catch (IOException ioException ) {
            throw new AssertionError("Response file cannot be read..");
        }
    }
}
