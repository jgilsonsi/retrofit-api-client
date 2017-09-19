package com.jjdev.retrofit.api.client.controller.listener;

import com.jjdev.retrofit.api.client.model.JUser;
import java.util.LinkedList;

/**
 *
 * @author jgilson
 */
public interface IUserReadAllListener {

    public void onSucess(LinkedList<JUser> collection);

    public void onError();

    public void onFailure(String message);

}
