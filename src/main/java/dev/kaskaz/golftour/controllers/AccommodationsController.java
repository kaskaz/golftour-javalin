package dev.kaskaz.golftour.controllers;

import dev.kaskaz.golftour.controllers.dtos.CourseAccommodationsDto;
import dev.kaskaz.golftour.services.AccommodationsNearService;
import dev.kaskaz.golftour.services.AccommodationsService;
import dev.kaskaz.golftour.services.CoursesService;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AccommodationsController {

    public void getDetails(Context context) throws Exception {
        context.json(new AccommodationsService().getAll());
    }

    /**
     * Get accommodations near the courses provided
     *
     * Foreach course get accommodations near by criteria.
     * Search criteria can be distance, local and county.
     *
     * @param context
     * @throws Exception
     */
    public void getNear(Context context) throws Exception {

        Set<Double> courseIds = context.bodyAsClass(Set.class);

        AccommodationsNearService nearService = new AccommodationsNearService();
        CoursesService coursesService = new CoursesService();
        List<CourseAccommodationsDto> courseAccommodationsDtos = new ArrayList<>();
        CourseAccommodationsDto courseAccommodationsDto;

        for (Double courseId : courseIds) {
            courseAccommodationsDto = new CourseAccommodationsDto();
            courseAccommodationsDto.setCourseId(courseId.intValue());
            courseAccommodationsDto.setAccommodations(
                nearService.find(
                    coursesService.getById(courseId.intValue())));
            courseAccommodationsDtos.add(courseAccommodationsDto);
        }

        context.json(courseAccommodationsDtos);

    }
}
