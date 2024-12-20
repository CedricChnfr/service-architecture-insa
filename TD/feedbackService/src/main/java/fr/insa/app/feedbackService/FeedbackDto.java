package fr.insa.app.feedbackService;

public class FeedbackDto {
    private String comments;  // Commentaires sur l'expérience (par exemple, retour sur la tâche réalisée)
    private int rating;       // Note donnée à l'expérience, généralement entre 1 et 5

    // Constructeur
    public FeedbackDto(String comments, int rating) {
        this.comments = comments;
        this.rating = rating;
    }

    // Getters et Setters
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
