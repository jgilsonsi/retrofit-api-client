package com.jjdev.retrofit.api.client.test;

import com.jjdev.retrofit.api.client.model.JUser;
import com.jjdev.retrofit.api.client.controller.JUserApiController;
import com.jjdev.retrofit.api.client.controller.listener.IUserCreateListener;
import com.jjdev.retrofit.api.client.controller.listener.IUserDeleteListener;
import com.jjdev.retrofit.api.client.controller.listener.IUserReadAllListener;
import com.jjdev.retrofit.api.client.controller.listener.IUserReadListener;
import com.jjdev.retrofit.api.client.controller.listener.IUserUpdateListener;
import java.util.LinkedList;

/**
 *
 * @author jgilson
 */
public class JMain {

    public static void main(String[] args) {

        JUserApiController apiController = new JUserApiController();

        asyncCalls(apiController);
        syncCalls(apiController);
    }

    private static void asyncCalls(JUserApiController apiController) {

        System.out.println("\n____ ASYNC CALLS ____");

        System.out.println("\nRead all users --------------------------------");
        apiController.readAll(new UserReadAllListener());
        sleepTime();

        System.out.println("\nRead user -------------------------------------");
        apiController.read(3, new UserReadListener());
        sleepTime();

        System.out.println("\nCreate user -----------------------------------");
        JUser user = new JUser();
        user.setName("jjdev");
        user.setPassword("123Mudar");
        apiController.create(user, new UserCreateListener());
        sleepTime();

        System.out.println("\nUpdate user -----------------------------------");
        user.setId(7);
        user.setName("Updated");
        user.setPassword("123Updated");
        apiController.update(user, new UserUpdateListener());
        sleepTime();

        System.out.println("\nDelete user -----------------------------------");
        apiController.delete(user, new UserDeleteListener());
        sleepTime();

    }

    private static class UserReadAllListener implements IUserReadAllListener {

        @Override
        public void onSucess(LinkedList<JUser> collection) {
            LinkedList<JUser> users = collection;
            if (users != null) {
                users.forEach(user -> System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword()));
            }
        }

        @Override
        public void onError() {
            System.out.println("Error");
        }

        @Override
        public void onFailure(String message) {
            System.out.println("Failure: " + message);
        }

    }

    private static class UserReadListener implements IUserReadListener {

        @Override
        public void onSucess(JUser entity) {
            JUser user = entity;
            if (user != null) {
                System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
            }
        }

        @Override
        public void onError() {
            System.out.println("Error");
        }

        @Override
        public void onFailure(String message) {
            System.out.println("Failure: " + message);
        }

    }

    private static class UserCreateListener implements IUserCreateListener {

        @Override
        public void onSucess(JUser entity) {
            JUser user = entity;
            if (user != null) {
                System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
            }
        }

        @Override
        public void onError() {
            System.out.println("Error");
        }

        @Override
        public void onFailure(String message) {
            System.out.println("Failure: " + message);
        }

    }

    private static class UserDeleteListener implements IUserDeleteListener {

        @Override
        public void onSucess(JUser entity) {
            JUser user = entity;
            if (user != null) {
                System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
            }
        }

        @Override
        public void onError() {
            System.out.println("Error");
        }

        @Override
        public void onFailure(String message) {
            System.out.println("Failure: " + message);
        }

    }

    private static class UserUpdateListener implements IUserUpdateListener {

        @Override
        public void onSucess(JUser entity) {
            JUser user = entity;
            if (user != null) {
                System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
            }
        }

        @Override
        public void onError() {
            System.out.println("Error");
        }

        @Override
        public void onFailure(String message) {
            System.out.println("Failure: " + message);
        }

    }

    private static void syncCalls(JUserApiController apiController) {

        System.out.println("\n____ SYNC CALLS ____");

        System.out.println("\nRead all users --------------------------------");
        LinkedList<JUser> users = apiController.readAll();
        if (users != null) {
            users.forEach(user -> System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword()));
        } else {
            System.out.println("Error: " + apiController.getErrorMessage());
        }
        sleepTime();

        System.out.println("\nRead user -------------------------------------");
        JUser user = apiController.read(3);
        if (user != null) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
        } else {
            System.out.println("Error: " + apiController.getErrorMessage());
        }
        sleepTime();

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
        sleepTime();

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
        sleepTime();

        System.out.println("\nDelete user -----------------------------------");
        user = apiController.delete(user);
        if (user != null) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
        } else {
            System.out.println("Error: " + apiController.getErrorMessage());
        }
        sleepTime();

    }

    private static void sleepTime() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
    }

}
