package com.example.lr4.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String password;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице


    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        message.setUserId(this);
        messages.add(message);
    }

    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password=" + password +
                '}';
    }
}