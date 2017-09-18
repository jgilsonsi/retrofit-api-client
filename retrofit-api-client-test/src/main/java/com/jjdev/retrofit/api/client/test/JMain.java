package com.jjdev.retrofit.api.client.test;

import com.jjdev.retrofit.api.client.json.JUser;
import com.jjdev.retrofit.api.client.sync.controller.JUserApiController;
import java.util.LinkedList;

/**
 *
 * @author jgilson
 */
public class JMain {

    public static void main(String[] args) {

        JUserApiController apiController = new JUserApiController();

        System.out.println("\nRead all users --------------------------------");

        LinkedList<JUser> users = apiController.readAll();
        if (users != null) {
            users.forEach(user -> System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword()));
        } else {
            System.out.println("Error: " + apiController.getErrorMessage());
        }

        System.out.println("\nRead user -------------------------------------");

        JUser user = apiController.read(3);
        if (user != null) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
        } else {
            System.out.println("Error: " + apiController.getErrorMessage());
        }

        System.out.println("\nCreate user -----------------------------------");

        user = new JUser();
        user.setName("jjdev");
        user.setPassword("123Mudar");

        user = apiController.create(user);

        if (user != null) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
        } else {
            System.out.println("Error: " + apiController.getErrorMessage());
        }

        System.out.println("\nUpdate user -----------------------------------");

        user = new JUser();
        user.setId(1);
        user.setName("Updated");
        user.setPassword("123Updated");

        user = apiController.update(user);

        if (user != null) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
        } else {
            System.out.println("Error: " + apiController.getErrorMessage());
        }

        System.out.println("\nDelete user -----------------------------------");

        user = apiController.delete(user);

        if (user != null) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
        } else {
            System.out.println("Error: " + apiController.getErrorMessage());
        }
    }

}
