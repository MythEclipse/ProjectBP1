package kelompok12.database.model;

public class User {
    private String id; // Changed to varchar(36)
    private String username; // varchar(30)
    private String password; // varchar(30)
    private String jenisKelamin; // enum('L', 'P')
    private String alamat; // varchar(400)

    // Constructor, getters, and setters
    public User() {}

    public User(String id, String username, String password, String jenisKelamin, String alamat) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
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
}
