package com.demo.controller;

import com.demo.repositorios.ChatMessageRepository;
import com.demo.repositorios.UsuarioRepository;
import com.demo.tablas.ChatMessage;
import com.demo.tablas.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatMessageController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @PostMapping("/send")
    public ResponseEntity<Map<String, Object>> sendMessage(
            @RequestParam Long userId,
            @RequestParam String messageContent,
            @RequestParam String timestamp
    ){
        Map<String, Object> response = new HashMap<>();

        Usuarios usuarios = usuarioRepository.findById(userId).orElse(null);
        if (usuarios == null) {
            response.put("error", "Usuario no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        ChatMessage chatMessage = new ChatMessage(messageContent, timestamp, usuarios);
        chatMessageRepository.save(chatMessage);

        response.put("message", "Message sent successfully");
        response.put("chatMessage", chatMessage);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
