package com.demo.services;

import com.demo.repositorios.ChatMessageRepository;
import com.demo.repositorios.ErrorLogRepository;
import com.demo.tablas.ChatMessage;
import com.demo.tablas.ErrorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BotService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public ChatMessage processMessage(ChatMessage chatMessage) {
        try {
            // Lógica del bot para procesar el mensaje
            // ...
            return chatMessageRepository.save(chatMessage);
        } catch (Exception e) {
            // Registrar el error en ErrorLog
            saveErrorLog(e, chatMessage);
            throw e; // Opcional: lanzar la excepción nuevamente si se necesita
        }
    }

    private void saveErrorLog(Exception exception, ChatMessage chatMessage) {
        String errorMessage = exception.getMessage();
        String stackTrace = getStackTraceAsString(exception);
        LocalDateTime timestamp = LocalDateTime.now();

        ErrorLog errorLog = new ErrorLog(errorMessage, stackTrace, timestamp, chatMessage);
        errorLogRepository.save(errorLog);
    }

    private String getStackTraceAsString(Exception exception) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : exception.getStackTrace()) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }
}
