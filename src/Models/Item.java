package Models;

public class Item implements IModel {
    public String itemName;
    public String manufacturer;
    public int itemCode;
    public int itemQty;
    public int itemPrice;
    public String itemType;

    public Item() {
    }

    public Item(String _likeId, String _userId, int _timestamp) {
        itemName = _likeId;
        manufacturer = _userId;
        itemCode = _timestamp;
    }

    @Override
    public String insertStatement() {
        return itemCode + ", '" + itemName + "', '" + manufacturer + "', '" + itemType + "', " + itemPrice + ", " + itemQty;
    }
}
