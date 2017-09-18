package com.jjdev.retrofit.api.client.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author jgilson
 */
public class JUser implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @SerializedName("ID")
    private Integer id;

    @SerializedName("UserName")
    private String name;

    @SerializedName("Password")
    private String password;

    public JUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
