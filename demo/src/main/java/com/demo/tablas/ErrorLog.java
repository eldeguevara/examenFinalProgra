package com.demo.tablas;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String errorMessage;
    private String stackTrace;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "chat_message_id", nullable = true)
    private ChatMessage chatMessage;

    public ErrorLog() {}

    public ErrorLog(String errorMessage, String stackTrace, LocalDateTime timestamp, ChatMessage chatMessage) {
        this.errorMessage = errorMessage;
        this.stackTrace = stackTrace;
        this.timestamp = timestamp;
        this.chatMessage = chatMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ChatMessage getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
    }
}
