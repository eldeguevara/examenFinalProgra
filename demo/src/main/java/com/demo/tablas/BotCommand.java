package com.demo.tablas;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class BotCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commandName; // Ejemplos: "/help", "/info"

    @OneToMany(mappedBy = "botCommand", cascade = CascadeType.ALL)
    private List<ChatMessage> chatMessages;

    public BotCommand() {}

    public BotCommand(String commandName) {
        this.commandName = commandName;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCommandName() { return commandName; }
    public void setCommandName(String commandName) { this.commandName = commandName; }

    public List<ChatMessage> getChatMessages() { return chatMessages; }
    public void setChatMessages(List<ChatMessage> chatMessages) { this.chatMessages = chatMessages; }
}
