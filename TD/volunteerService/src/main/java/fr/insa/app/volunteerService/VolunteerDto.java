package fr.insa.app.volunteerService;

public class VolunteerDto {
    private String firstName;  // Prénom du bénévole
    private String lastName;   // Nom de famille du bénévole
    private String skills;     // Compétences du bénévole
    private String availability;  // Disponibilité du bénévole (par exemple, "Weekends", "Monday to Friday")

    // Constructeur
    public VolunteerDto(String firstName, String lastName, String skills, String availability) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.availability = availability;
    }

    // Getters et Setters
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
}
