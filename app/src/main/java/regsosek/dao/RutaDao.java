// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package regsosek.dao;

// import regsosek.database.Database;
// import regsosek.exception.BadUserInputException;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Map;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import regsosek.model.JenisWilayah;
// import regsosek.model.Lokasi;
// import regsosek.model.Ruta;

// /**
//  *
//  * @author zein
//  */
// public class RutaDao implements Dao<Ruta> {

//     @Override
//     public Ruta get(long id) {
//         Database db = Database.getInstance();
//         try {
//             List<Object> params = Arrays.asList(new Object[] {id});
//             List<Map<String, Object>> result = db.query("SELECT * FROM ruta WHERE id = ?", params);

//             if (!result.isEmpty()) {
//                 Map<String, Object> row = result.get(0);

//                 Ruta ruta = new Ruta();
//                 Lokasi lokasi = new Lokasi();

//                 ruta.setId((long) row.get("id"));

//                 try{
//                     lokasi.setProvinsi((int) row.get("provinsi"));
//                     lokasi.setKabKot((int) row.get("kabkot"));
//                     lokasi.setKecamatan((int) row.get("kecamatan"));
//                     lokasi.setDesaKel((int) row.get("desakel"));
//                     lokasi.setKodeSLS((int) row.get("sls"));
//                     lokasi.setKodeSubSLS((int) row.get("sub_sls"));
//                     ruta.setLokasi(lokasi);
//                 }
//                 catch(BadUserInputException e){
//                     System.out.println(e.getMessage());
//                 }

//                 Dao<JenisWilayah> dao = new JenisWilayahDao();
//                 JenisWilayah jenisWilayah = dao.get((long) row.get("jenis_wilayah_id"));
//                 ruta.setJenisWilayah(jenisWilayah);
//                 ruta.setDeskripsiJenisWilayah((String) row.get("jenis_wilayah_desc"));

//                 try{
//                     ruta.setNoUrutBangunan((int) row.get("no_bangunan"));
//                     ruta.setNoUrutKeluarga((int) row.get("no_keluarga"));
//                     ruta.setIdLandmark((String) row.get("id_landmark"));
//                 }
//                 catch (BadUserInputException e){
//                     System.out.println(e.getMessage());
//                 }

//                 return ruta;
//             } else {
//                 return null;
//             }
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return null;
//         }
//     }

//     @Override
//     public List<Ruta> getWhere(String attr, Object param) {
//         List<Ruta> filteredRuta = new ArrayList<>();
//         Database db = Database.getInstance();
//         try {
//             List<Object> params = Arrays.asList(new Object[] {param});
//             List<Map<String, Object>> result = db.query(
//                     String.format("SELECT * FROM ruta WHERE %s = ?", attr),
//                     params);

//             for (Map<String, Object> row : result) {
//                 Ruta ruta = new Ruta();
//                 Lokasi lokasi = new Lokasi();

//                 ruta.setId((long) row.get("id"));

//                 try{
//                     lokasi.setProvinsi((int) row.get("provinsi"));
//                     lokasi.setKabKot((int) row.get("kabkot"));
//                     lokasi.setKecamatan((int) row.get("kecamatan"));
//                     lokasi.setDesaKel((int) row.get("desakel"));
//                     lokasi.setKodeSLS((int) row.get("sls"));
//                     lokasi.setKodeSubSLS((int) row.get("sub_sls"));
//                     ruta.setLokasi(lokasi);
//                 }
//                 catch(BadUserInputException e){
//                     System.out.println(e.getMessage());
//                 }

//                 Dao<JenisWilayah> dao = new JenisWilayahDao();
//                 JenisWilayah jenisWilayah = dao.get((long) row.get("jenis_wilayah_id"));
//                 ruta.setJenisWilayah(jenisWilayah);
//                 ruta.setDeskripsiJenisWilayah((String) row.get("jenis_wilayah_desc"));

//                 try{
//                     ruta.setNoUrutBangunan((int) row.get("no_bangunan"));
//                     ruta.setNoUrutKeluarga((int) row.get("no_keluarga"));
//                     ruta.setIdLandmark((String) row.get("id_landmark"));
//                 }
//                 catch(BadUserInputException e){
//                     System.out.println(e.getMessage());
//                 }

//                 filteredRuta.add(ruta);
//             }

//             return filteredRuta;
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return null;
//         }
//     }

//     @Override
//     public List<Ruta> getLike(String attr, Object param) {
//         List<Ruta> filteredRuta = new ArrayList<>();
//         Database db = Database.getInstance();
//         try {
//             List<Object> params = Arrays.asList(new Object[] {param});
//             List<Map<String, Object>> result = db.query(
//                     String.format("SELECT * FROM ruta WHERE %s LIKE ?", attr),
//                     params);

//             for (Map<String, Object> row : result) {
//                 Ruta ruta = new Ruta();
//                 Lokasi lokasi = new Lokasi();

//                 ruta.setId((long) row.get("id"));

