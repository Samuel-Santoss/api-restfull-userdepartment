package com.samdev.userdepart.repositories;


import com.samdev.userdepart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{

}
