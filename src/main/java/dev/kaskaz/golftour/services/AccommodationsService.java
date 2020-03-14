package dev.kaskaz.golftour.services;

import dev.kaskaz.golftour.models.Accommodation;
import dev.kaskaz.golftour.repositories.AccommodationsRepository;

import java.sql.SQLException;
import java.util.List;

public class AccommodationsService {

    private AccommodationsRepository accommodationsRepository;

    public AccommodationsService() throws Exception {
        accommodationsRepository = new AccommodationsRepository();
    }

    public List<Accommodation> getAll() throws SQLException {
        return accommodationsRepository.getAll();
    }

    public Accommodation getById(int id) throws SQLException {
        return accommodationsRepository.getById(id);
    }

    public int create(Accommodation accommodation) throws SQLException {
        return accommodationsRepository.create(accommodation);
    }

    public int create(List<Accommodation> accommodations) throws SQLException {
        return accommodationsRepository.create(accommodations);
    }

}
