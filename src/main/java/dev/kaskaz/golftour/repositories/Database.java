package dev.kaskaz.golftour.repositories;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dev.kaskaz.golftour.models.Accommodation;
import dev.kaskaz.golftour.models.Course;
import dev.kaskaz.golftour.AppProperties;

import java.sql.SQLException;

public class Database {

    private static final String DB_URL = "database.url";

    private static Database instance;
    private JdbcPooledConnectionSource connectionSource;

    private Database() throws Exception {
        try {
            String dbUrl = AppProperties.getProperties().getProperty(DB_URL);
            this.connectionSource = new JdbcPooledConnectionSource(dbUrl);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public static Database getInstance() throws Exception {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null)
                    instance = new Database();
            }
        }
        return instance;
    }

    public ConnectionSource getConnection() {
        return this.connectionSource;
    }

    public static void init() throws Exception {
        Database database = getInstance();

        TableUtils.createTable(database.getConnection(), Course.class);
        TableUtils.createTable(database.getConnection(), Accommodation.class);
    }

    public static void close() throws Exception {
        getInstance().getConnection().close();
    }

}
