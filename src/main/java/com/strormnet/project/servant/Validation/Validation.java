package com.strormnet.project.servant.Validation;

import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.Validation.Threads.CheckAdminsPrepodavatelThread;
import com.strormnet.project.servant.Validation.Threads.GetAdminsFromDataBaseThread;
import com.strormnet.project.servant.Validation.Threads.GetPrepodavatelFromDataBaseThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Validation {

    private List<User> users = new ArrayList<>();

    private Integer login;
    private String password;
    private Semaphore semaphore = new Semaphore(100);

    public Validation(Integer login, String password) {
        this.login = login;
        this.password = password;

    }

    public synchronized <T extends User> void putUser(T user){
        users.add(user);
    }

    public <T extends User> void removeFromUser(Integer index){
        users.remove(index);
    }


    public void startValidation() throws InterruptedException {
        GetAdminsFromDataBaseThread getAdminsFromDataBaseThread = new GetAdminsFromDataBaseThread(this, semaphore);
        GetPrepodavatelFromDataBaseThread getPrepodavatelFromDataBaseThread = new GetPrepodavatelFromDataBaseThread(this, semaphore);
        CheckAdminsPrepodavatelThread checkAdminsPrepodavatelThread = new CheckAdminsPrepodavatelThread(this, semaphore);
        getAdminsFromDataBaseThread.start();
        getPrepodavatelFromDataBaseThread.start();
        System.out.println(getUsers());
        checkAdminsPrepodavatelThread.start();
        System.out.println(getUsers());
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Semaphore getSemaphore() {
//        return semaphore;
//    }
//
//    public void setSemaphore(Semaphore semaphore) {
//        this.semaphore = semaphore;
//    }
}
