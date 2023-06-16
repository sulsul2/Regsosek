package regsosek.Util;

import regsosek.models.old.Ruta;
import regsosek.models.old.User;
import regsosek.models.old.Penduduk;

public class AppManager {
    ActionHandler actionHandler = new ActionHandler(this);
    UI ui = new UI(this);
    Routing routing = new Routing(this);
    Ruta ruta = new Ruta();
    Penduduk penduduk = new Penduduk(); 
    User user = new User();       

    public AppManager(){
        routing.showScreen(7);
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

    public void setUser(User user){
        this.user = user;
    }

    public void changeUser(){
        User temp = new User();
        setUser(temp);
    }
}
