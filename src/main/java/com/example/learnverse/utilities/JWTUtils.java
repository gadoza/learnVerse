package com.example.learnverse.utilities;

import java.util.Base64;
import java.util.StringTokenizer;

public class JWTUtils {
    public static String payloadJWTExtraction(String jwtToken, String key) {
        StringTokenizer tokenizer = new StringTokenizer(jwtToken, ".");
        tokenizer.nextToken(); // Skip the header
        String payload = tokenizer.nextToken(); // Get the payload

        String decodedPayload = new String(Base64.getUrlDecoder().decode(payload));

        // Assuming the payload is a simple JSON object and key is surrounded by quotes
        int keyIndex = decodedPayload.indexOf(key);
        if (keyIndex == -1) {
            return null; // Key not found in payload
        }

        int valueStart = decodedPayload.indexOf('"', keyIndex + key.length()) + 1;
        int valueEnd = decodedPayload.indexOf('"', valueStart);

        return decodedPayload.substring(valueStart, valueEnd);
    }
}
