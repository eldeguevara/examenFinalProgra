package com.demo.tablas;

import jakarta.persistence.*;

@Entity
public class WebhookConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endpointUrl;
    private boolean isActive;
    private String secretToken;

    public WebhookConfig() {}

    public WebhookConfig(String endpointUrl, boolean isActive, String secretToken) {
        this.endpointUrl = endpointUrl;
        this.isActive = isActive;
        this.secretToken = secretToken;
    }

    public Long getId() {
        return id;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public void setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getSecretToken() {
        return secretToken;
    }

    public void setSecretToken(String secretToken) {
        this.secretToken = secretToken;
    }
}
