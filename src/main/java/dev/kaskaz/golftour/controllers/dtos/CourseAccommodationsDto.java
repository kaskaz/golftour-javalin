package dev.kaskaz.golftour.controllers.dtos;

import dev.kaskaz.golftour.models.Accommodation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CourseAccommodationsDto {

    @Getter
    @Setter
    private Integer courseId;

    @Getter
    @Setter
    private List<Accommodation> accommodations;

}
