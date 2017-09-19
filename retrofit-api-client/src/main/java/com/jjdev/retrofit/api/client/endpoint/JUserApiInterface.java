package com.jjdev.retrofit.api.client.endpoint;

import com.jjdev.retrofit.api.client.JApiSetup;
import com.jjdev.retrofit.api.client.model.JUser;
import java.util.LinkedList;
import okhttp3.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public class JUserApiInterface {

    private static IUserApiInterface userApiInterface;

    public static IUserApiInterface getUserApiClient() {
        if (userApiInterface == null) {
            userApiInterface = JApiSetup.getApiClient().create(IUserApiInterface.class);
        }
        return userApiInterface;
    }

    public interface IUserApiInterface {

        @POST("api/Users")
        Call<JUser> create(@Body JUser user);

        @GET("api/Users")
        Call<JUser> read(@Query("id") Integer id);

        @GET("api/Users")
        Call<LinkedList<JUser>> readAll();

        @PUT("api/Users")
        Call<JUser> update(@Query("id") Integer id, @Body JUser user);

        @DELETE("api/Users")
        Call<ResponseBody> delete(@Query("id") Integer id);

    }

}
