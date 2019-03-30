package nguyendoannhan.com.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Customer implements Serializable {
    private int idCus;
    private String fullName;
    private String phone;
    private String email;
    private String adress;
    private String note;

    public Customer(int idCus, String fullName, String phone, String email, String adress, String note) {
        this.idCus = idCus;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
        this.note = note;
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Map toMap() {
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("idCus", idCus);
        hashMap.put("fullName", fullName);
        hashMap.put("phone", phone);
        hashMap.put("email", email);
        hashMap.put("address", adress);
        hashMap.put("note", note);
        return hashMap;
    }
}
