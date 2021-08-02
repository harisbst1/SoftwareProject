/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BL_Operations implements Operations {
    IDB_Operations db;

    public BL_Operations(IDB_Operations _obj) {
        try {
            _obj.initDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
        db = _obj;
    }

    @Override
    public boolean authenticateUser(String uName, String pWord) {
        HashMap<String,Object> attributes = new HashMap<>();
        try{
            attributes.put("UserID",Integer.parseInt(uName));
        }
        catch (Exception e){
            return false;
        }
        attributes.put("Password",pWord);

        ArrayList<IModel> users = null;
        try {
            users = db.getObjectsList(attributes, IDB_Operations.ModelType.User);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (users != null) {
            return users.size() > 0;
        }
        return false;
    }

    @Override
    public boolean addService(Services service) {
        try {
            ArrayList<IModel> modelArrayList = db.getObjectsList(IDB_Operations.ModelType.Services);
            Services temp = (Services) modelArrayList.get(modelArrayList.size()-1);
            service.serviceCode = temp.serviceCode+1;
            return db.addObject(service, IDB_Operations.ModelType.Services);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addItem(Item item) {
        try {
            ArrayList<IModel> modelArrayList = db.getObjectsList(IDB_Operations.ModelType.Item);
            Item temp = (Item) modelArrayList.get(modelArrayList.size()-1);
            item.itemCode = temp.itemCode+1;
            return db.addObject(item, IDB_Operations.ModelType.Item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Services> getServices() {
        ArrayList<Services> servicesArrayList = new ArrayList<>();
        ArrayList<IModel> modelArrayList = null;

        try {
            modelArrayList = db.getObjectsList(IDB_Operations.ModelType.Services);
        } catch (Exception e) {
            return servicesArrayList;
        }

        for (IModel iModel : modelArrayList) {
            Services temp = (Services) iModel;
            servicesArrayList.add(temp);
        }
        return servicesArrayList;
    }

    @Override
    public void removeService(int serviceCode) {
        try {
            db.removeObject(String.valueOf(serviceCode), IDB_Operations.ModelType.Services);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Item> getItemList() {
        ArrayList<Item> itemArrayList = new ArrayList<>();
        ArrayList<IModel> modelArrayList = null;

        try {
            modelArrayList = db.getObjectsList(IDB_Operations.ModelType.Item);
        } catch (Exception e) {
            return itemArrayList;
        }

        for (IModel iModel : modelArrayList) {
            Item temp = (Item) iModel;
            itemArrayList.add(temp);
        }
        return itemArrayList;
    }

    @Override
    public void removeItem(int itemCode) {
        try {
            db.removeObject(String.valueOf(itemCode), IDB_Operations.ModelType.Item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean editItem(Item item) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("ItemName",item.itemName);
        map.put("Manufacturer",item.manufacturer);
        map.put("ItemType",item.itemType);
        map.put("ItemPrice",item.itemPrice);
        map.put("ItemQty",item.itemQty);

        try {
            return db.updateObject(String.valueOf(item.itemCode),map, IDB_Operations.ModelType.Item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editService(Services services) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("ServiceName",services.serviceName);
        map.put("ServiceType",services.serviceType);
        map.put("ServiceCost",services.serviceCost);

        try {
            return db.updateObject(String.valueOf(services.serviceCode),map, IDB_Operations.ModelType.Services);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}