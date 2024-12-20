package fr.insa.app.volunteerService;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerRessource {

    private List<Volunteer> volunteers = new ArrayList<>();
    private int currentId = 1;

    @PostMapping
    public Volunteer createVolunteer(@RequestBody VolunteerDto volunteerDto) {
        Volunteer newVolunteer = new Volunteer(currentId++, volunteerDto.getFirstName(), volunteerDto.getLastName(), volunteerDto.getSkills(), volunteerDto.getAvailability());
        volunteers.add(newVolunteer);
        return newVolunteer;
    }

    @GetMapping("/{id}")
    public Volunteer getVolunteer(@PathVariable int id) {
        return volunteers.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    @PostMapping("/{id}/assignTask")
    public Volunteer assignTaskToVolunteer(@PathVariable int id, @RequestBody Task task) {
        Volunteer volunteer = getVolunteer(id);
        if (volunteer != null) {
            volunteer.getTasksAssigned().add(task);
        }
        return volunteer;
    }

    @PostMapping("/{id}/action")
    public Volunteer recordVolunteerAction(@PathVariable int id, @RequestBody VolunteerAction action) {
        Volunteer volunteer = getVolunteer(id);
        if (volunteer != null) {
            volunteer.getActionsHistory().add(action);
        }
        return volunteer;
    }
}
