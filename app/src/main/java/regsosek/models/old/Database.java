package regsosek.models.old;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
    private final String DB_NAME = "kelduareg";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:" + DB_TYPE + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USER,
                DB_PASS);
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

    public int register(User user) throws SQLException{
        int id = 1;
        String generatedColumns[] = {"id"};

        try (Connection con = getConnection()){
            String viewSql = String.format("SELECT * FROM user WHERE user.username = '%s'", user.getUsername());
            try (Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(viewSql)) {
                    if (!rs.next()) {
                        try (PreparedStatement pstmt = con.prepareStatement(user.getInsertStatement(), generatedColumns)) {
                            user.prepareInsertStatement(pstmt);

                            int affectedRows = pstmt.executeUpdate();
                            if (affectedRows == 1) {
                                // get generated id
                                try (ResultSet rst = pstmt.getGeneratedKeys()) {
                                    if (rst.next()) {
                                        id = rst.getInt(1);
                                    }
                                }
                            }
                        }catch(SQLException e){
                            System.out.println(e);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Username sudah digunakan!");
                        id = -1;
                    }
                }catch(SQLException e){
                    System.out.println(e);
                }
            }catch(SQLException e){
                System.out.println(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return id;
    }

    public User login(String username, String pass) throws SQLException{
        User curr = null;
        try (Connection conn = getConnection()) {
            String viewSQL = String.format("SELECT * FROM user WHERE user.username = '%s'", username);
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(viewSQL)) {
                    if (rs.next()) {
                        if(pass.equals(rs.getString("pass"))){
                            curr = new User(username, pass);
                            curr.setId(rs.getInt("id"));
                            curr.setRole(rs.getString("role"));
                        }else {
                            JOptionPane.showMessageDialog(null, "Password Salah!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Akun tidak ditemukan!");
                    }
                    return curr;
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return curr;
    }

    public List<String[]> getDataPengisi() throws SQLException {
        List<String[]> data = new ArrayList<String[]>();
        try (Connection conn = getConnection()) {
            String viewSQL = "SELECT username, count(user.id) FROM user INNER JOIN penduduk ON user.id=penduduk.user_id GROUP BY user.id";
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(viewSQL)) {
                    while (rs.next()) {
                        data.add(new String[] { rs.getString(1), rs.getString(2)});
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
}
