package dev.kaskaz.golftour.repositories;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import dev.kaskaz.golftour.models.Accommodation;

import java.sql.SQLException;
import java.util.List;

public class AccommodationsRepository {

    private Dao<Accommodation,Integer> accommodationDao;

    public AccommodationsRepository() throws Exception {
        accommodationDao = DaoManager
            .createDao(Database.getInstance().getConnection(), Accommodation.class);
    }

    public List<Accommodation> getAll() throws SQLException {
        return accommodationDao.queryForAll();
    }

    public Accommodation getById(int id) throws SQLException {
        return accommodationDao.queryForId(id);
    }

    public int create(Accommodation accommodation) throws SQLException {
        return accommodationDao.create(accommodation);
    }

    public int create(List<Accommodation> accommodations) throws SQLException {
        return accommodationDao.create(accommodations);
    }

}
