package nguyendoannhan.com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bill implements Serializable {
    private int idBill;
    private Date paymentDate;
    private int idPro;
    private int idUser;
    private float total;
    private int quantity;

    public Bill() {
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Map toMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("idBill", idBill);
        hashMap.put("paymentDate", paymentDate);
        hashMap.put("total", total);
        hashMap.put("quantity", quantity);
        hashMap.put("idPro", idPro);
        hashMap.put("idUser", idUser);

        return hashMap;
    }
}
