package com.openapi.openconfig.utility;


import com.openapi.openconfig.constant.ConfigEndPoints;
import java.util.Base64;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtils {

    public static byte getByteFromBoolean(boolean bool) {

        return bool ? Byte.parseByte("1") : Byte.parseByte("0");

    }

    public static String encodeStringToBase64(String input) {

        byte[] encodedBytes = Base64.getEncoder().encode(input.getBytes());
        return new String(encodedBytes);

    }

    public static String randomString(int n) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static boolean canSkipFilter(String url) {
        if (url.equals(ConfigEndPoints.ENDPOINT_USER + "/login") 
                ||  url.contains(ConfigEndPoints.ENDPOINT_USER) 
                || url.contains("status") 
                || url.contains("swagger") 
                || url.contains("api-docs")
                // || url.contains("crud-panel")
                ) {
            return true;
        }
        return false;
    }

    public static boolean canSkipAuthorizationFilter(String url) {
        if (url.contains("excel")) {
            return true;
        } else {
            return false;
        }
    }

}
