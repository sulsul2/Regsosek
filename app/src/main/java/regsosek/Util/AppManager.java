package regsosek.Util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import regsosek.models.old.Ruta;
import regsosek.models.old.Penduduk;

public class AppManager {
    ActionHandler actionHandler = new ActionHandler(this);
    UI ui = new UI(this);
    Routing routing = new Routing(this);
    Ruta ruta = new Ruta();
    Penduduk penduduk = new Penduduk();        

    public AppManager(){
        routing.showScreen(0);
    }

    public void setRuta(Ruta ruta){
        this.ruta = ruta;
    }

    public void setPenduduk(Penduduk penduduk){
        this.penduduk = penduduk;
    }

    public void changePenduduk(){
        Penduduk temp = new Penduduk();
        setPenduduk(temp);
    }
}
