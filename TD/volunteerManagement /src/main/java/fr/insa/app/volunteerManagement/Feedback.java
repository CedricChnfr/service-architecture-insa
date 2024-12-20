package fr.insa.app.volunteerManagement;

public class Feedback {
    private int volunteerId;
    private int userId;
    private String comments;
    private int rating; // Note sur 5

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
