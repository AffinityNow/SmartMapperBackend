package com.smartmapper.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(Long id) {
        super("Utilisateur non trouvé " + id);
    }
    
}
