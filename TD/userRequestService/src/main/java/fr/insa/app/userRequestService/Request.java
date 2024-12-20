package fr.insa.app.userRequestService;

public class Request {
    private Long id;
    private String description;
    private RequestStatus status;

    // Constructeurs
    public Request(Long id, String description, RequestStatus status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
