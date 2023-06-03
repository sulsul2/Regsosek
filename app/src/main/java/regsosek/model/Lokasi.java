package regsosek.model;

import regsosek.exception.BadUserInputException;

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
    private String lokasiPendataan;

    /**
    * @return the provinsi
    */
    public Integer getProvinsi() {
        return provinsi;
    }

    /**
    * @param provinsi the provinsi to set
     * @throws exception.BadUserInputException
    * @throws IllegalArgumentException jika provinsi tidak berada di rentang 0-99
    */
    public void setProvinsi(Integer provinsi) throws BadUserInputException {
        if (provinsi < 1 || provinsi > 99) {
            throw new BadUserInputException("input kode dalam range 1 - 99");
        }
        this.provinsi = provinsi;
    }

    /**
    * @return the kabKot
    */
    public Integer getKabKot() {
        return kabKot;
    }

    /**
    * @param kabKot the kabKot to set
     * @throws exception.BadUserInputException
    */
    public void setKabKot(Integer kabKot) throws BadUserInputException {
        if (kabKot < 1 || kabKot > 99) {
            throw new BadUserInputException("input kode dalam range 1 - 99");
        }
        this.kabKot = kabKot;
    }

    /**
    * @return the kecamatan
    */
    public Integer getKecamatan() {
        return kecamatan;
    }

    /**
    * @param kecamatan the kecamatan to set
     * @throws exception.BadUserInputException
    */
    public void setKecamatan(Integer kecamatan) throws BadUserInputException {
        if (kecamatan < 1 || kecamatan > 999) {
            throw new BadUserInputException("input kode dalam range 1 - 999");
        }
        this.kecamatan = kecamatan;
    }

    /**
    * @return the desaKel
    */
    public Integer getDesaKel() {
        return desaKel;
    }

    /**
    * @param desaKel the desaKel to set
     * @throws exception.BadUserInputException
    */
    public void setDesaKel(Integer desaKel) throws BadUserInputException {
        if (desaKel < 1 || desaKel > 999) {
            throw new BadUserInputException("input kode dalam range 1 - 999");
        }
        this.desaKel = desaKel;
    }

    /**
    * @return the kodeSLS
    */
    public Integer getKodeSLS() {
        return kodeSLS;
    }

    /**
    * @param kodeSLS the kodeSLS to set
     * @throws exception.BadUserInputException
    */
    public void setKodeSLS(Integer kodeSLS)throws BadUserInputException {
        if (kodeSLS < 1 || kodeSLS > 9999) {
            throw new BadUserInputException("input kode dalam range 1 - 9999");
        }
        this.kodeSLS = kodeSLS;
    }

    /**
    * @return the kodeSubSLS
    */
    public Integer getKodeSubSLS() {
        return kodeSubSLS;
    }

    /**
    * @param kodeSubSLS the kodeSubSLS to set
     * @throws exception.BadUserInputException
    */
    public void setKodeSubSLS(Integer kodeSubSLS) throws BadUserInputException {
        if (kodeSubSLS < 1 || kodeSubSLS > 99) {
            throw new BadUserInputException("input kode dalam range 1 - 99");
        }
        this.kodeSubSLS = kodeSubSLS;
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
