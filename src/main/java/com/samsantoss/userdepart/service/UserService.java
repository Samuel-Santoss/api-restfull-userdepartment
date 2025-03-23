package com.samsantoss.userdepart.service;

import com.samsantoss.userdepart.exceptions.entities.Email;
import com.samsantoss.userdepart.exceptions.entities.User;
import com.samsantoss.userdepart.exceptions.UserNotFoundException;
import com.samsantoss.userdepart.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    // metodo para atualização de atualizar usuário e e-mail
    @Transactional
    public Optional<User> updateUser(Long id, User updatedUser) {
        if (updatedUser == null) {
            throw new IllegalArgumentException("Os campos não podem ser nulos.");
        }

        if (updatedUser.getEmail() == null || updatedUser.getEmail().getValue() == null) {
            throw new IllegalArgumentException("O campo email não pode ser nulo.");
        }

        return repository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(new Email(updatedUser.getEmail().getValue())); // Criação do Email
            return repository.save(user);
        });

    }
}
