/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelompok12.database.model;

/**
 *
 * @author asephs
 */
public class AdminModel {
    private String username;
    private String password;
    private String Alamat;
    private String JK;

    // Constructor, getters, and setters
    public AdminModel() {}

    public AdminModel(String username, String password, String Alamat, String JK) {
        this.username = username;
        this.password = password;
        this.Alamat = Alamat;
        this.JK = JK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getJK() {
        return JK;
    }

    public void setJK(String JK) {
        this.JK = JK;
    }

}

