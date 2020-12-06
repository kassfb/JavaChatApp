package com.example.lr4.models;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long > {
    List<User> findByUserName(String userName);
    User findById(long userId);//id?
}
