// package regsosek.database;

// import java.io.Serializable;
// import java.util.ArrayList;
// import java.util.List;

// import javax.swing.JOptionPane;

// // import at.favre.lib.crypto.bcrypt.BCrypt;

// import java.sql.*;

// public class Database implements Serializable {
//     public static Database database;
//     private final String DB_TYPE = "mysql";
//     private final String DB_HOST = "localhost";
//     private final String DB_PORT = "3306";
//     private final String DB_NAME = "kelduareg";
//     private final String DB_USER = "root";
//     private final String DB_PASS = "";

//     private Database() {
//     }

//     public static synchronized Database getInstance() {
//         if (database == null) {
//             database = new Database();
//         }
//         return database;
//     }

//     private Connection getConnection() throws SQLException {
//         return DriverManager.getConnection("jdbc:" + DB_TYPE + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USER,
//                 DB_PASS);
//     }
// //statusPekerjaan(DD), statusKepemilikan(DD)
//     public void insertBlok4(Penduduk pend) throws SQLException {
//         ArrayList<Anggota> anggotas = blok4.getAnggota();
//         anggotas.forEach(anggota -> {
//             try (Connection conn = getConnection()) {
//                 String insertToSQL = "INSERT INTO blok4 VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//                 try (PreparedStatement pstmt = conn.prepareStatement(insertToSQL)) {
//                     pstmt.setString(1, (String) anggota.getNoUrut().getValue());
//                     pstmt.setString(2, (String) anggota.getNama().getValue());
//                     pstmt.setString(3, (String) anggota.getNIK().getValue());
//                     pstmt.setString(4, (String) anggota.getJenisKelamin().getValue());
//                     pstmt.setString(5, (String) anggota.getHubunganKeluarga().getValue());
//                     pstmt.setInt(6, anggota.getUmur().getAngka());
//                     pstmt.setString(7, (String) anggota.getAdaGangguan().getValue());
//                     pstmt.setString(8, (String) anggota.getJenisGangguan().getValue());
//                     pstmt.setString(9, (String) anggota.getIjazah().getValue());
//                     pstmt.setString(10, (String) anggota.getAdaKerja().getValue());
//                     pstmt.setString(11, (String) anggota.getNamaLapanganKerja().getValue());
//                     pstmt.setString(12, (String) anggota.getLapanganKerja().getValue());
//                     pstmt.setString(13, (String) anggota.getStatusPekerjaan().getValue());
//                     pstmt.setString(14, (String) anggota.getAdaUsaha().getValue());
//                     pstmt.setInt(15, anggota.getJumlahUsaha().getAngka());
//                     pstmt.setString(16, (String) anggota.getNamaLapanganUsaha().getValue());
//                     pstmt.setString(17, (String) anggota.getLapanganUsaha().getValue());
//                     pstmt.setString(18, anggota.getKeyValue());
//                     pstmt.executeUpdate();
//                 } catch (SQLException e) {
//                     System.out.println(e);
//                 }
//             } catch (SQLException e) {
//                 System.out.println(e);
//             }
//         });
//     }
// }

// //     public void run(String query, List<Object> params) throws SQLException {
// //         this.queryRunner.run(getConnection(), query, params);
// //     }

// //     public void run(String query) throws SQLException {
// //         this.queryRunner.run(getConnection(), query);
// //     }

// //     public List<Map<String, Object>> query(String query, List<Object> params) throws SQLException {
// //         return this.queryRunner.query(getConnection(), query, params);
// //     }

// //     public List<Map<String, Object>> query(String query) throws SQLException {
// //         return this.queryRunner.query(getConnection(), query);
// //     }

// //     public Connection getConnection() throws SQLException {
// //         return DriverManager.getConnection(String.format(
// //             "jdbc:%s://%s:%s/%s",
// //                 DB_TYPE,
// //                 DB_HOST,
// //                 DB_PORT,
// //                 DB_NAME
// //         ), DB_USER, DB_PASS);
// //     }
// // }
