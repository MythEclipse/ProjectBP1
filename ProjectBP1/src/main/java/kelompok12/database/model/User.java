package kelompok12.database.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String jenisKelamin;
    private String alamat;

    // Constructor, getters, and setters
    public User() {}

    public User(int id, String username, String password, String jenisKelamin, String alamat) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
