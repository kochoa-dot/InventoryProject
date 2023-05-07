package com.inventory.Inventory.exception;


public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(Integer id_user){
        super("Could not found the User with id " + id_user);
    }
}
