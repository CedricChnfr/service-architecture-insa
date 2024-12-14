package fr.insa.app.feedbackService;

public class Feedback {
    private int volunteerId;  // ID du bénévole qui a effectué la tâche
    private int userId;       // ID de l'utilisateur qui donne le feedback
    private String comments;  // Commentaires laissés par l'utilisateur
    private int rating;       // Note donnée à l'expérience, sur 5

    // Constructeur
    public Feedback(int volunteerId, int userId, String comments, int rating) {
        this.volunteerId = volunteerId;
        this.userId = userId;
        this.comments = comments;
        this.rating = rating;
    }

    // Getters et Setters
    public int getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(int volunteerId) {
        this.volunteerId = volunteerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
