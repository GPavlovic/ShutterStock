package com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock;

import android.util.Base64;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ShutterStock
{
    private static ShutterStockService SHUTTERSTOCK_SERVICE;
    private static final String API_URL = "https://api.shutterstock.com";

    public static ShutterStockService getServiceInstance()
    {
        if (SHUTTERSTOCK_SERVICE == null)
        {
            Interceptor INTERCEPTOR = new Interceptor()
            {
                @Override
                public Response intercept(Chain chain) throws IOException
                {
                    String authInfo = "API_KEY_HERE";
                    String authString = "Basic " + Base64.encodeToString(authInfo.getBytes(), Base64.NO_WRAP);

                    Request newRequest = chain.request().newBuilder().addHeader("Authorization", authString).build();
                    return chain.proceed(newRequest);
                }
            };

            OkHttpClient CLIENT = new OkHttpClient();
            CLIENT.interceptors().add(INTERCEPTOR);

            Retrofit retro = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(CLIENT)
                    .build();

            SHUTTERSTOCK_SERVICE = retro.create(ShutterStockService.class);
        }

        return SHUTTERSTOCK_SERVICE;
    }
}
