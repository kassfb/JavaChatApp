package com.example.lr4.models;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<Messages, Integer> {
    Messages findById(int messageId);
}
