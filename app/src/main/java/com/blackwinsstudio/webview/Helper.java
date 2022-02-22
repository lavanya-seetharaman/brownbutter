package com.blackwinsstudio.webview;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Helper {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getAuthToken(){
        byte[] data = (ApplicationConstant.API_USER_NAME + ":" + ApplicationConstant.API_PASSWORD).getBytes (StandardCharsets.UTF_8);

        //String result = "Basic " + "YWRtaW46IDJLTHU5OW9uJiM=";
        // Second Modification
        String result = "Basic " + "YWRtaW46eWV3dl5FSVVvbCNsT1pkTTJJb2NRXlgh";
        Log.i (ApplicationConstant.TAG, result);
       // return "Basic " + Base64.getEncoder ().encodeToString (data);
        return result;
    }
}
