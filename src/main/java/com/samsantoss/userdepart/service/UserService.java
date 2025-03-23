package com.samsantoss.userdepart.service;

import com.samsantoss.userdepart.entities.User;
import com.samsantoss.userdepart.exceptions.UserNotFoundException;
import com.samsantoss.userdepart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    //metodo para buscar todos os usuarios
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    //metodo para buscar usuario individual
    public User getUserById (Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    //metodo para inserir usuarios
    public User insertUsers (User user) {
        return repository.save(user);
    }
    //metodo para deletar usuário pelo ID, com exception
    public void deleteUsers (Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }
}
