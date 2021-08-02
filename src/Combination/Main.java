package Combination;

import BL.FactoryBL;
import Models.IFactoryBL;
import Models.IUI;
import Models.Operations;
import UI_Swing.GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static IUI getUI() {
        Properties prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(".\\src\\Models\\Layer.cfg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (ip != null) {
            try {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String UIType = prop.getProperty("User_Interface");
            if (UIType.equals("Graphical"))
                return new GUI();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        IFactoryBL func = new FactoryBL();
        Operations BLOp = func.getOperations();
        IUI UI = getUI();

        System.out.println("Done");
        if (UI != null) {
            UI.start(BLOp);
        }
    }
}
