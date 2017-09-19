package com.jjdev.retrofit.api.client.controller.listener;

import com.jjdev.retrofit.api.client.model.JUser;

/**
 *
 * @author jgilson
 */
public interface IUserUpdateListener {

    public void onSucess(JUser entity);

    public void onError();

    public void onFailure(String message);

}
