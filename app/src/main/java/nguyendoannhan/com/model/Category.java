package nguyendoannhan.com.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Category implements Serializable {
    // class danh muc
    private int idCat;
    private String name;

    public Category() {
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map toMap(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("idCat",idCat);
        hashMap.put("name",name);
        return hashMap;
    }
}
