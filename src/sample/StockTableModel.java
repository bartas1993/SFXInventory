package sample;

public class StockTableModel {


    String Product,Kill,Cut,Pack,Use,Amount,ID;

    public StockTableModel(String product,String kill,String cut,String pack,String use,String amount,String iD) {
        Product = product;
        Kill = kill;
        Cut = cut;
        Pack = pack;
        Use = use;
        Amount = amount;
        ID = iD;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getKill() {
        return Kill;
    }

    public void setKill(String kill) {
        Kill = kill;
    }

    public String getCut() {
        return Cut;
    }

    public void setCut(String cut) {
        Cut = cut;
    }

    public String getPack() {
        return Pack;
    }

    public void setPack(String pack) {
        Pack = pack;
    }
    public String getUse() {
        return Use;
    }

    public void setUse(String use) {
        Use = use;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
