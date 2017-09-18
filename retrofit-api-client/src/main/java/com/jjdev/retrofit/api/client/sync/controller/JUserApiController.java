package com.jjdev.retrofit.api.client.sync.controller;

import com.jjdev.retrofit.api.client.json.JUser;
import com.jjdev.retrofit.api.client.mapping.JUserApiInterface;
import java.io.IOException;
import java.util.LinkedList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class JUserApiController {

    private final JUserApiInterface.UserApiInterface serviceApi;
    private String errorMessage;

    public JUserApiController() {
        serviceApi = JUserApiInterface.getBrandApiClient();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public JUser create(JUser user) {

        Call<JUser> call = serviceApi.create(user);
        try {
            Response<JUser> response = call.execute();
            if (response != null && response.code() == 200) {
                user = response.body();
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }

        return user;
    }

    public LinkedList<JUser> readAll() {

        LinkedList<JUser> list = null;

        Call<LinkedList<JUser>> call = serviceApi.readAll();
        try {
            Response<LinkedList<JUser>> response = call.execute();
            if (response != null && response.code() == 200) {
                list = response.body();
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }

        return list;
    }

    public JUser read(Integer id) {

        JUser user = null;

        Call<JUser> call = serviceApi.read(id);
        try {
            Response<JUser> response = call.execute();
            if (response != null && response.code() == 200) {
                user = response.body();
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }

        return user;
    }

    public JUser update(JUser user) {

        Call<JUser> call = serviceApi.update(user);
        try {
            Response<JUser> response = call.execute();
            if (response != null && response.code() == 200) {
                user = response.body();
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }

        return user;
    }

    public JUser delete(JUser user) {

        Call<ResponseBody> call = serviceApi.delete(user.getId());
        try {
            Response<ResponseBody> response = call.execute();
            if (response != null && response.code() == 200) {
                return user;
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }

        return null;
    }

}
