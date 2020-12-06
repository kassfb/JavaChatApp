package com.example.lr4.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String password;

    //@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Messages> messages;

    protected User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        //messages = new ArrayList<>();
    }

//    public void addMessage(Messages message) {
//        //message.setUserId(this);
//        message.setUserId(userId);
//        messages.add(message);
//    }
//
//    public void removeMessage(Messages message) {
//        messages.remove(message);
//    }

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

//    public List<Messages> getMessages() {
//        return messages;
//    }

//    public void setMessages(List<Messages> messages) {
//        this.messages = messages;
//    }

    @Override
    public String toString() {
        return "models.Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password=" + password +
                '}';
    }
}