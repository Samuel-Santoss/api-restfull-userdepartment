package com.samdev.userdepart.exceptions;



public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Nenhum usuário encontrado com o ID: "+ id);
    }

}
