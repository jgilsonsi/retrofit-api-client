package com.jjdev.retrofit.api.client.endpoint;

import com.jjdev.retrofit.api.client.JApiSetup;
import com.jjdev.retrofit.api.client.model.JBook;
import java.util.LinkedList;
import okhttp3.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public class JBookApiInterface {

    private static IBookApiInterface bookApiInterface;

        public static IBookApiInterface getBookApiClient() {
        if (bookApiInterface == null) {
            bookApiInterface = JApiSetup.getApiClient().create(IBookApiInterface.class);
        }
        return bookApiInterface;
    }

    public interface IBookApiInterface {

        @POST("api/Book")
        Call<JBook> create(@Body JBook book);

        @GET("api/Book")
        Call<JBook> read(@Query("id") Integer id);

        @GET("api/Book")
        Call<LinkedList<JBook>> readAll();

        @PUT("api/Book")
        Call<JBook> update(@Body JBook book);

        @DELETE("api/Book")
        Call<ResponseBody> delete(@Query("id") Integer id);

    }

}
