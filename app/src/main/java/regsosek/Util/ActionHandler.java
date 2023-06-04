package regsosek.Util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import regsosek.models.old.Kesulitan;
import regsosek.models.old.Lokasi;
import regsosek.models.old.Pekerjaan;
import regsosek.models.old.Penduduk;
import regsosek.models.old.Ruta;
import regsosek.models.old.Usaha;

public class ActionHandler implements ActionListener{
    AppManager appManager;

    public ActionHandler(AppManager appManager){
        this.appManager = appManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String command = e.getActionCommand();

        switch (command){
            case "page-1":
                appManager.routing.showScreen(0);
                break;
            case "page-2":
                appManager.routing.showScreen(1);
                break;
            case "page-3":
                appManager.routing.showScreen(2);
                break;
            case "page-4":
                appManager.routing.showScreen(3);
                Lokasi loc = new Lokasi();
                appManager.ruta.setLokasi(loc);
                appManager.ruta.getLokasi().setProvinsi((String) appManager.ui.provinsiTextField.getText());
                appManager.ruta.getLokasi().setKabKot((String) appManager.ui.kabKotTextField.getText());
                appManager.ruta.getLokasi().setKecamatan((String) appManager.ui.kecamatanTextField.getText());
                appManager.ruta.getLokasi().setDesaKel((String) appManager.ui.desaKelTextField.getText());
                appManager.ruta.getLokasi().setKodeSLS(appManager.ui.slsTextField.getText());
                appManager.ruta.getLokasi().setKodeSubSLS(appManager.ui.subSlsTextField.getText());
                appManager.ruta.getLokasi().setNamaSLS(appManager.ui.namaSlsTextField.getText());
                appManager.ruta.getLokasi().setLokasiPendataan(appManager.ui.lokasiPendataanTextField.getText());
                appManager.ruta.setKelompokKeluarga(appManager.ui.kelKeluargaTextField.getText());
                appManager.ruta.setKepalaKeluarga(appManager.ui.namaKepalaKeluargaTextField.getText());
                appManager.ruta.setNoUrutBangunan(appManager.ui.urutBangunanTextField.getText());
                appManager.ruta.setNoUrutKeluarga(appManager.ui.urutKelTextField.getText());
                appManager.ruta.setIdLandmark(appManager.ui.landmarkTextField.getText());
                System.out.println("asu");
                System.out.println(appManager.ruta.getKelompokKeluarga());
                System.out.println("Komeng");
                // try {
                //     appManager.ruta.save();
                // } catch (SQLException e1) {
                    
                // }
                // System.out.println("Komengsev");
                break;
            case "page-5":
                appManager.routing.showScreen(4);
                break;
            case "page-6":
                appManager.routing.showScreen(5);
                break;
            case "page-7":
                appManager.routing.showScreen(6);
                break;
            case "Isi Lagi":
                try{
                    System.out.println("Komeng");
                    appManager.penduduk.setNoUrut(appManager.ui.noUrutTextField.getText());
                    System.out.println("Komeng1");
                    appManager.penduduk.setNama(appManager.ui.namaTextField.getText());
                    appManager.penduduk.setNIK(appManager.ui.nikTextField.getText());
                    if(appManager.ui.jenisKelaminDropdown.getSelectedItem().equals("1. Laki-laki")){
                        appManager.penduduk.setJenisKelamin(1);
                    } else {
                        appManager.penduduk.setJenisKelamin(2);
                    }
                    appManager.penduduk.setUsia(appManager.ui.umurTextField.getText());
                    appManager.penduduk.setStatusKepala(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()));
                    int temp =  appManager.ui.gKesulitanDropdown.getSelectedIndex();
                    Kesulitan kes = new Kesulitan();
                    kes.setKesulitan(temp+1);
                    kes.setJenisKesulitan(appManager.ui.jGangguanTextField.getText());
                    appManager.penduduk.setKesulitan(kes);
                    int temp1 = appManager.ui.ijazahDropdown.getSelectedIndex();
                    appManager.penduduk.setPendidikanTertinggi(temp1+1);
                    Pekerjaan pek = new Pekerjaan();                  
                    int temp2 = appManager.ui.statKerjaDropdown.getSelectedIndex();
                    pek.setStatusBekerja(temp2 + 1);
                    pek.setLapanganUsaha(appManager.ui.jLapanganTextField.getText());
                    pek.setStatusKependudukan(Integer.parseInt(appManager.ui.statKedTextField.getText()));
                    appManager.penduduk.setPekerjaan(pek);
                    System.out.println("Komeng3");
                    Usaha us = new Usaha();
                    int temp3 = appManager.ui.statMilikDropdown.getSelectedIndex();
                    System.out.println(temp3);
                    us.setStatusKepemilikan(temp3+1);
                    System.out.println("Komengkepala");
                    us.setJumlahUsaha(appManager.ui.jUsahaTextField.getText());
                    System.out.println("komengsulit");
                    us.setLapanganUsaha(appManager.ui.lUsahaTextField.getText());
                    System.out.println("komengsulit2");
                    appManager.penduduk.setUsaha(us);
                    System.out.println("komeng4");
                    appManager.ruta.addAnggotaRumahTangga(appManager.penduduk);
                    System.out.println("Komenglas");
                    System.out.println(appManager.penduduk.getNama());
                    System.out.println(appManager.ruta.getNoUrutKeluarga());
                    System.out.println("komengsevetheday");
                } catch(Exception error) {
                    // System.out.println(error.getMessage());
                }
                appManager.changePenduduk();
                appManager.routing.showScreen(3);
                break;
            case "selesai":
                try{
                    System.out.println("Komeng");
                    appManager.penduduk.setNoUrut(appManager.ui.noUrutTextField.getText());
                    System.out.println("Komeng1");
                    appManager.penduduk.setNama(appManager.ui.namaTextField.getText());
                    appManager.penduduk.setNIK(appManager.ui.nikTextField.getText());
                    if(appManager.ui.jenisKelaminDropdown.getSelectedItem().equals("1. Laki-laki")){
                        appManager.penduduk.setJenisKelamin(1);
                    } else {
                        appManager.penduduk.setJenisKelamin(2);
                    }
                    appManager.penduduk.setUsia(appManager.ui.umurTextField.getText());
                    appManager.penduduk.setStatusKepala(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()));
                    int temp =  appManager.ui.gKesulitanDropdown.getSelectedIndex();
                    Kesulitan kes = new Kesulitan();
                    kes.setKesulitan(temp+1);
                    kes.setJenisKesulitan(appManager.ui.jGangguanTextField.getText());
                    appManager.penduduk.setKesulitan(kes);
                    int temp1 = appManager.ui.ijazahDropdown.getSelectedIndex();
                    appManager.penduduk.setPendidikanTertinggi(temp1+1);
                    Pekerjaan pek = new Pekerjaan();                  
                    int temp2 = appManager.ui.statKerjaDropdown.getSelectedIndex();
                    pek.setStatusBekerja(temp2 + 1);
                    pek.setLapanganUsaha(appManager.ui.jLapanganTextField.getText());
                    pek.setStatusKependudukan(Integer.parseInt(appManager.ui.statKedTextField.getText()));
                    appManager.penduduk.setPekerjaan(pek);
                    System.out.println("Komeng3");
                    Usaha us = new Usaha();
                    int temp3 = appManager.ui.statMilikDropdown.getSelectedIndex();
                    System.out.println(temp3);
                    us.setStatusKepemilikan(temp3+1);
                    System.out.println("Komengkepala");
                    us.setJumlahUsaha(appManager.ui.jUsahaTextField.getText());
                    System.out.println("komengsulit");
                    us.setLapanganUsaha(appManager.ui.lUsahaTextField.getText());
                    System.out.println("komengsulit2");
                    appManager.penduduk.setUsaha(us);
                    System.out.println("komeng4");
                    appManager.ruta.addAnggotaRumahTangga(appManager.penduduk);
                    System.out.println("Komenglas");
                    System.out.println(appManager.penduduk.getNama());
                    System.out.println(appManager.ruta.getNoUrutKeluarga());
                    appManager.ruta.save();
                    System.out.println("komengsevetheday");
                } catch(Exception error) {
                    // System.out.println(error.getMessage());
                }
                Ruta ruta = new Ruta();
                appManager.setRuta(ruta);
                appManager.changePenduduk();
                appManager.ui.clearField();
                appManager.routing.showScreen(0);
                break;
        }
    }
    
}
