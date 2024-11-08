package com.demo.tablas;

import jakarta.persistence.*;

@Entity
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String messageContent;
    private String timestamp;

    @ManyToOne
    private  Usuarios usuarios;

    @ManyToOne
    private MessageTopic topic;

    @ManyToOne
    @JoinColumn(name = "bot_command_id")
    private BotCommand botCommand;

    public ChatMessage(){}

    public ChatMessage(String messageContent, String timestamp, Usuarios usuarios, MessageTopic topic) {
        this.messageContent = messageContent;
        this.timestamp = timestamp;
        this.usuarios = usuarios;
        this.topic = topic;
    }


    public BotCommand getBotCommand() {
        return botCommand;
    }

    public void setBotCommand(BotCommand botCommand) {
        this.botCommand = botCommand;
    }

    public MessageTopic getTopic() {
        return topic;
    }

    public void setTopic(MessageTopic topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
