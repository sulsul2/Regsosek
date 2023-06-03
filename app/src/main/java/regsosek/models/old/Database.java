package regsosek.models.old;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 * TODO:
 * Buat method getAll, getWhere yang dapat dipakai untuk tabel manapun, return ResultSet.
 * Nanti kelas2 Model dapat memanggil method tersebut dan parse hasil dari ResultSet.
 * Saat baca ResultSet gunakan syntax try (ResultSet rs = Database.getAll()).
 * @author zein
 */
public class Database implements Serializable {
    private static Database instance;

    private final String DB_TYPE = "mysql";
    private final String DB_HOST = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "coba";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public int save(Model model) throws SQLException {
        int id = 1;
        String generatedColumns[] = { "id" };

        try (Connection con = getConnection()) {
            try (PreparedStatement pstmt = con.prepareStatement(model.getInsertStatement(), generatedColumns)) {
                model.prepareInsertStatement(pstmt);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 1) {
                    // get generated id
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            id = rs.getInt(1);
                        }
                    }
                }
            }
        }

        return id;
    }

    public List<Ruta> getAllRuta() {
        return new ArrayList<>();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(String.format(
            "jdbc:%s://%s:%s/%s",
                DB_TYPE,
                DB_HOST,
                DB_PORT,
                DB_NAME
        ), DB_USER, DB_PASS);
    }
}
