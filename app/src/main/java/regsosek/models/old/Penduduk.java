package regsosek.models.old;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zein
 */
public class Penduduk implements Model {
    private int id;
    private int rutaId;
    private String noUrut;
    private String NIK;
    private String nama;
    private int jenisKelamin;
    private int statusKepala;
    private String usia;
    private Kesulitan kesulitan;
    private int pendidikanTertinggi;
    private Pekerjaan pekerjaan;
    private Usaha usaha;

    public Penduduk() {}
    public Penduduk(int id) {
        this.id = id;
    }

    @Override
    public String getInsertStatement() {
        return "INSERT INTO penduduk (ruta_id, no_urut, nik, nama,"
                + "jenis_kelamin, status_kepala,"
                + "usia, kesulitan, jenis_kesulitan, pendidikan, status_kerja,"
                + "lapangan_usaha, status_kedudukan, kepemilikan, jumlah_usaha, usaha_utama)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public void prepareInsertStatement(PreparedStatement pstmt) throws SQLException {
        
        pstmt.setInt(1, rutaId);
        pstmt.setString(2, noUrut);
        pstmt.setString(3, NIK);
        pstmt.setString(4, nama);
        pstmt.setInt(5, jenisKelamin);
        pstmt.setInt(8, statusKepala);
        pstmt.setString(8, usia);
        pstmt.setInt(13, kesulitan.getKesulitan());
        if (kesulitan.getKesulitan() != 4) {
            pstmt.setString(9, kesulitan.getJenisKesulitan());
        } else {
            pstmt.setNull(9, Types.VARCHAR);
        }
        pstmt.setInt(10, pendidikanTertinggi);
        pstmt.setInt(16, pekerjaan.getStatusBekerja());
        if (pekerjaan.getStatusBekerja() != 2) {
            pstmt.setString(11, pekerjaan.getLapanganUsaha());
            pstmt.setString(12, pekerjaan.getStatusKependudukan());
        } else {
            pstmt.setNull(11, Types.VARCHAR);
            pstmt.setNull(12, Types.VARCHAR);
        }
        pstmt.setInt(19, usaha.getStatusKepemilikan());
        if (usaha.getStatusKepemilikan()!= 2) {
            pstmt.setString(13, usaha.getJumlahUsaha());
            pstmt.setString(14, usaha.getLapanganUsaha());
        } else {
            pstmt.setInt(13, 0);
            pstmt.setNull(14, Types.VARCHAR);
        }
    }

        // pstmt.setInt(1,loc.getProvinsi()); //kode masih ragu 
        // pstmt.setInt(2,loc.getKabKot());//
        // pstmt.setInt(3, loc.getKecamatan());//
        // pstmt.setInt(4, loc.getDesaKel());//
        // pstmt.setInt(5, loc.getKodeSLS());// belum ada gui
        // pstmt.setInt(6, loc.getKodeSubSLS());// belum ada gui
        // pstmt.setString(7, loc.getLokasiPendataan());// belum ada gui, bawah ini harusnya jenis wilayah
        // pstmt.setInt(8, noUrut);//kode masih ragu
        // pstmt.setString(9, NIK);
        // pstmt.setString(10, nama);//belum ada gui
        // pstmt.setInt(11, jenisKelamin);
        // pstmt.setInt(12, usia);
        // pstmt.setInt(13, kesulitan.getKesulitan());
        // pstmt.setInt(14, kesulitan.getJenisKesulitan());//kode masih ragu dan perlu di if null
        // pstmt.setInt(15, pendidikanTertinggi);
        // pstmt.setInt(16, pekerjaan.getStatusBekerja());//belum ada setter dan jika tidak ada langsung status kepemilikan
        // pstmt.setString(17, pekerjaan.getLapanganUsaha());
        // pstmt.setString(18, pekerjaan.getStatusKependudukan());
        // pstmt.setInt(19, usaha.getStatusKepemilikan());//belum ada setter 
        // pstmt.setString(20, );
        // // if (pekerjaan != null) {
        // //     pstmt.setString(11, pekerjaan.getLapanganUsaha());
        // //     pstmt.setString(12, pekerjaan.getStatusKependudukan());
        // // } else {
        // //     pstmt.setNull(11, Types.VARCHAR);
        // //     pstmt.setNull(12, Types.VARCHAR);
        // // }

        // if (usaha != null) {
        //     pstmt.setInt(13, usaha.getJumlahUsaha());
        //     pstmt.setString(14, String.valueOf(usaha.getLapanganUsaha()));
        // } else {
        //     pstmt.setInt(13, 0);
        //     pstmt.setNull(14, Types.VARCHAR);
        // }
    //}

    @Override
    public void save() throws SQLException {
        Database.getInstance().save(this);
    }

