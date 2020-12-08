package com.example.lr4.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
//@Component
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column (name = "message")
    private String message;


//можно не указывать Column name, если оно совпадает с названием столбца в таблице

    //private String color;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public Long getMessageId() {
        return messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "models.Messages{" +
                "messageId=" + messageId +
                "message=" + message +
                "userId=" + userId +
                '}';
    }
}
