// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package regsosek.dao;

// import java.util.Arrays;
// import java.util.List;
// import regsosek.model.JenisWilayah;
// import regsosek.database.Database;
// import java.util.Map;
// import java.sql.SQLException;
// import java.util.ArrayList;

// /**
//  *
//  * @author zein
//  */
// public class JenisWilayahDao implements Dao<JenisWilayah> {

//     @Override
//     public JenisWilayah get(long id) {
//         Database db = Database.getInstance();
//         try {
//             List<Object>    params           = Arrays.asList(new Object[] {id});
//             List<Map<String, Object>> result = db.query("SELECT * FROM jenis_wilayah WHERE id = ?", params);

//             if (!result.isEmpty()) {
//                 JenisWilayah wilayah = new JenisWilayah();
//                 Map<String, Object> row = result.get(0);

//                 wilayah.setId((long) row.get("id"));
//                 wilayah.setNama((String) row.get("nama"));

//                 return wilayah;
//             } else {
//                 return null;
//             }
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return null;
//         }
//     }

//     @Override
//     public List<JenisWilayah> getWhere(String attr, Object param) {
//         List<JenisWilayah> filteredWilayah = new ArrayList<>();
//         Database db = Database.getInstance();
//         try {
//             List<Object> params = Arrays.asList(new Object[] {param});
//             List<Map<String, Object>> result = db.query(
//                     String.format("SELECT * FROM jenis_wilayah WHERE %s = ?", attr),
//                     params);

//             for (Map<String, Object> row : result) {
//                 JenisWilayah wilayah = new JenisWilayah();
//                 wilayah.setId((long) row.get("id"));
//                 wilayah.setNama((String) row.get("nama"));

//                 filteredWilayah.add(wilayah);
//             }

//             return filteredWilayah;
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return null;
//         }
//     }

//     @Override
//     public List<JenisWilayah> getLike(String attr, Object param) {
//         List<JenisWilayah> filteredWilayah = new ArrayList<>();
//         Database db = Database.getInstance();
//         try {
//             List<Object> params = Arrays.asList(new Object[] {param});
//             List<Map<String, Object>> result = db.query(
//                     String.format("SELECT * FROM jenis_wilayah WHERE %s LIKE ?", attr),
//                     params);

//             for (Map<String, Object> row : result) {
//                 JenisWilayah wilayah = new JenisWilayah();
//                 wilayah.setId((long) row.get("id"));
//                 wilayah.setNama((String) row.get("nama"));

//                 filteredWilayah.add(wilayah);
//             }

//             return filteredWilayah;
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return null;
//         }
//     }

//     @Override
//     public List<JenisWilayah> getAll() {
//         List<JenisWilayah> wilayah = new ArrayList<>();
//         Database db = Database.getInstance();
//         try {
//             List<Map<String, Object>> result = db.query("SELECT * FROM jenis_wilayah");
//             for (Map<String, Object> row : result) {
//                 JenisWilayah w = new JenisWilayah();
//                 w.setId((long) row.get("id"));
//                 w.setNama((String) row.get("nama"));

//                 wilayah.add(w);
//             }
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return new ArrayList<>();
//         }

//         return wilayah;
//     }

//     @Override
//     public void save(JenisWilayah t) {
//         Database db = Database.getInstance();
//         List<Object> params = Arrays.asList(new Object[]{
//             t.getNama(),
//         });

//         try {
//             db.run("INSERT INTO jenis_wilayah (nama) VALUES (?)", params);
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//         }
//     }

//     @Override
//     public void update(JenisWilayah t) {
//         Database db = Database.getInstance();
//         List<Object> params = Arrays.asList(new Object[] {
//             t.getNama(),
//             t.getId()
//         });

//         try {
//             db.run("UPDATE jenis_wilayah SET nama = ? WHERE id = ?", params);
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//         }
//     }

//     @Override
//     public void delete(long id) {
//         Database db = Database.getInstance();
//         List<Object> params = Arrays.asList(new Object[]{id});
//         try {
//             db.run("DELETE FROM jenis_wilayah WHERE id = ?", params);
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//         }
//     }
    
// }