    public static List<Penduduk> getAll(int ruta_id) throws SQLException {
        List<Penduduk> art = new ArrayList<>();
        try (Connection con = Database.getInstance().getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM penduduk WHERE ruta_id=?");
            pstmt.setLong(1, ruta_id);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Penduduk penduduk = new Penduduk(rs.getInt("id"));
                    
                    penduduk.setRutaId(ruta_id);
                    penduduk.setNoUrut(rs.getString("no_urut"));
                    penduduk.setNIK(rs.getString("nik"));
                    penduduk.setNama(rs.getString("nama"));
                    penduduk.setJenisKelamin(rs.getInt("jenis_kelamin"));
                    penduduk.setStatusKepala(rs.getInt("status_kepala"));
                    penduduk.setUsia(rs.getString("usia"));

                    art.add(penduduk);
                }
            } catch(Exception err) {
                System.out.println("Error: " + err);
            }
        }

        return art;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the rutaId
     */
    public long getRutaId() {
        return rutaId;
    }

    /**
     * @return the noUrut
     */
    public String getNoUrut() {
        return noUrut;
    }

 /**
     * @param noUrut the noUrut to set
     * @throws java.lang.Exception
     */
    
    public void setNoUrut(String noUrut) throws Exception {
         try {
                if (noUrut.length() != 3) {
                    throw new Exception("Harap isi Nomor Urut Anggota Keluarga dengan 3 digit angka");
                   }
            this.noUrut = noUrut;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the NIK
     */
    public String getNIK() {
        return NIK;
    }

/**
     * @param NIK the NIK to set
     * @throws java.lang.Exception
     */
    
    public void setNIK(String NIK) throws Exception {
        try {
                if (NIK.length() != 16) {
                    throw new Exception("Harap isi NIK dengan 16 digit angka");
                }
            this.NIK = NIK;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the jenisKelamin
     */
    public int isJenisKelamin() {
        return jenisKelamin;
    }

 /**
     * @param jenisKelamin the jenisKelamin to set
     * @throws java.lang.Exception
     */
    
    public void setJenisKelamin(int jenisKelamin) throws Exception {
        this.jenisKelamin = jenisKelamin;
    }

    /**
     * @return the statusKepala
     */
    public int getStatusKepala() {
        return statusKepala;
    }

    /**
     * @param statusKepala the statusKepala to set
     * @throws java.lang.Exception
     */
    
    public void setStatusKepala(int statusKepala) throws Exception {
        this.statusKepala = statusKepala;
    }

    /**
     * @return the usia
     */
    public String getUsia() {
        return usia;
    }

/**
     * @param usia the usia to set
     * @throws java.lang.Exception
     */
    
    public void setUsia(String usia) throws Exception {
        try {
                if (Integer.parseInt(usia)<1 || Integer.parseInt(usia)>99) {
                    throw new Exception("Harap isi Usia dengan 2 digit angka");
                }
            this.usia = usia;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the kesulitan
     */
    public Kesulitan getKesulitan() {
        return kesulitan;
    }

/**
     * @param kesulitan the kesulitan to set
     * @throws java.lang.Exception
     */
    
    public void setKesulitan(Kesulitan kesulitan) throws Exception {
        // try {
        //      if (kesulitan.getKesulitan()< 5) {
        //         throw new Exception("Usia harus lebih dari 5 tahun");
        //     } 
        //     this.kesulitan = kesulitan;
        //     } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        this.kesulitan = kesulitan;
       
    }

    /**
     * @return the pendidikanTertinggi
     */
    public int getPendidikanTertinggi() {
        return pendidikanTertinggi;
    }

 /**
     * @param pendidikanTertinggi the pendidikanTertinggi to set
     * @throws java.lang.Exception
     */
    
    public void setPendidikanTertinggi(int pendidikanTertinggi) throws Exception{
        try {
            //  if (usia< 5) {
            //     throw new Exception("Usia harus lebih dari 5 tahun");
            //  }
             if (pendidikanTertinggi>5||pendidikanTertinggi<1){
                    throw new Exception("Harap isi Pendidikan Tertinggi dengan angka 1 sampai 5");
            }
             
            this.pendidikanTertinggi = pendidikanTertinggi;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the pekerjaan
     */
    public Pekerjaan getPekerjaan() {
        return pekerjaan;
    }

 /**
     * @param pekerjaan the pekerjaan to set
     * @throws java.lang.Exception
     */
    
    public void setPekerjaan(Pekerjaan pekerjaan) throws Exception {
      try {
            //  if (usia< 5) {
            //     throw new Exception("Usia harus lebih dari 5 tahun");
            // }
            this.pekerjaan = pekerjaan;
             
            } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    /**
     * @return the usaha
     */
    public Usaha getUsaha() {
        return usaha;
    }

  /**
     * @param usaha the usaha to set
     * @throws java.lang.Exception
     */
    
    public void setUsaha(Usaha usaha) throws Exception {
        // try {
        //      if (usia< 5) {
        //         throw new Exception("Usia harus lebih dari 5 tahun");
        //      }
        //     this.usaha = usaha;
        //     } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }  
        this.usaha = usaha;
    }

    /**
     * @return the kepalaKeluarga
     */

    /**
     * @param rutaId the rutaId to set
     */
    public void setRutaId(int rutaId) {
        this.rutaId = rutaId;
    }

}
