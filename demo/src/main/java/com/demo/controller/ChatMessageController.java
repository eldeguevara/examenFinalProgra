package com.demo.controller;

import com.demo.repositorios.BotCommandRepository;
import com.demo.repositorios.ChatMessageRepository;
import com.demo.repositorios.MessageTopicRepository;
import com.demo.repositorios.UsuarioRepository;
import com.demo.tablas.BotCommand;
import com.demo.tablas.ChatMessage;
import com.demo.tablas.MessageTopic;
import com.demo.tablas.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatMessageController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private MessageTopicRepository messageTopicRepository;

    @Autowired
    private BotCommandRepository botCommandRepository;

    @PostMapping("/send")
    public ResponseEntity<Map<String, Object>> enviarMensaje(
            @RequestParam Long userId,
            @RequestParam Long topicId,
            @RequestBody Map<String, Object> payload) {

        Map<String, Object> response = new HashMap<>();

        try {
            Usuarios usuario = usuarioRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            MessageTopic topic = messageTopicRepository.findById(topicId).orElseThrow(() -> new RuntimeException("Tema no encontrado"));

            String messageContent = (String) payload.get("messageContent");
            ChatMessage mensaje = new ChatMessage(messageContent, String.valueOf(System.currentTimeMillis()), usuario, topic);

            chatMessageRepository.save(mensaje);

            response.put("status", "success");
            response.put("message", "Mensaje enviado con éxito");
            response.put("chatMessage", mensaje);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Error al enviar el mensaje: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

}
