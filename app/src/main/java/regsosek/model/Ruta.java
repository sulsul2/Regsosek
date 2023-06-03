package regsosek.model;

import regsosek.exception.BadUserInputException;
import java.util.List;

/**
 *
 * @author zein
 */
public class Ruta {
    private long id;
    private Lokasi lokasi;
    private JenisWilayah jenisWilayah;
    private String deskripsiJenisWilayah;
    private int noUrutBangunan;
    private int noUrutKeluarga;
    private String idLandmark;
    //private List<Penduduk> anggotaRumahTangga;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
     * @return the noUrutBangunan
     */
    public int getNoUrutBangunan() {
        return noUrutBangunan;
    }

    /**
     * @param noUrutBangunan the noUrutBangunan to set
     * @throws exception.BadUserInputException
     */
    public void setNoUrutBangunan(int noUrutBangunan) throws BadUserInputException {
        if (noUrutBangunan < 1){
            throw new BadUserInputException("Nomor urut bangunan tidak boleh negatif");
        } else
            this.noUrutBangunan = noUrutBangunan;
    }

    /**
     * @return the noUrutKeluarga
     */
    public int getNoUrutKeluarga() {
        return noUrutKeluarga;
    }

    /**
     * @param noUrutKeluarga the noUrutKeluarga to set
     * @throws exception.BadUserInputException
     */
    public void setNoUrutKeluarga(int noUrutKeluarga) throws BadUserInputException {
        if (noUrutKeluarga < 1){
            throw new BadUserInputException("Nomor urut keluarga tidak boleh negatif");
        } else
            this.noUrutKeluarga = noUrutKeluarga;
    }

    /**
     * @return the idLandmark
     */
    public String getIdLandmark() {
        return idLandmark;
    }

    /**
     * @param idLandmark the idLandmark to set
     * @throws exception.BadUserInputException
     */
    public void setIdLandmark(String idLandmark) throws BadUserInputException {
        if (idLandmark.length() != 6) {
            throw new BadUserInputException("Masukkan id landmark dengan 6 karakter yang sesuai");
        } else {
            this.idLandmark = idLandmark;
        }
    }

    /**
     * @return the jenisWilayah
     */
    public JenisWilayah getJenisWilayah() {
        return jenisWilayah;
    }

    /**
     * @param jenisWilayah the jenisWilayah to set
     */
    public void setJenisWilayah(JenisWilayah jenisWilayah) {
        this.jenisWilayah = jenisWilayah;
    }

    /**
     * @return the deskripsiJenisWilayah
     */
    public String getDeskripsiJenisWilayah() {
        return deskripsiJenisWilayah;
    }

    /**
     * @param deskripsiJenisWilayah the deskripsiJenisWilayah to set
     */
    public void setDeskripsiJenisWilayah(String deskripsiJenisWilayah) {
        this.deskripsiJenisWilayah = deskripsiJenisWilayah;
    }

    /**
     * @return the anggotaRumahTangga
     */
    /*
    public List<Penduduk> getAnggotaRumahTangga() {
        return anggotaRumahTangga;
    }

    /**
     * @param anggotaRumahTangga the anggotaRumahTangga to set
     */
    /*
    public void setAnggotaRumahTangga(List<Penduduk> anggotaRumahTangga) {
        this.anggotaRumahTangga = anggotaRumahTangga;
    }*/


}
