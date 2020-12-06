package com.example.lr4.models;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;

    @Column (name = "message")
    private String message;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id")
    private Long userId;
    //private Users userId;

    protected Message() {
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

    //public Users getUserId() { return userId;  }
    public Long getUserId() {
        return userId;
    }
    //public void setUserId(Users userId) { this.userId = userId; }
    public void setUserId(Long userId) {
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
