package com.jjdev.retrofit.api.client;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author jgilson
 */
public class JApiSetup {

    private static final String URL_API = "http://fakerestapi.azurewebsites.net/";

    public static Retrofit getApiClient() {

        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor((Interceptor.Chain chain) -> {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Accept", "application/json")
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();

                    return chain.proceed(request);
                }).build();

        Retrofit client = new Retrofit.Builder()
                .baseUrl(URL_API)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return client;
    }

}
