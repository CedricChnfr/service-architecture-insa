package fr.insa.app.volunteerService;

public class VolunteerAction {
    private String actionDescription;  // Description de l'action (par exemple, "Aide avec les courses")
    private String timestamp;          // Date et heure de l'action (en format String, peut être amélioré en Date ou LocalDateTime)

    // Constructeur
    public VolunteerAction(String actionDescription, String timestamp) {
        this.actionDescription = actionDescription;
        this.timestamp = timestamp;
    }

    // Getters et Setters
    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
