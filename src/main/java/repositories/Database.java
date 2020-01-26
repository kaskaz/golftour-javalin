package repositories;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import models.Course;

import java.sql.SQLException;

public class Database {

    private static final String DB_URL = "jdbc:h2:mem:golftour";

    private static Database instance;
    private JdbcPooledConnectionSource connectionSource;

    private Database() throws Exception {
        try {
            this.connectionSource = new JdbcPooledConnectionSource(DB_URL);
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
    }

    public static void close() throws Exception {
        getInstance().getConnection().close();
    }

}
