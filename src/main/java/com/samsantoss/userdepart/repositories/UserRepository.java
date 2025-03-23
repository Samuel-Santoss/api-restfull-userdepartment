package com.samsantoss.userdepart.repositories;


import com.samsantoss.userdepart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{

}
