package com.blackwinsstudio.webview;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    //private static String BASE_URL="https://staging5.sastaamart.com/wp-json/";
    //Second modifications
    private static String BASE_URL="https://brownbutter.nirmalinnovations.com/wp-json/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Gson gson = new GsonBuilder ().setDateFormat("yyyy-MM-dd").create();
    public static Retrofit getRetrofitInstance(){
        if(retrofit ==null){
            retrofit = new Retrofit.Builder ()
                    .baseUrl (BASE_URL)
                    .addConverterFactory (GsonConverterFactory.create (gson))
                    .build ();
        }
        return retrofit;
    }
}
