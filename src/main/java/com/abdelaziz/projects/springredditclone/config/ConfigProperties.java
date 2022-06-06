package com.abdelaziz.projects.springredditclone.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Configuration
@PropertySource("${spring.profiles.active}/application.properties")
@ConfigurationProperties(prefix = "app.notification")
public class ConfigProperties {
    private String emailFrom;
    private Map<String, String[]> emailTemplateReplacements;

    public ConfigProperties() {
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public Map<String, String[]> getEmailTemplateReplacements() {
        return emailTemplateReplacements;
    }

    public void setEmailTemplateReplacements(Map<String, String[]> emailTemplateReplacements) {
        this.emailTemplateReplacements = emailTemplateReplacements;
    }
}
