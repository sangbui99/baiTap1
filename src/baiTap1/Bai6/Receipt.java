package baiTap1.Bai6;

import java.util.Date;
import java.util.List;

public class Receipt {
    private int idReceipt;
    private int idStaffExport;
    private int idClient;
    private List<Items> listItems;
    private int totalPrice;
    private Date dateBuy;

    public int getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(int idReceipt) {
        this.idReceipt = idReceipt;
    }

    public int getIdStaffExport() {
        return idStaffExport;
    }

    public void setIdStaffExport(int idStaffExport) {
        this.idStaffExport = idStaffExport;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public List<Items> getListItems() {
        return listItems;
    }

    public void setListItems(List<Items> listItems) {
        this.listItems = listItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }
}
