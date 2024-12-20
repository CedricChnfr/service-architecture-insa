package fr.insa.app.userRequestService;

public class RequestDto {
    private String description;

    public RequestDto(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
