package BL;

import DB_Layer.FactoryDB;
import Models.IDB_Operations;
import Models.IFactoryBL;
import Models.IFactoryDB;
import Models.Operations;

public class FactoryBL implements IFactoryBL {
    public Operations getOperations() {
        IFactoryDB obj = new FactoryDB();

        IDB_Operations DB = obj.getDB();
        return new BL_Operations(DB);
    }
}
