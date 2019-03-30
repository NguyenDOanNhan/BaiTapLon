package nguyendoannhan.com.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
    private int idUser;
    private String fullName;
    private String email;
    private String password;

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map toMap(){
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("idUser", idUser);
        hashMap.put("fullName", fullName);
        hashMap.put("email", email);
        hashMap.put("password", password);
        return hashMap;
    }
}
