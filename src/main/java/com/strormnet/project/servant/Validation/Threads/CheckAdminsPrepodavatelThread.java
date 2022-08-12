package com.strormnet.project.servant.Validation.Threads;

import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.Validation.Validation;

import java.util.Optional;
import java.util.concurrent.Semaphore;


public class CheckAdminsPrepodavatelThread extends Thread {

    private Validation validation;
    private Boolean didUFind = false;
    private Boolean notFound = false;
    private Semaphore semaphore;

    public CheckAdminsPrepodavatelThread(Validation validation, Semaphore semaphore) {
        this.validation = validation;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!didUFind && !notFound) {
                try {
                    User user = validation.getUsers()
                            .stream()
                            .filter(gen -> gen.getPhoneNumber().equals(validation.getLogin()) && gen.getPassword().equals(validation.getPassword()))
                            .findAny().get();
                    Optional.ofNullable(user).ifPresentOrElse(gen -> {
                        validation.setFoundedUser(user);
                        didUFind = true;
                    }, () -> didUFind = false);
                } catch (Exception e) {
                    System.out.println("Пользователь не найден");
                    notFound = true;
                    break;
                }
                }
            }



    public Boolean getNotFound() {
        return notFound;
    }

    public Boolean getDidUFind() {
        return didUFind;
    }
}

//    public Optional<Prepodavatel> test(){
//       return Optional.ofNullable(validation.getPrepodavatels()
//                .stream()
//                .filter(gen -> gen.getPhoneNumber().equals(validation.getLogin()) && gen.getPassword().equals(validation.getPassword()))
//                .findAny().get());
//    }
//    public Admin testAdmin(){
//        return validation.getAdmins()
//                .stream()
//                .filter(gen -> gen.getPhoneNumber().equals(validation.getLogin()) && gen.getPassword().equals(validation.getPassword()))
//                .findAny().get();
//    }



