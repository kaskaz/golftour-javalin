package dev.kaskaz.golftour.services;

import dev.kaskaz.golftour.models.Accommodation;
import dev.kaskaz.golftour.models.Course;

import java.util.List;
import java.util.stream.Collectors;

public class AccommodationsNearService {

    public List<Accommodation> find(Course course) throws Exception {
        return new AccommodationsService().getAll()
            .stream()
            .filter(accommodation -> accommodation.getLocal().equals(course.getLocal()))
            .collect(Collectors.toList());
    }
}
