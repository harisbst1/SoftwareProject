package DB_Layer;

import Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DBSQL implements IDB_Operations {
    private Connection conn;
    private HashMap<ModelType,String> keyModelMapping;
    private HashMap<ModelType,String> tableModelMapping;

    @Override
    public void initDB(){
        keyModelMapping = new HashMap<>();
        keyModelMapping.put(ModelType.User,"UserId");
        keyModelMapping.put(ModelType.Item,"ItemCode");
        keyModelMapping.put(ModelType.Services,"ServiceCode");

        tableModelMapping = new HashMap<>();
        tableModelMapping.put(ModelType.User,"[User]");
        tableModelMapping.put(ModelType.Item,"Inventory");
        tableModelMapping.put(ModelType.Services,"[Service]");

        try {
            String classPath2 = "jdbc:sqlserver://localhost;databaseName=carManagement;integratedSecurity=true;";
            conn = DriverManager.getConnection(classPath2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (conn!=null){
            System.out.println("Connected");
        }
    }

    @Override
    public IModel getObject(String objectId, ModelType modelType) throws Exception {
        Statement statement = conn.createStatement();

        String query = "Select *\nFrom "+tableModelMapping.get(modelType)+"\nWhere "+keyModelMapping.get(modelType)+"="+objectId;
        ResultSet result = statement.executeQuery(query);
        result.next();
        IModel iModel = null;

        if (modelType.toString().equals("User"))
            iModel = getUser(result);
        else if (modelType.toString().equals("Services"))
            iModel = getServices(result);
        else if (modelType.toString().equals("Item"))
            iModel = getItem(result);
        result.close();

        return iModel;
    }

    @Override
    public ArrayList<IModel> getObjectsList(ModelType modelType) throws Exception {
        ArrayList<IModel> ans = new ArrayList<>();
        Statement statement = conn.createStatement();

        String query = "Select *\nFrom "+tableModelMapping.get(modelType)+"\n";
        ResultSet result = statement.executeQuery(query);
        while(result.next()){
            IModel iModel = null;

            if (modelType.toString().equals("User"))
                iModel = getUser(result);
            else if (modelType.toString().equals("Services"))
                iModel = getServices(result);
            else if (modelType.toString().equals("Item"))
                iModel = getItem(result);

            ans.add(iModel);
        }
        result.close();

        return ans;
    }

    @Override
    public ArrayList<IModel> getObjectsList(HashMap<String, Object> attributesToQuery, ModelType modelType) throws Exception {
        ArrayList<IModel> ans = new ArrayList<>();
        Set<String> keySet = attributesToQuery.keySet();

        String where = "Where ";
        int count = 0;
        for (String key: keySet){
            if (count==0){
                count+=1;
                where = where.concat(key+"="+attributesToQuery.get(key)+" ");
            }
            else
                where = where.concat("AND "+key+"="+attributesToQuery.get(key)+" ");
        }

        String query = "Select *\nFrom "+tableModelMapping.get(modelType)+"\n";
        if (keySet.size()>0)
            query = query.concat(where);

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while(result.next()){
            IModel iModel = null;

            if (modelType.toString().equals("User"))
                iModel = getUser(result);
            else if (modelType.toString().equals("Services"))
                iModel = getServices(result);
            else if (modelType.toString().equals("Item"))
                iModel = getItem(result);

            ans.add(iModel);
        }
        result.close();

        return ans;
    }

    @Override
    public boolean removeObject(String objectId, ModelType modelType) throws Exception {
        Statement statement = conn.createStatement();

        String query = "Delete \nFrom "+tableModelMapping.get(modelType)+"\nWhere "+keyModelMapping.get(modelType)+"="+objectId;
        int result = statement.executeUpdate(query);
        return result>0;
    }

    @Override
    public boolean addObject(IModel object, ModelType modelType) throws Exception {
        Statement statement = conn.createStatement();

        String query = "Insert into "+tableModelMapping.get(modelType)+" values "+"("+object.insertStatement()+")";
        int result = statement.executeUpdate(query);
        return result>0;
    }

    @Override
    public boolean updateObject(String objectId, HashMap<String, Object> attributesToBeUpdated, ModelType modelType) throws Exception {
        Statement statement = conn.createStatement();
        String context = "";
        Set<String> keySet = attributesToBeUpdated.keySet();

        for (String key: keySet){
            context = context.concat(", "+key+" = '"+attributesToBeUpdated.get(key)+"'");
        }
        context = String.valueOf(context.subSequence(2,context.length()));

        String query = "Update "+tableModelMapping.get(modelType)+" set "+context+" Where "+keyModelMapping.get(modelType)+" = "+objectId;

        int result = statement.executeUpdate(query);
        return result>0;
    }

    private User getUser(ResultSet rSet){
        User usr = new User();
        try {
            usr.UserName = rSet.getString("UserName");
            usr.UserID = rSet.getString("UserID");
            usr.Designation = rSet.getString("Designation");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usr;
    }

    private Services getServices(ResultSet rSet){
        Services usr = new Services();
        try {
            usr.serviceName = rSet.getString("ServiceName");
            usr.serviceCode = Integer.parseInt(rSet.getString("ServiceCode"));
            usr.serviceCost = Integer.parseInt((rSet.getString("ServiceCost")));
            usr.serviceType = rSet.getString("ServiceType");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usr;
    }

    private Item getItem(ResultSet rSet){
        Item usr = new Item();
        try {
            usr.itemName = rSet.getString("ItemName");
            usr.itemPrice = Integer.parseInt(rSet.getString("ItemPrice"));
            usr.itemQty = Integer.parseInt((rSet.getString("ItemQty")));
            usr.itemCode = Integer.parseInt(rSet.getString("ItemCode"));            usr.itemQty = Integer.parseInt((rSet.getString("ItemQty")));
            usr.manufacturer = rSet.getString("Manufacturer");
            usr.itemType = rSet.getString("ItemType");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usr;
    }
}
