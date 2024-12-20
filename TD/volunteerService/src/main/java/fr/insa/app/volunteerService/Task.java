package fr.insa.app.volunteerService;

public class Task {
    private int id;                  // Identifiant de la tâche
    private String description;      // Description de la tâche (par exemple, "Collecter les courses")
    private String status;           // Statut de la tâche (par exemple, "En cours", "Terminée", "Annulée")

    // Constructeur
    public Task(int id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
