package kelompok12.database.model;

public class UserModel {
    private String id; // Changed to varchar(36)
    private String username; // varchar(30)
    private String password; // varchar(30)
    private String jenisKelamin; // enum('L', 'P')
    private String alamat; // varchar(400)
    private long uang; // bigint

    // Constructor, getters, and setters
    public UserModel() {}

    public UserModel(String id, String username, String password, String jenisKelamin, String alamat, long uang) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.uang = uang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public long getUang() {
        return uang;
    }

    public void setUang(long uang) {
        this.uang = uang;
    }
}
