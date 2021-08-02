package DB_Layer;

import Models.IDB_Operations;
import Models.IFactoryDB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FactoryDB implements IFactoryDB {
    public IDB_Operations getDB() {
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
            String DBType = prop.getProperty("Database");
            if (DBType.equals("SQL"))
                return new DBSQL();
        }

        return null;
    }

    public String getID() {
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
            String DBType = prop.getProperty("Database");
            String id = null;
            if (DBType.equals("Firebase"))
                id = prop.getProperty("Default_ID_Firebase");
            else
                id = prop.getProperty("Default_ID_Text");
            return id;
        }
        return null;
    }

}