//                 lokasi.setProvinsi((int) row.get("provinsi"));
//                 lokasi.setKabKot((int) row.get("kabkot"));
//                 lokasi.setKecamatan((int) row.get("kecamatan"));
//                 lokasi.setDesaKel((int) row.get("desakel"));
//                 lokasi.setKodeSLS((int) row.get("sls"));
//                 lokasi.setKodeSubSLS((int) row.get("sub_sls"));
//                 ruta.setLokasi(lokasi);

//                 Dao<JenisWilayah> dao = new JenisWilayahDao();
//                 JenisWilayah jenisWilayah = dao.get((long) row.get("jenis_wilayah_id"));
//                 ruta.setJenisWilayah(jenisWilayah);
//                 ruta.setDeskripsiJenisWilayah((String) row.get("jenis_wilayah_desc"));

//                 ruta.setNoUrutBangunan((int) row.get("no_bangunan"));
//                 ruta.setNoUrutKeluarga((int) row.get("no_keluarga"));
//                 ruta.setIdLandmark((String) row.get("id_landmark"));

//                 filteredRuta.add(ruta);
//             }

//             return filteredRuta;
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return null;
//         } catch(BadUserInputException e){
//             System.out.println(e.getMessage());
//             return null;
//         }
//     }

//     @Override
//     public List<Ruta> getAll() {
//         List<Ruta> daftarRuta = new ArrayList<>();
//         Database db = Database.getInstance();
//         try {
//             List<Map<String, Object>> result = db.query("SELECT * FROM ruta");
//             for (Map<String, Object> row : result) {
//                 Ruta ruta = new Ruta();
//                 Lokasi lokasi = new Lokasi();

//                 ruta.setId((long) row.get("id"));

//                 lokasi.setProvinsi((int) row.get("provinsi"));
//                 lokasi.setKabKot((int) row.get("kabkot"));
//                 lokasi.setKecamatan((int) row.get("kecamatan"));
//                 lokasi.setDesaKel((int) row.get("desakel"));
//                 lokasi.setKodeSLS((int) row.get("sls"));
//                 lokasi.setKodeSubSLS((int) row.get("sub_sls"));
//                 ruta.setLokasi(lokasi);

//                 Dao<JenisWilayah> dao = new JenisWilayahDao();
//                 JenisWilayah jenisWilayah = dao.get((long) row.get("jenis_wilayah_id"));
//                 ruta.setJenisWilayah(jenisWilayah);
//                 ruta.setDeskripsiJenisWilayah((String) row.get("jenis_wilayah_desc"));

//                 ruta.setNoUrutBangunan((int) row.get("no_bangunan"));
//                 ruta.setNoUrutKeluarga((int) row.get("no_keluarga"));
//                 ruta.setIdLandmark((String) row.get("id_landmark"));

//                 daftarRuta.add(ruta);
//             }
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return new ArrayList<>();
//         } catch(BadUserInputException e){
//             System.out.println(e.getMessage());
//             return new ArrayList<>();
//         }

//         return daftarRuta;
//     }

//     @Override
//     public void save(Ruta t) {
//         Database db = Database.getInstance();
//         List<Object> params = Arrays.asList(new Object[]{
//             t.getLokasi().getProvinsi(),
//             t.getLokasi().getKabKot(),
//             t.getLokasi().getKecamatan(),
//             t.getLokasi().getDesaKel(),
//             t.getLokasi().getKodeSLS(),
//             t.getLokasi().getKodeSubSLS(),
//             t.getJenisWilayah().getId(),
//             t.getDeskripsiJenisWilayah(),
//             t.getNoUrutBangunan(),
//             t.getNoUrutKeluarga(),
//             t.getIdLandmark()
//         });

//         try {
//             db.run("INSERT INTO ruta (provinsi, kabkot, kecamatan, desakel, sls, sub_sls, jenis_wilayah_id, jenis_wilayah_desc, no_bangunan, no_keluarga, id_landmark) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", params);
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//         }
//     }

//     @Override
//     public void update(Ruta t) {
//         Database db = Database.getInstance();
//         List<Object> params = Arrays.asList(new Object[] {
//             t.getLokasi().getProvinsi(),
//             t.getLokasi().getKabKot(),
//             t.getLokasi().getKecamatan(),
//             t.getLokasi().getDesaKel(),
//             t.getLokasi().getKodeSLS(),
//             t.getLokasi().getKodeSubSLS(),
//             t.getJenisWilayah().getId(),
//             t.getDeskripsiJenisWilayah(),
//             t.getNoUrutBangunan(),
//             t.getNoUrutKeluarga(),
//             t.getIdLandmark(),
//             t.getId()
//         });

//         try {
//             db.run("UPDATE ruta SET provinsi = ?, kabkot = ?, kecamatan = ?, desakel = ?, sls = ?, sub_sls = ?, jenis_wilayah_id = ?, jenis_wilayah_desc = ?, no_bangunan = ?, no_keluarga = ?, id_landmark = ? WHERE id = ?", params);
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//         }
//     }

//     @Override
//     public void delete(long id) {
//         Database db = Database.getInstance();
//         List<Object> params = Arrays.asList(new Object[]{id});
//         try {
//             db.run("DELETE FROM ruta WHERE id = ?", params);
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//         }
//     }
    
// }
