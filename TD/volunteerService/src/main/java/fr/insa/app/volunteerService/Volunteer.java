package fr.insa.app.volunteerService;

import java.util.List;

public class Volunteer {
    private int id;
    private String firstName;
    private String lastName;
    private String skills;
    private String availability;
    private boolean isActive;
    private List<Task> tasksAssigned;     // Liste des tâches attribuées au bénévole
    private List<VolunteerAction> actionsHistory;  // Historique des actions réalisées par le bénévole

    // Constructeur
    public Volunteer(int id, String firstName, String lastName, String skills, String availability) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.availability = availability;
        this.isActive = true;
        this.tasksAssigned = null;  // Liste des tâches à initialiser
        this.actionsHistory = null; // Liste des actions à initialiser
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Task> getTasksAssigned() {
        return tasksAssigned;
    }

    public void setTasksAssigned(List<Task> tasksAssigned) {
        this.tasksAssigned = tasksAssigned;
    }

    public List<VolunteerAction> getActionsHistory() {
        return actionsHistory;
    }

    public void setActionsHistory(List<VolunteerAction> actionsHistory) {
        this.actionsHistory = actionsHistory;
    }
}
