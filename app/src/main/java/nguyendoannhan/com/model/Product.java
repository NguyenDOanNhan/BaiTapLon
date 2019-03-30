package nguyendoannhan.com.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Product implements Serializable {
    private int idPro;
    private String barcode;
    private String name;
    private float inputPrice;
    private float outputPrice;
    private int quantity;
    private int idCat;// id de lay san pham tu danh muc nao;

    public Product() {
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(float inputPrice) {
        this.inputPrice = inputPrice;
    }

    public float getOutputPrice() {
        return outputPrice;
    }

    public void setOutputPrice(float outputPrice) {
        this.outputPrice = outputPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public Map toMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("idPro", idPro);
        hashMap.put("barcode", barcode);
        hashMap.put("name", name);
        hashMap.put("inputPrice", inputPrice);
        hashMap.put("outputPrice", outputPrice);
        hashMap.put("quantity", quantity);
        hashMap.put("idCat", idCat);
        return hashMap;
    }
}
