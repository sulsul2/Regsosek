// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package regsosek.controller;

// import java.util.List;
// import regsosek.model.JenisWilayah;
// import regsosek.dao.Dao;
// import regsosek.dao.JenisWilayahDao;
// import regsosek.dao.RutaDao;
// import regsosek.exception.BadUserInputException;
// import javax.swing.DefaultComboBoxModel;
// import javax.swing.JOptionPane;
// import javax.swing.event.ListSelectionEvent;
// import javax.swing.table.DefaultTableModel;
// import javax.swing.table.TableModel;
// import regsosek.model.Lokasi;
// import regsosek.model.Ruta;

// /**
//  *
//  * @author zein
//  */
// public class RutaController implements Controller {

//     private final RutaFrame view;
//     private final Dao<JenisWilayah> jenisWilayahDao;
//     private final Dao<Ruta> rutaDao;

//     private long selectedRutaId;
//     private boolean disableSelect = false;

//     public RutaController() {
//         view = new RutaFrame();
//         jenisWilayahDao = new JenisWilayahDao();
//         rutaDao = new RutaDao();

//         view.getAddButton().addActionListener(e -> saveRuta());
//         view.getEditButton().addActionListener(e -> updateRuta());
//         view.getDeleteButton().addActionListener(e -> destroyRuta());
//         view.getTable().getSelectionModel().addListSelectionListener(e -> selectRuta());

//         initJenisWilayah();
//         updateTable();
//     }

//     private void saveRuta() {
//         try {
//             Ruta ruta = new Ruta();
//             Lokasi lokasi = new Lokasi();
//             JenisWilayah jenisWilayah = new JenisWilayah();

//             lokasi.setProvinsi(Integer.valueOf(view.getProvinsiTextField().getText()));
//             lokasi.setKabKot(Integer.valueOf(view.getKabKotTextField().getText()));
//             lokasi.setKecamatan(Integer.valueOf(view.getKecamatanTextField().getText()));
//             lokasi.setDesaKel(Integer.valueOf(view.getDesaKelTextField().getText()));
//             lokasi.setKodeSLS(Integer.valueOf(view.getKodeSLSTextField().getText()));
//             lokasi.setKodeSubSLS(Integer.valueOf(view.getKodeSubSLSTextField().getText()));

//             ruta.setLokasi(lokasi);

//             String[] jn = ((String) view.getJenisWilayahComboBox().getSelectedItem()).split("-");
//             if (jn.length < 2) {
//                 System.err.println("Format jenis wilayah salah.");
//                 return;
//             }

//             jenisWilayah.setId(Long.parseLong(jn[0].trim()));
//             jenisWilayah.setNama(jn[1].trim());
//             ruta.setJenisWilayah(jenisWilayah);

//             ruta.setNoUrutBangunan(Integer.parseInt(view.getNoBangunanTextField().getText()));
//             ruta.setNoUrutKeluarga(Integer.parseInt(view.getNoKeluargaTextField().getText()));
//             ruta.setIdLandmark(view.getIdLandmarkTextField().getText());

//             rutaDao.save(ruta);
//             disableSelect = true;
//             updateTable();
//             disableSelect = false;
//         } catch (BadUserInputException ex) {
//             JOptionPane.showMessageDialog(view, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//         } catch (IllegalArgumentException ex) {
//             JOptionPane.showMessageDialog(view, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//         }
//     }

//     private void updateRuta() {
//         if (this.selectedRutaId == 0) {
//             return;
//         }

//         try {
//             Ruta ruta = new Ruta();
//             Lokasi lokasi = new Lokasi();
//             JenisWilayah jenisWilayah = new JenisWilayah();

//             ruta.setId(this.selectedRutaId);

//             lokasi.setProvinsi(Integer.valueOf(view.getProvinsiTextField().getText()));
//             lokasi.setKabKot(Integer.valueOf(view.getKabKotTextField().getText()));
//             lokasi.setKecamatan(Integer.valueOf(view.getKecamatanTextField().getText()));
//             lokasi.setDesaKel(Integer.valueOf(view.getDesaKelTextField().getText()));
//             lokasi.setKodeSLS(Integer.valueOf(view.getKodeSLSTextField().getText()));
//             lokasi.setKodeSubSLS(Integer.valueOf(view.getKodeSubSLSTextField().getText()));

//             ruta.setLokasi(lokasi);

//             String[] jn = ((String) view.getJenisWilayahComboBox().getSelectedItem()).split("-");
//             if (jn.length < 2) {
//                 System.err.println("Format jenis wilayah salah.");
//                 return;
//             }

