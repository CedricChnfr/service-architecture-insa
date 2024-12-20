package fr.insa.tp.windowsManagement;

import java.time.LocalDateTime;

public class WindowAction {

    private String action;
    private LocalDateTime timestamp; 

    // Constructeurs
    public WindowAction(String action, LocalDateTime timestamp) {
        this.action = action;
        this.timestamp = timestamp;
    }

    // Getters et setters
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
