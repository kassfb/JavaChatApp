package com.example.lr4.models;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;

    @Column (name = "message")
    private String message;


//можно не указывать Column name, если оно совпадает с названием столбца в таблице

    //private String color;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users userId;

    public Messages() {
    }

    public Messages(String message) {
        this.message = message;
    }

    public int getMessageId() {
        return messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
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
