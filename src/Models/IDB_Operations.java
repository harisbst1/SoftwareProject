package Models;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IDB_Operations {
    void initDB() throws IOException;

    IModel getObject(String objectId, ModelType modelType) throws Exception; //returns object with key == objectId //Done

    ArrayList<IModel> getObjectsList(ModelType modelType) throws Exception; //returns objects list with keys matching objectIds

    ArrayList<IModel> getObjectsList(HashMap<String, Object> attributesToQuery, ModelType modelType) throws Exception; //returns objects list with attributesToQuery Condition

    boolean addObject(IModel object, ModelType modelType) throws Exception;   //returns objectId of new created object

    boolean removeObject(String objectId, ModelType modelType) throws Exception;  //removes object , and returns boolean

    boolean updateObject(String objectId, HashMap<String, Object> attributesToBeUpdated, ModelType modelType) throws Exception;  //fo update variable(s) operations

    enum ModelType {
        Services,
        Item,
        User
    }

    enum UpdateOperation {
        Add,
        Remove
    }
}