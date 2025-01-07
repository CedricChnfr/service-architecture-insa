package fr.insa.tp.orchestratorAction;

import java.time.LocalDateTime;

public class ActionHistory {
    private String actuator;
    private String action;
    private LocalDateTime timestamp;

    public ActionHistory(String actuator, String action, LocalDateTime timestamp) {
        this.actuator = actuator;
        this.action = action;
        this.timestamp = timestamp;
    }

    public String getActuator() {
        return actuator;
    }

    public void setActuator(String actuator) {
        this.actuator = actuator;
    }

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