package com.jjdev.retrofit.api.client.controller;

import com.jjdev.retrofit.api.client.endpoint.JBookApiInterface;
import com.jjdev.retrofit.api.client.model.JBook;
import java.io.IOException;
import java.util.LinkedList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class JBookApiController {

    private final JBookApiInterface.IBookApiInterface serviceApi;
    private String errorMessage;

    public JBookApiController() {
        serviceApi = JBookApiInterface.getBookApiClient();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public JBook create(JBook book) {

        Call<JBook> call = serviceApi.create(book);
        try {
            Response<JBook> response = call.execute();
            if (response != null && response.code() == 200) {
                book = response.body();
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }

        return book;
    }

    public LinkedList<JBook> readAll() {

        LinkedList<JBook> list = null;

        Call<LinkedList<JBook>> call = serviceApi.readAll();
        try {
            Response<LinkedList<JBook>> response = call.execute();
            if (response != null && response.code() == 200) {
                list = response.body();
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }

        return list;
    }

    public JBook read(Integer id) {

        JBook book = null;

        Call<JBook> call = serviceApi.read(id);
        try {
            Response<JBook> response = call.execute();
            if (response != null && response.code() == 200) {
                book = response.body();
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }

        return book;
    }

    public JBook update(JBook book) {

        Call<JBook> call = serviceApi.update(book);
        try {
            Response<JBook> response = call.execute();
            if (response != null && response.code() == 200) {
                book = response.body();
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }

        return book;
    }

    public JBook delete(JBook book) {

        Call<ResponseBody> call = serviceApi.delete(book.getId());
        try {
            Response<ResponseBody> response = call.execute();
            if (response != null && response.code() == 200) {
                return book;
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }

        return null;
    }

}
