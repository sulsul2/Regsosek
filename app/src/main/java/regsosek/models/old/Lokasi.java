package regsosek.models.old;

/**
 *
 * @author zein
 */
public class Lokasi {
    private Integer provinsi;
    private Integer kabKot;
    private Integer kecamatan;
    private Integer desaKel;
    private Integer kodeSLS;
    private Integer kodeSubSLS;
    private String namaSLS;
    private String lokasiPendataan;

    /**
    * @return the provinsi
    */
    public Integer getProvinsi() {
        return provinsi;
    }

    /**
    * @param provinsi the provinsi to set
    * @throws IllegalArgumentException jika provinsi tidak berada di rentang 0-99
    */
    public void setProvinsi(Integer provinsi) throws IllegalArgumentException {
        try {
            if (provinsi < 1 || provinsi > 99) {
                throw new IllegalArgumentException("input kode dalam range 1 - 99");
            }
            this.provinsi = provinsi;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
    * @return the kabKot
    */
    public Integer getKabKot() {
        return kabKot;
    }

    /**
    * @param kabKot the kabKot to set
    */
    public void setKabKot(Integer kabKot) throws IllegalArgumentException {
        try {
            if (kabKot < 1 || kabKot > 99) {
                throw new IllegalArgumentException("input kode dalam range 1 - 99");
            }
            this.kabKot = kabKot;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
    * @return the kecamatan
    */
    public Integer getKecamatan() {
        return kecamatan;
    }

    /**
    * @param kecamatan the kecamatan to set
    */
    public void setKecamatan(Integer kecamatan) throws IllegalArgumentException {
        try {
            if (kecamatan < 1 || kecamatan > 999) {
                throw new IllegalArgumentException("input kode dalam range 1 - 999");
            }
            this.kecamatan = kecamatan;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
    * @return the desaKel
    */
    public Integer getDesaKel() {
        return desaKel;
    }

    /**
    * @param desaKel the desaKel to set
    */
    public void setDesaKel(Integer desaKel) throws IllegalArgumentException {
        try {
            if (desaKel < 1 || desaKel > 999) {
                throw new IllegalArgumentException("input kode dalam range 1 - 999");
            }
            this.desaKel = desaKel;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
    * @return the kodeSLS
    */
    public Integer getKodeSLS() {
        return kodeSLS;
    }

    /**
    * @param kodeSLS the kodeSLS to set
    */
    public void setKodeSLS(Integer kodeSLS)throws IllegalArgumentException {
        try {
            if (kodeSLS < 1 || kodeSLS > 9999) {
                throw new IllegalArgumentException("input kode dalam range 1 - 9999");
            }
            this.kodeSLS = kodeSLS;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
    * @return the kodeSubSLS
    */
    public Integer getKodeSubSLS() {
        return kodeSubSLS;
    }

    /**
    * @param kodeSubSLS the kodeSubSLS to set
    */
    public void setKodeSubSLS(Integer kodeSubSLS)throws IllegalArgumentException {
        try {
            if (kodeSubSLS < 1 || kodeSubSLS > 99) {
                throw new IllegalArgumentException("input kode dalam range 1 - 99");
            }
            this.kodeSubSLS = kodeSubSLS;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getNamaSLS(){
        return namaSLS;
    }
    /**
    * @return the lokasiPendataan
    */
    public String getLokasiPendataan() {
        return lokasiPendataan;
    }

    /**
    * @param lokasiPendataan the lokasiPendataan to set
    */
    public void setLokasiPendataan(String lokasiPendataan) {
        this.lokasiPendataan = lokasiPendataan;
    }
}
