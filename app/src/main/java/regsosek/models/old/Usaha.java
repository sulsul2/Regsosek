package regsosek.models.old;

/**
 *
 * @author zein
 */
public class Usaha {
    private int jumlahUsaha;
    private int lapanganUsaha;
    private int statusKepemilikan;

    /**
     * @return the jumlahUsaha
     */
    public int getJumlahUsaha() {
        return jumlahUsaha;
    }

    /**
     * @param jumlahUsaha the jumlahUsaha to set
     * @throws java.lang.Exception
     */
    
    //(zein ini hasil kodingan astri dan ninis tapi masih bingung cara ngakses lenght int)
    public void setJumlahUsaha(int jumlahUsaha) throws Exception {
        if (jumlahUsaha<1 || jumlahUsaha>99) {
            throw new Exception("Harap isi Lapangan Usaha dengan 2 digit angka");
        }
        this.jumlahUsaha = jumlahUsaha;
    }

    /**
     * @return the lapanganUsaha
     */
    public int getLapanganUsaha() {
        return lapanganUsaha;
    }

     /**
     * @param lapanganUsaha the lapanganUsaha to set
     * @throws java.lang.Exception
     */
    
    //(zein ini hasil kodingan astri dan ninis)
    public void setLapanganUsaha(int lapanganUsaha) throws Exception {
        try {
                if (lapanganUsaha<01||lapanganUsaha>26){
                    throw new Exception("Harap isi Lapangan Usaha dengan angka 01 sampai 26");
                
            }
            this.lapanganUsaha = lapanganUsaha;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getStatusKepemilikan(){
        return statusKepemilikan;
    }
}
