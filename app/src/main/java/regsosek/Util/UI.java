package regsosek.Util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class UI {
    private AppManager appManager;
    public JFrame window;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];
    public JComboBox<String> jenisKelaminDropdown, jwilayahTextDropdown, gKesulitanDropdown, jGangguanDropdown, ijazahDropdown, statKerjaDropdown, jLapanganDropdown, statKedDropdown, statMilikDropdown, jUsahaDropdown, lUsahaDropdown;
    public JLabel provinsiLabel, kabKotLabel, kecamatanLabel, desaKelLabel, noUrutLabel, nikLabel, umurLabel, jenisKelaminLabel, jwilayahLabel, urutBangunanLabel, urutKelLabel, landmarkLabel, gKesulitanLabel, jGangguanLabel, ijazahLabel, statKerjaLabel, addKerjaLabel, jLapanganLabel, jLapangAddLabel, statKedLabel,statKedAddLabel, statMilikLabel, jUsahaLabel, lUsahaLabel, lUsahaAddLabel;
    public JTextField provinsiTextField, kabKotTextField, kecamatanTextField, desaKelTextField, noUrutTextField, nikTextField, umurTextField, urutBangunanTextField, urutKelTextField, landmarkTextField;


    public UI(AppManager appManager){
        this.appManager = appManager;
        createMainField();
        generateScreen();
        // inputField1();
        // inputField2();
        // inputField3();
        // inputField4();
        // inputField5();
        // inputField6();
        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(1920*3/4, 1080*3/4);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(null);
        window.setLayout(null);
        window.setResizable(false);
    }

    public void createBackgroundFull(int bgNum, String bgPath) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(0, 0, 1920*3/4, 1080*3/4);
        bgPanel[bgNum].setBackground(Color.black);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 1920*3/4, 1080*3/4);

        ImageIcon bgIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(bgPath)).getImage()
                .getScaledInstance(1920*3/4, 1080*3/4, Image.SCALE_SMOOTH));
        bgLabel[bgNum].setIcon(bgIcon);
        // bgPanel[bgNum].setVisible(false);
    }

    public void generateScreen() {
        // Start
        // createBackgroundFull(0, "bg.png");
        // createBackgroundFull(1, "bg.png");
        // createBackgroundFull(2, "bg.png");
        // createBackgroundFull(3, "bg.png");
        // createBackgroundFull(4, "bg.png");
        // createBackgroundFull(5, "bg.png");
        inputField1();
        inputField2();
        inputField3();
        inputField4();
        inputField5();
        inputField6();
    }

    public JLabel createLabel(int bgNum, int x, int y, int width, int height, String text, int size){
        JLabel newLabel = new JLabel(text);
        newLabel.setLayout(null);
        newLabel.setBounds(x, y, width, height);
        newLabel.setFont(new Font("Helvetica", Font.PLAIN, size));

        bgPanel[bgNum].add(newLabel);

        return newLabel;
    }

    public JTextField createTextField(int bgNum, int x, int y, int width, int height, int size, int column){
        JTextField newTextField = new JTextField(column) {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                RoundRectangle2D roundedRect = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, height, height);
                g2.setColor(Color.WHITE);
                g2.draw(roundedRect);
                
                g2.setPaint(getBackground());
                g2.fill(roundedRect);

                g2.dispose();
                super.paintComponent(g);
            }
        };

        newTextField.setBounds(x, y, width, height);
        newTextField.setFont(new Font(newTextField.getFont().getName(), newTextField.getFont().getStyle(), size));
        newTextField.setBorder(BorderFactory.createEmptyBorder());
        newTextField.setOpaque(false);
        newTextField.setBackground(Color.WHITE);

        bgPanel[bgNum].add(newTextField);

        return newTextField;
    }

    public void clearField() {
        appManager.ui.provinsiTextField.setText(null); 
        appManager.ui.kabKotTextField.setText(null);
        appManager.ui.kecamatanTextField.setText(null);
        appManager.ui.desaKelTextField.setText(null);
        appManager.ui.noUrutTextField.setText(null);
        appManager.ui.nikTextField.setText(null);
        appManager.ui.nikTextField.setText(null);       
        appManager.ui.umurTextField.setText(null);
        appManager.ui.urutBangunanTextField.setText(null);
        appManager.ui.urutKelTextField.setText(null);
        appManager.ui.landmarkTextField.setText(null);
    }

    public JComboBox<String> createDropdown(int bgNum, int x, int y, int width, int height, int size, String[] isi){
        JComboBox<String> newDropdown = new JComboBox<String>(isi);
        newDropdown.setBounds(x, y, width, height);
        newDropdown.setFont(new Font(newDropdown.getFont().getName(),newDropdown.getFont().getStyle(),size));

        bgPanel[bgNum].add(newDropdown);

        return newDropdown;
    }

    public void button(int bgNum, int x, int y, int width, int height, String text, String command) {
        JButton btn = new JButton(text) {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int arcSize = Math.min(width, height); 

                Shape border = new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arcSize, arcSize);
                g2.setStroke(new BasicStroke(2));
                g2.setColor(Color.WHITE);
                g2.draw(border);

                g2.setPaint(getBackground()); 
                g2.fill(border);

                g2.dispose();
                super.paintComponent(g);
            }
        };

        btn.setBounds(x, y, width, height);
        btn.setText(text);
        btn.setFont(new Font("Helvetica", Font.PLAIN, 20));
        btn.setForeground(Color.BLACK);
        btn.setBackground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.addActionListener(appManager.actionHandler);
        btn.setActionCommand(command);
        btn.setBorderPainted(false);
        btn.setOpaque(false);
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setForeground(Color.GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setForeground(Color.BLACK);
            }
        });
        bgPanel[bgNum].add(btn, 0);
    }

    public void inputField1(){
        createBackgroundFull(0, "bg.png");
        provinsiTextField = createTextField(0, 600, 203, 500, 40, 40, 16);
        kabKotTextField = createTextField(0, 600, 303, 500, 40, 40, 16);
        kecamatanTextField = createTextField(0, 600, 403, 500, 40, 40, 16);
        desaKelTextField = createTextField(0, 600, 503, 500, 40, 40, 16);
        provinsiLabel = createLabel(0, 260, 203, 500, 40, "Provinsi", 40);
        kabKotLabel = createLabel(0, 260, 303, 500, 40, "Kabupaten/Kota", 40);
        provinsiLabel = createLabel(0, 260, 403, 500, 40, "Kecamatan", 40);
        kabKotLabel = createLabel(0, 260, 503, 500, 40, "Desa/Kelurahan", 40);
        button(0, 1000, 600, 200, 50, "Selanjutnya >", "page-2");

        bgPanel[0].add(bgLabel[0]);
        bgPanel[0].setVisible(false);
    }   
    
    public void inputField2(){
        createBackgroundFull(1, "bg.png");
        noUrutTextField = createTextField(1, 600, 203, 500, 40, 40, 16);
        nikTextField = createTextField(1, 600, 303, 500, 40, 40, 16);
        jenisKelaminDropdown = createDropdown(1, 600, 403, 500, 40, 30, new String[]{"Laki-laki", "Perempuan"});
        // TextField = createTextField(0, 600, 403, 500, 40, 40, 16);
        umurTextField = createTextField(1, 600, 503, 500, 40, 40, 16);
        noUrutLabel = createLabel(1, 260, 203, 500, 40, "No Urut", 40);
        nikLabel = createLabel(1, 260, 303, 500, 40, "NIK", 40);
        jenisKelaminLabel = createLabel(1, 260, 403, 500, 40, "Jenis Kelamin", 40);
        umurLabel = createLabel(1, 260, 503, 500, 40, "Umur", 40);
        button(1, 200, 600, 200, 50, "< Kembali", "page-1");
        button(1, 1000, 600, 200, 50, "Selanjutnya >", "page-3");
        
        bgPanel[1].add(bgLabel[1]);
        bgPanel[1].setVisible(false);
    } 
    
    public void inputField3(){
        createBackgroundFull(2, "bg.png");
        jwilayahTextDropdown = createDropdown(2, 600, 203, 500, 40, 40, new String[]{"tes","doang"});
        urutBangunanTextField = createTextField(2, 600, 303, 500, 40, 40, 16);
        urutKelTextField = createTextField(2, 600, 403, 500, 40, 40, 16);
        landmarkTextField = createTextField(2, 600, 503, 500, 40, 40, 16);

        jwilayahLabel = createLabel(2, 260, 203, 500, 40, "Jenis Wilayah", 40);
        urutBangunanLabel = createLabel(2, 260, 303, 500, 40, "No Urut Bangunan", 40);
        urutKelLabel = createLabel(2, 260, 403, 500, 40, "No Urut Keluarga", 40);
        landmarkLabel = createLabel(2, 260, 503, 500, 40, "ID Landmark", 40);
        
        button(2, 1000, 600, 200, 50, "Selanjutnya >", "page-4");
        button(2, 200, 600, 200, 50, "< Kembali", "page-2");
        
        bgPanel[2].add(bgLabel[2]);
        bgPanel[2].setVisible(false);
    } 
    
    public void inputField4(){
        createBackgroundFull(3, "bg.png");
        gKesulitanDropdown = createDropdown(3, 600, 203, 500, 40, 30, new String[]{"Ya","Tidak"});
        jGangguanDropdown = createDropdown(3, 600, 303, 500, 40, 30, new String[]{"Ya","Tidak"});
        ijazahDropdown = createDropdown(3, 600, 403, 500, 40, 30, new String[]{"Ya","Tidak"});
        statKerjaDropdown = createDropdown(3, 600, 503, 500, 40, 30, new String[]{"Ya","Tidak"});
        
        gKesulitanLabel = createLabel(3, 240, 203, 500, 40, "Gangguan Kesulitan", 30);
        jGangguanLabel = createLabel(3, 240, 303, 500, 40, "Jenis Gangguan", 30);
        ijazahLabel = createLabel(3, 240, 403, 500, 40, "Ijazah Terakhir", 30);
        statKerjaLabel = createLabel(3, 240, 503, 500, 40, "Status Bekerja", 30);
        addKerjaLabel = createLabel(3, 240, 550, 500, 40, "*dalam seminggu terakhir", 18);
        
        button(3, 1000, 600, 200, 50, "Selanjutnya >", "page-5");
        button(3, 200, 600, 200, 50, "< Kembali", "page-3");
        
        bgPanel[3].add(bgLabel[3]);
        bgPanel[3].setVisible(false);
    }
    
    public void inputField5(){
        createBackgroundFull(4, "bg.png");
        jLapanganDropdown = createDropdown(4, 600, 203, 500, 40, 30, new String[]{"Ya","Tidak"});
        statKedDropdown = createDropdown(4, 600, 303, 500, 40, 30, new String[]{"Ya","Tidak"});
        statMilikDropdown = createDropdown(4, 600, 403, 500, 40, 30, new String[]{"Ya","Tidak"});
        
        jLapanganLabel = createLabel(4, 240, 203, 500, 40, "Jenis Lapangan Usaha", 30);
        jLapangAddLabel = createLabel(4, 240, 250, 500, 40, "*dalam pekerjaan utama", 18);
        statKedLabel = createLabel(4, 240, 303, 500, 40, "Status Kedudukan", 30);
        statKedAddLabel = createLabel(4, 240, 350, 500, 40, "*dalam pekerjaan utama", 18);
        statMilikLabel = createLabel(4, 240, 403, 500, 40, "Status Kepemilikan Usaha", 30);
        
        button(4, 1000, 600, 200, 50, "Selanjutnya >", "page-6");
        button(4, 200, 600, 200, 50, "< Kembali", "page-4");
        
        bgPanel[4].add(bgLabel[4]);
        bgPanel[4].setVisible(false);
    }
    
    public void inputField6(){
        createBackgroundFull(5, "bg.png");
        jUsahaDropdown = createDropdown(5, 600, 203, 500, 40, 30, new String[]{"Ya","Tidak"});
        lUsahaDropdown = createDropdown(5, 600, 303, 500, 40, 30, new String[]{"Ya","Tidak"});
        
        jUsahaLabel = createLabel(5, 200, 203, 500, 40, "Jumlah Usaha yang Dimiliki", 30);
        lUsahaLabel = createLabel(5, 200, 303, 500, 40, "Lapangan Usaha", 30);
        lUsahaAddLabel = createLabel(5, 200, 350, 500, 40, "*dari usaha utama", 18);
        
        button(5, 200, 600, 200, 50, "< Kembali", "page-5");
        button(5, 1000, 600, 200, 50, "Selesai", "selesai");

        bgPanel[5].add(bgLabel[5]);
        bgPanel[5].setVisible(false);
    }
}
