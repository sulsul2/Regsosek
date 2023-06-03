package regsosek.models.old;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zein
 */
public class Ruta implements Model {
    private long id;
    private Lokasi lokasi;
    private String kelompokKeluarga;
    private String kepalaKeluarga;
    private int noUrutBangunan;
    private int noUrutKeluarga;
    private String idLandmark;
    private List<Penduduk> anggotaRumahTangga;

    public Ruta() {}
    public Ruta(long id) {
        this.id = id;
    }

    @Override
    public String getInsertStatement() {
        return "INSERT INTO ruta (provinsi, kabkot, kecamatan, desakel, sls, nama_sls, lokasi_data"
                + "kelompok_keluarga, kepala_keluarga, no_bangunan, no_keluarga, id_landmark) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void prepareInsertStatement(PreparedStatement pstmt) throws SQLException {
        pstmt.setInt(1, getLokasi().getProvinsi());//kode ragu
        pstmt.setInt(2, getLokasi().getKabKot());
        pstmt.setInt(3, getLokasi().getKecamatan());
        pstmt.setInt(4, getLokasi().getDesaKel());
        pstmt.setString(5, getLokasi().getKodeSLS() + "-" + getLokasi().getKodeSubSLS()); //belum ada gui
        pstmt.setString(6, getLokasi().getNamaSLS()); //belum ada setter belum ada gui
        pstmt.setString(7, getLokasi().getLokasiPendataan());//belum ada gui
        pstmt.setString(8, kelompokKeluarga);//ganti jenis wilayah
        pstmt.setString(9, kepalaKeluarga);//belum ada gui
        pstmt.setInt(10, noUrutBangunan);
        pstmt.setInt(11, noUrutKeluarga);
        pstmt.setString(12, idLandmark);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void save() throws SQLException {
        this.id = Database.getInstance().save(this);
        for (Penduduk art : anggotaRumahTangga) {
            art.setRutaId(this.id);
            art.save();
        }
    }

    public static List<Ruta> getAll() throws SQLException {
        List<Ruta> daftarRuta = new ArrayList<>();

        try (Connection con = Database.getInstance().getConnection()) {
            Statement stmt = con.createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM ruta")) {
                while(rs.next()) {
                    Ruta ruta = new Ruta(rs.getLong("id"));
                    Lokasi lok = new Lokasi();

                    lok.setProvinsi(rs.getInt("provinsi"));
                    lok.setKabKot(rs.getInt("kabkot"));
                    lok.setKecamatan(rs.getInt("kecamatan"));
                    lok.setDesaKel(rs.getInt("desakel"));

                    String[] sls = rs.getString("sls").split("-");
                    if (sls.length != 2) {
                        throw new SQLException("Failed parsing sls");
                    }

                    lok.setKodeSLS(Integer.valueOf(sls[0]));
                    lok.setKodeSubSLS(Integer.valueOf(sls[1]));

                    ruta.setLokasi(lok);
                    ruta.setKelompokKeluarga(rs.getString("kelompok_keluarga"));
                    ruta.setNoUrutBangunan(rs.getInt("no_bangunan"));
                    ruta.setNoUrutKeluarga(rs.getInt("no_keluarga"));
                    ruta.setIdLandmark(rs.getString("id_landmark"));

                    ruta.setAnggotaRumahTangga(Penduduk.getAll(rs.getLong("id")));

                    daftarRuta.add(ruta);
                }
            }
        }

        return daftarRuta;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the lokasi
     */
    public Lokasi getLokasi() {
        return lokasi;
    }

    /**
     * @param lokasi the lokasi to set
     */
    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    /**
     * @return the kelompokKeluarga
     */
    public String getKelompokKeluarga() {
        return kelompokKeluarga;
    }

    /**
     * @param kelompokKeluarga the kelompokKeluarga to set
     */
    public void setKelompokKeluarga(String kelompokKeluarga) {
        this.kelompokKeluarga = kelompokKeluarga;
    }
    public String isKepalaKeluarga() {
        return kepalaKeluarga;
    }

    /**
     * @param kepalaKeluarga the kepalaKeluarga to set
     */
    public void setKepalaKeluarga(String kepalaKeluarga) {
        this.kepalaKeluarga = kepalaKeluarga;
    }
    /**
     * @return the noUrutBangunan
     */
    public int getNoUrutBangunan() {
        return noUrutBangunan;
    }

    /**
     * @param noUrutBangunan the noUrutBangunan to set
     */
    public void setNoUrutBangunan(int noUrutBangunan) {
        try{
        if (noUrutBangunan < 1){
            throw new IllegalArgumentException("Nomor urut bangunan tidak boleh negatif");
        } else this.noUrutBangunan = noUrutBangunan;}
        catch(IllegalArgumentException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    /**
     * @return the noUrutKeluarga
     */
    public int getNoUrutKeluarga() {
        return noUrutKeluarga;
    }

    /**
     * @param noUrutKeluarga the noUrutKeluarga to set
     */
    public void setNoUrutKeluarga(int noUrutKeluarga) {
        try{
        if (noUrutKeluarga < 1){
            throw new IllegalArgumentException("Nomor urut keluarga tidak boleh negatif");
        } else this.noUrutKeluarga = noUrutKeluarga;}
        catch(IllegalArgumentException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    /**
     * @return the idLandmark
     */
    public String getIdLandmark() {
        return idLandmark;
    }

    /**
     * @param idLandmark the idLandmark to set
     */
    public void setIdLandmark(String idLandmark) {
        try{
          if (idLandmark.length() != 6) {
            throw new IllegalArgumentException("Masukkan id landmark dengan 6 karakter yang sesuai");
        } else {
            this.idLandmark = idLandmark;
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    /**
     * @return the anggotaRumahTangga
     */
    public List<Penduduk> getAnggotaRumahTangga() {
        return anggotaRumahTangga;
    }

    /**
     * @param anggotaRumahTangga the anggotaRumahTangga to set
     */
    public void setAnggotaRumahTangga(List<Penduduk> anggotaRumahTangga) {
        this.anggotaRumahTangga = anggotaRumahTangga;
    }


}
