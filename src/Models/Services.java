package Models;

public class Services implements IModel {
    public String serviceName;
    public String serviceType;
    public int serviceCost;
    public int serviceCode; //db will initialize it,when creating

    public Services() {
    }

    public Services(String _commentId, String _userId, int _commentText, int _timestamp) {
        serviceName = _commentId;
        serviceType = _userId;
        serviceCost = _commentText;
        serviceCode = _timestamp;
    }

    @Override
    public String insertStatement() {
        return serviceCode+", '"+serviceName+"', '"+serviceType+"', "+serviceCost;
    }


}
