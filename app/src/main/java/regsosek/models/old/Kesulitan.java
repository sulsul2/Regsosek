package regsosek.models.old;

/**
 *
 * @author zein
 */
public class Kesulitan {
    private int kesulitan;
    private int jenisKesulitan;

    public Kesulitan(int kesulitan, int jenisKesulitan) {
        this.kesulitan = kesulitan;
        this.jenisKesulitan = jenisKesulitan;
    }

    /**
     * @param jenisKesulitan
     * @return the kesulitan
     * @throws java.lang.Exception
     */
    
    //INI BELOM ADA SETTER BUAT JENIS KESULITAN AKHIRE TAK BUAT//
    
   //(zein ini hasil kodingan astri dan ninis) 
   public int getJenisKesulitan(){
    return jenisKesulitan;
   }
    public void setJenisKesulitan(int jenisKesulitan) throws Exception{
        if(jenisKesulitan<1 || jenisKesulitan>10){
            throw new Exception("Harap isi dengan angka 1 sampai 10");
        }
        this.jenisKesulitan = jenisKesulitan;
    }


    /**
     * @return the kesulitan
     */
    public int getKesulitan() {
        return kesulitan;
    }

    public void setKesulitan(int kesulitan) throws Exception{
        if(kesulitan<1 || kesulitan>4){
            throw new Exception("Harap isi dengan angka 1 sampai 4");
        }
        this.kesulitan = kesulitan;
    }
}
