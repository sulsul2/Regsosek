package regsosek.Util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AppManager {
    ActionHandler actionHandler = new ActionHandler(this);
    UI ui = new UI(this);
    Routing routing = new Routing(this);

    public AppManager(){
        routing.showScreen(0);
    }
}
