package com.blackwinsstudio.webview;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BwtRetrofitClient {
    private static Retrofit bwtRetrofitClient;
    private static String BWT_BASE_URL="https://bwt-custom-api.herokuapp.com/";

    //private static String BWT_BASE_URL="https://sastamart-vendor-users.herokuapp.com/";
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Gson gson = new GsonBuilder ().setDateFormat("yyyy-MM-dd").create();
    public static Retrofit getRetrofitInstance(){
        if(bwtRetrofitClient ==null){
            bwtRetrofitClient = new Retrofit.Builder ()
                    .baseUrl (BWT_BASE_URL)
                    .addConverterFactory (GsonConverterFactory.create (gson))
                    .build ();
        }
        return bwtRetrofitClient;
    }
}
