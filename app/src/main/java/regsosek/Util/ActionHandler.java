package regsosek.Util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import regsosek.models.old.Penduduk;
import regsosek.models.old.Ruta;

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
                appManager.ruta.getLokasi().setProvinsi(appManager.ui.provinsiTextField.getText());
                appManager.ruta.getLokasi().setKabKot(appManager.ui.kabKotTextField.getText());
                appManager.ruta.getLokasi().setKecamatan(appManager.ui.kecamatanTextField.getText());
                appManager.ruta.getLokasi().setDesaKel(appManager.ui.desaKelTextField.getText());
                appManager.ruta.getLokasi().setKodeSLS(appManager.ui.slsTextField.getText());
                appManager.ruta.getLokasi().setKodeSubSLS(appManager.ui.subSlsTextField.getText());
                appManager.ruta.getLokasi().setNamaSLS(appManager.ui.namaSlsTextField.getText());
                appManager.ruta.getLokasi().setLokasiPendataan(appManager.ui.lokasiPendataanTextField.getText());
                appManager.ruta.setKelompokKeluarga(appManager.ui.kelKeluargaTextField.getText());
                appManager.ruta.setKepalaKeluarga(appManager.ui.namaKepalaKeluargaTextField.getText());
                appManager.ruta.setNoUrutBangunan(appManager.ui.urutBangunanTextField.getText());
                appManager.ruta.setNoUrutKeluarga(appManager.ui.urutKelTextField.getText());
                appManager.ruta.setIdLandmark(appManager.ui.landmarkTextField.getText());
                appManager.routing.showScreen(3);
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
                    appManager.penduduk.setNoUrut(appManager.ui.noUrutTextField.getText());
                    appManager.penduduk.setNama(appManager.ui.namaTextField.getText());
                    appManager.penduduk.setNIK(appManager.ui.nikTextField.getText());
                    if(appManager.ui.jenisKelaminDropdown.getSelectedItem().equals("(1) Laki-laki")){
                        appManager.penduduk.setJenisKelamin(1);
                    } else {
                        appManager.penduduk.setJenisKelamin(2);
                    }
                    appManager.penduduk.setUsia(appManager.ui.umurTextField.getText());
                    appManager.penduduk.setStatusKepala(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()));
                    String temp[] = ((String) appManager.ui.gKesulitanDropdown.getSelectedItem()).split(".");
                    appManager.penduduk.getKesulitan().setKesulitan(Integer.parseInt(temp[0]));
                    appManager.penduduk.getKesulitan().setJenisKesulitan(appManager.ui.jGangguanTextField.getText());
                    String temp1[] =((String) appManager.ui.ijazahDropdown.getSelectedItem()).split(".");
                    appManager.penduduk.setPendidikanTertinggi(Integer.parseInt(temp1[0]));
                    String temp2[] =((String) appManager.ui.statKerjaDropdown.getSelectedItem()).split(".");
                    appManager.penduduk.getPekerjaan().setStatusBekerja(Integer.parseInt(temp2[0]));
                    appManager.penduduk.getPekerjaan().setLapanganUsaha(appManager.ui.jLapanganTextField.getText());
                    appManager.penduduk.getPekerjaan().setStatusKependudukan(Integer.parseInt(appManager.ui.statKedTextField.getText()));
                    String temp3[] =((String) appManager.ui.statMilikDropdown.getSelectedItem()).split(".");
                    appManager.penduduk.getUsaha().setStatusKepemilikan(Integer.parseInt(temp3[0]));
                    appManager.penduduk.getUsaha().setJumlahUsaha(appManager.ui.jUsahaTextField.getText());
                    appManager.penduduk.getUsaha().setLapanganUsaha(appManager.ui.lUsahaTextField.getText());
                    appManager.ruta.addAnggotaRumahTangga(appManager.penduduk);
                } catch(Exception error) {
                    
                }
                appManager.changePenduduk();
                appManager.routing.showScreen(3);
                break;
            case "selesai":
                try{
                    appManager.penduduk.setNoUrut(appManager.ui.noUrutTextField.getText());
                    appManager.penduduk.setNama(appManager.ui.namaTextField.getText());
                    appManager.penduduk.setNIK(appManager.ui.nikTextField.getText());
                    if(appManager.ui.jenisKelaminDropdown.getSelectedItem().equals("(1) Laki-laki")){
                        appManager.penduduk.setJenisKelamin(1);
                    } else {
                        appManager.penduduk.setJenisKelamin(2);
                    }
                    appManager.penduduk.setUsia(appManager.ui.umurTextField.getText());
                    appManager.penduduk.setStatusKepala(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()));
                    String temp[] = ((String) appManager.ui.gKesulitanDropdown.getSelectedItem()).split(".");
                    appManager.penduduk.getKesulitan().setKesulitan(Integer.parseInt(temp[0]));
                    appManager.penduduk.getKesulitan().setJenisKesulitan(appManager.ui.jGangguanTextField.getText());
                    String temp1[] =((String) appManager.ui.ijazahDropdown.getSelectedItem()).split(".");
                    appManager.penduduk.setPendidikanTertinggi(Integer.parseInt(temp1[0]));
                    String temp2[] =((String) appManager.ui.statKerjaDropdown.getSelectedItem()).split(".");
                    appManager.penduduk.getPekerjaan().setStatusBekerja(Integer.parseInt(temp2[0]));
                    appManager.penduduk.getPekerjaan().setLapanganUsaha(appManager.ui.jLapanganTextField.getText());
                    appManager.penduduk.getPekerjaan().setStatusKependudukan(Integer.parseInt(appManager.ui.statKedTextField.getText()));
                    String temp3[] =((String) appManager.ui.statMilikDropdown.getSelectedItem()).split(".");
                    appManager.penduduk.getUsaha().setStatusKepemilikan(Integer.parseInt(temp3[0]));
                    appManager.penduduk.getUsaha().setJumlahUsaha(appManager.ui.jUsahaTextField.getText());
                    appManager.penduduk.getUsaha().setLapanganUsaha(appManager.ui.lUsahaTextField.getText());
                    appManager.ruta.addAnggotaRumahTangga(appManager.penduduk);
                } catch(Exception error) {
                    
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