//             jenisWilayah.setId(Long.parseLong(jn[0].trim()));
//             jenisWilayah.setNama(jn[1].trim());
//             ruta.setJenisWilayah(jenisWilayah);

//             ruta.setNoUrutBangunan(Integer.parseInt(view.getNoBangunanTextField().getText()));
//             ruta.setNoUrutKeluarga(Integer.parseInt(view.getNoKeluargaTextField().getText()));
//             ruta.setIdLandmark(view.getIdLandmarkTextField().getText());

//             rutaDao.update(ruta);
//             disableSelect = true;
//             updateTable();
//             disableSelect = false;
//         } catch (BadUserInputException ex) {
//             JOptionPane.showMessageDialog(view, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//         } catch (IllegalArgumentException ex) {
//             JOptionPane.showMessageDialog(view, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//         }
//     }

//     private void destroyRuta() {
//         // TODO: tambahin dialog konfirmasi
//         rutaDao.delete(this.selectedRutaId);

//         JOptionPane.showMessageDialog(view, "Berhasil menghapus ruta!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

//         disableSelect = true;
//         updateTable();
//         disableSelect = false;
//     }

//     private void selectRuta() {
//         if (disableSelect)
//             return;

//         int row = view.getTable().getSelectedRow();
//         TableModel tm = view.getTable().getModel();

//         this.selectedRutaId = Long.parseLong((String) tm.getValueAt(row, 10));

//         view.getProvinsiTextField().setText((String) tm.getValueAt(row, 0));
//         view.getKabKotTextField().setText((String) tm.getValueAt(row, 1));
//         view.getKecamatanTextField().setText((String) tm.getValueAt(row, 2));
//         view.getDesaKelTextField().setText((String) tm.getValueAt(row, 3));
//         view.getKodeSLSTextField().setText((String) tm.getValueAt(row, 4));
//         view.getKodeSubSLSTextField().setText((String) tm.getValueAt(row, 5));
//         view.getJenisWilayahComboBox().setSelectedItem((String) tm.getValueAt(row, 6));
//         view.getNoBangunanTextField().setText((String) tm.getValueAt(row, 7));
//         view.getNoKeluargaTextField().setText((String) tm.getValueAt(row, 8));
//         view.getIdLandmarkTextField().setText((String) tm.getValueAt(row, 9));
//     }

//     private void initJenisWilayah() {
//         List<JenisWilayah> jenisWilayah = jenisWilayahDao.getAll();
//         String model[] = new String[jenisWilayah.size()];

//         for (int i = 0; i < jenisWilayah.size(); i++) {
//             model[i] = jenisWilayah.get(i).getId() + " - " + jenisWilayah.get(i).getNama();
//         }

//         view.getJenisWilayahComboBox().setModel(new DefaultComboBoxModel<>(model));
//     }

//     private void updateTable() {
//         List<Ruta> daftarRuta = rutaDao.getAll();
//         String model[][] = new String[daftarRuta.size()][11];
//         String columnNames[] = new String[] {
//             "Provinsi",
//             "Kabupaten/Kota",
//             "Kecamatan",
//             "Desa/Kelurahan",
//             "SLS",
//             "Sub SLS",
//             "Jenis Wilayah",
//             "No Bangunan",
//             "No Keluarga",
//             "ID Landmark",
//             "id"
//         };

//         for (int i = 0; i < daftarRuta.size(); i++) {
//             Ruta ruta = daftarRuta.get(i);
//             model[i][0] = String.valueOf(ruta.getLokasi().getProvinsi());
//             model[i][1] = String.valueOf(ruta.getLokasi().getKabKot());
//             model[i][2] = String.valueOf(ruta.getLokasi().getKecamatan());
//             model[i][3] = String.valueOf(ruta.getLokasi().getDesaKel());
//             model[i][4] = String.valueOf(ruta.getLokasi().getKodeSLS());
//             model[i][5] = String.valueOf(ruta.getLokasi().getKodeSubSLS());
//             model[i][6] = ruta.getJenisWilayah().getId() + " - " + ruta.getJenisWilayah().getNama();
//             model[i][7] = String.valueOf(ruta.getNoUrutBangunan());
//             model[i][8] = String.valueOf(ruta.getNoUrutKeluarga());
//             model[i][9] = ruta.getIdLandmark();
//             model[i][10] = String.valueOf(ruta.getId());
//         }

//         view.getTable().setModel(new DefaultTableModel(model, columnNames));
//         view.getTable().getColumnModel().removeColumn(view.getTable().getColumnModel().getColumn(10));
//     }

//     @Override
//     public void activate(Object[] args) {
//         // args ga dipake
//         view.setVisible(true);
//     }

//     @Override
//     public void deactivate() {
//         view.setVisible(false);
//     }
    
// }
