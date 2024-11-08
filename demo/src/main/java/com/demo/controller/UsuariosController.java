package com.demo.controller;

import com.demo.repositorios.UserPreferenceRepository;
import com.demo.repositorios.UsuarioRepository;
import com.demo.tablas.UserPreference;
import com.demo.tablas.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UsuariosController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> guardarUsuario(@RequestBody Usuarios usuario){
        Map<String, Object> response = new HashMap<>();

        try {
            // Guardamos el usuario en la base de datos
            Usuarios savedUser = usuarioRepository.save(usuario);

            // Creamos la respuesta con el usuario guardado
            response.put("status", "success");
            response.put("message", "Usuario guardado con éxito");
            response.put("usuario", savedUser);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Hubo un error al guardar el usuario");
            return ResponseEntity.status(500).body(response);
        }
    }

    @GetMapping("/allChats")
    public ResponseEntity<Map<String, Object>> obtenerUsuariosConChats() {
        Map<String, Object> response = new HashMap<>();

        try {
            // Obtener todos los usuarios con sus mensajes de chat
            List<Usuarios> usuarios = usuarioRepository.findAll();

            // Creamos la respuesta con los usuarios y sus mensajes
            response.put("status", "success");
            response.put("message", "Usuarios obtenidos con éxito");
            response.put("usuarios", usuarios);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Hubo un error al obtener los usuarios" + e);
            return ResponseEntity.status(500).body(response);
        }
    }

    @PostMapping("/{userId}/preferences")
    public ResponseEntity<Map<String, Object>> saveUserPreferences(
            @PathVariable Long userId,
            @RequestBody UserPreference preferenceData) {

        Map<String, Object> response = new HashMap<>();
        try {
            Usuarios user = usuarioRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

            UserPreference preferences = user.getUserPreference();
            if (preferences == null) {
                preferences = new UserPreference();
                user.setUserPreference(preferences);
            }

            preferences.setLanguage(preferenceData.getLanguage());
            preferences.setMessageFrequency(preferenceData.getMessageFrequency());

            userPreferenceRepository.save(preferences);
            usuarioRepository.save(user);

            response.put("status", "success");
            response.put("message", "User preferences saved successfully");
            response.put("preferences", preferences);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Error saving user preferences: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

}
