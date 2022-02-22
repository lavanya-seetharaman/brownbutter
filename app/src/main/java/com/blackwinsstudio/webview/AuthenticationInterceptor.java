package com.blackwinsstudio.webview;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    private String authToken="yewv^EIUol#lOZdM2IocQ^X!";
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
       Request original = chain.request ();
       Request.Builder builder = original.newBuilder ()
               .header ("authorization", authToken);
       Request req = builder.build ();
        return chain.proceed (req);
    }
}
