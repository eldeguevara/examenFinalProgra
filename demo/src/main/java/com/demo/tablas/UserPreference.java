package com.demo.tablas;

import jakarta.persistence.*;

@Entity
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language; // Ejemplo: "es" para español, "en" para inglés
    private String messageFrequency; // Ejemplo: "DAILY", "WEEKLY", "MONTHLY"

    @OneToOne(mappedBy = "userPreference")
    private Usuarios user;

    public UserPreference() {}

    public UserPreference(String language, String messageFrequency) {
        this.language = language;
        this.messageFrequency = messageFrequency;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getMessageFrequency() { return messageFrequency; }
    public void setMessageFrequency(String messageFrequency) { this.messageFrequency = messageFrequency; }

    public Usuarios getUser() { return user; }
    public void setUser(Usuarios user) { this.user = user; }
}
