package com.jjdev.retrofit.api.client.controller;

import com.jjdev.retrofit.api.client.controller.listener.IUserCreateListener;
import com.jjdev.retrofit.api.client.controller.listener.IUserDeleteListener;
import com.jjdev.retrofit.api.client.model.JUser;
import com.jjdev.retrofit.api.client.endpoint.JUserApiInterface;
import java.io.IOException;
import java.util.LinkedList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.jjdev.retrofit.api.client.controller.listener.IUserReadAllListener;
import com.jjdev.retrofit.api.client.controller.listener.IUserReadListener;
import com.jjdev.retrofit.api.client.controller.listener.IUserUpdateListener;

public class JUserApiController {

    private final JUserApiInterface.IUserApiInterface serviceApi;
    private String errorMessage;
    private IUserCreateListener createListener;
    private IUserReadListener readListener;
    private IUserReadAllListener readAllListener;
    private IUserUpdateListener updateListener;
    private IUserDeleteListener deleteListener;

    public JUserApiController() {
        serviceApi = JUserApiInterface.getUserApiClient();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    // async calls -------------------------------------------------------------
    public void create(JUser entity, IUserCreateListener listener) {
        createListener = listener;
        Call<JUser> call = serviceApi.create(entity);
        call.enqueue(new Callback<JUser>() {
            @Override
            public void onResponse(Call<JUser> call, Response<JUser> response) {
                if (response.code() == 200) {
                    JUser entity = response.body();
                    createListener.onSucess(entity);
                } else {
                    createListener.onError();
                }
            }

            @Override
            public void onFailure(Call<JUser> call, Throwable thrwbl) {
                errorMessage = thrwbl.getMessage();
                createListener.onFailure(thrwbl.getMessage());
            }
        });
    }

    public void read(Integer id, IUserReadListener listener) {
        readListener = listener;
        Call<JUser> call = serviceApi.read(id);
        call.enqueue(new Callback<JUser>() {
            @Override
            public void onResponse(Call<JUser> call, Response<JUser> response) {
                if (response.code() == 200) {
                    JUser entity = response.body();
                    readListener.onSucess(entity);
                } else {
                    readListener.onError();
                }
            }

            @Override
            public void onFailure(Call<JUser> call, Throwable thrwbl) {
                errorMessage = thrwbl.getMessage();
                readListener.onFailure(thrwbl.getMessage());
            }
        });
    }

    public void readAll(IUserReadAllListener listener) {
        readAllListener = listener;
        Call<LinkedList<JUser>> call = serviceApi.readAll();
        call.enqueue(new Callback<LinkedList<JUser>>() {
            @Override
            public void onResponse(Call<LinkedList<JUser>> call, Response<LinkedList<JUser>> response) {
                if (response.code() == 200) {
                    LinkedList<JUser> collection = response.body();
                    readAllListener.onSucess(collection);
                } else {
                    readAllListener.onError();
                }
            }

            @Override
            public void onFailure(Call<LinkedList<JUser>> call, Throwable thrwbl) {
                errorMessage = thrwbl.getMessage();
                readAllListener.onFailure(thrwbl.getMessage());
            }
        });
    }

    public void update(JUser entity, IUserUpdateListener listener) {
        updateListener = listener;
        Call<JUser> call = serviceApi.update(entity.getId(), entity);
        call.enqueue(new Callback<JUser>() {
            @Override
            public void onResponse(Call<JUser> call, Response<JUser> response) {
                if (response.code() == 200) {
                    JUser entity = response.body();
                    updateListener.onSucess(entity);
                } else {
                    updateListener.onError();
                }
            }

            @Override
            public void onFailure(Call<JUser> call, Throwable thrwbl) {
                errorMessage = thrwbl.getMessage();
                updateListener.onFailure(thrwbl.getMessage());
            }
        });
    }

    public void delete(JUser entity, IUserDeleteListener listener) {
        deleteListener = listener;
        Call<ResponseBody> call = serviceApi.delete(entity.getId());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    deleteListener.onSucess(entity);
                } else {
                    deleteListener.onError();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable thrwbl) {
                errorMessage = thrwbl.getMessage();
                deleteListener.onFailure(thrwbl.getMessage());
            }
        });
    }

    // sync calls --------------------------------------------------------------
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

    public JUser update(JUser user) {

        Call<JUser> call = serviceApi.update(user.getId(), user);
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
