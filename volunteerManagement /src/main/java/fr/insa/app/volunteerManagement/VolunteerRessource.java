package fr.insa.app.volunteerManagement;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/volunteers")  // URL de base pour ce contrôleur
public class VolunteerRessource {

    private List<Volunteer> volunteers = new ArrayList<>();
    private int currentId = 1;

    // Endpoint pour récupérer tous les bénévoles (GET)
    @GetMapping
    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    // Endpoint pour ajouter un nouveau bénévole (POST)
    @PostMapping
    public Volunteer createVolunteer(@RequestBody VolunteerDto volunteerDto) {
        Volunteer newVolunteer = new Volunteer(currentId++, volunteerDto.getFirstName(), volunteerDto.getLastName(), volunteerDto.getSkills(), volunteerDto.getAvailability());
        volunteers.add(newVolunteer);
        return newVolunteer;
    }

    // Endpoint pour désactiver un bénévole (PUT)
    @PutMapping("/{id}/deactivate")
    public Volunteer deactivateVolunteer(@PathVariable int id) {
        Volunteer volunteer = volunteers.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
        if (volunteer != null) {
            volunteer.setActive(false);
        }
        return volunteer;
    }
}
