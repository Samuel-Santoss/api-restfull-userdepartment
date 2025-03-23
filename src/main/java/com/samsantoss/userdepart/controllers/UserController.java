package com.samsantoss.userdepart.controllers;



import com.samsantoss.userdepart.entities.User;
import com.samsantoss.userdepart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    //end-point para buscar todos os usuario.
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //end-point para buscar o usuario por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById (@PathVariable Long id) {
        User users = userService.getUserById(id);
        return ResponseEntity.ok(users);
    }
    

    //end-point para inserir usuarios no banco.
    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user) {
        User newUser = userService.insertUsers(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
            userService.deleteUsers(id);
            return ResponseEntity.ok("Usuário foi deletado!!");
        }

    }




