package com.demo.repositorios;

import com.demo.tablas.ChatMessage;
import com.demo.tablas.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByUsuarios(Usuarios usuarios);
}
