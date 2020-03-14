package dev.kaskaz.golftour.controllers;

import io.javalin.http.Context;
import dev.kaskaz.golftour.services.AccommodationsService;

public class AccommodationsController {

    public void getDetails(Context context) throws Exception {
        context.json(new AccommodationsService().getAll());
    }
}
