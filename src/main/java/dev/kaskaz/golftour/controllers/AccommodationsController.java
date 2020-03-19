package dev.kaskaz.golftour.controllers;

import dev.kaskaz.golftour.controllers.dtos.CourseAccommodationsDto;
import dev.kaskaz.golftour.services.AccommodationsService;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AccommodationsController {

    public void getDetails(Context context) throws Exception {
        context.json(new AccommodationsService().getAll());
    }

    public void getNear(Context context) throws Exception {

        Set<Double> courseIds = context.bodyAsClass(Set.class);

        AccommodationsService accommodationsService = new AccommodationsService();
        List<CourseAccommodationsDto> courseAccommodationsDtos = new ArrayList<>();
        CourseAccommodationsDto courseAccommodationsDto;

        for (Double courseId : courseIds) {
            courseAccommodationsDto = new CourseAccommodationsDto();
            courseAccommodationsDto.setCourseId(courseId.intValue());
            courseAccommodationsDto.setAccommodations(Arrays.asList(
                accommodationsService.getById(1), accommodationsService.getById(2), accommodationsService.getById(3)));
            courseAccommodationsDtos.add(courseAccommodationsDto);
        }

        context.json(courseAccommodationsDtos);

    }
}
