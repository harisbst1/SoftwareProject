package Models;

import java.util.ArrayList;

public interface Operations {

    boolean authenticateUser(String text, String lblPWordEntryText);

    boolean addService(Services services);

    boolean addItem(Item item);

    ArrayList<Services> getServices();

    void removeService(int serviceCode);

    ArrayList<Item> getItemList();

    void removeItem(int itemCode);

    boolean editItem(Item item);

    boolean editService(Services services);

}
