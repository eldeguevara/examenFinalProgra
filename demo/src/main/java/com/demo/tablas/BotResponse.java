package com.demo.tablas;

import jakarta.persistence.*;

@Entity
public class BotResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String responseContent;
    private String timestamp;

    @OneToOne
    @JoinColumn(name = "chat_message_id", referencedColumnName = "id")
    private ChatMessage chatMessage;

    public BotResponse() {}

    public BotResponse(String responseContent, String timestamp, ChatMessage chatMessage) {
        this.responseContent = responseContent;
        this.timestamp = timestamp;
        this.chatMessage = chatMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public ChatMessage getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
    }
}
