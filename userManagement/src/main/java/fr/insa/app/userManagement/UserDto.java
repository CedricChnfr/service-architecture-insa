package fr.insa.app.userManagement;

public class UserDto {
    private String firstName;
    private String lastName;
    private UserStatus role; 

    // Constructeur
    public UserDto(String firstName, String lastName, UserStatus role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
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

    public UserStatus getRole() {
        return role;
    }

    public void setRole(UserStatus role) {
        this.role = role;
    }
}
