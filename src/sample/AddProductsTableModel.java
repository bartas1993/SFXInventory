package sample;

public class AddProductsTableModel {


    private String ProductName,ID,Scan;



    public AddProductsTableModel(String iD, String name, String scanCode) {
        ProductName =name;
        ID = iD;
        Scan = scanCode;

    }
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getScan() {
        return Scan;
    }

    public void setScan(String scan) {
        Scan = scan;
    }


}
