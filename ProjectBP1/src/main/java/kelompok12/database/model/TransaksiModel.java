package kelompok12.database.model;
import java.sql.Timestamp;



public class TransaksiModel {
    private String id; // varchar(36)
    private String Username; // varchar(50)
    private String type; // varchar(30)
    private long penggunaan; // bigint
    private long saldoAwal; // bigint
    private long saldoAkhir; // bigint
    private Timestamp date; // timestamp(6)

    // Constructor, getters, and setters
    public TransaksiModel() {
    }

    public TransaksiModel(String id, String Username, String type, long penggunaan, long saldoAwal, long saldoAkhir, Timestamp date) {
        this.id = id;
        this.Username = Username;
        this.type = type;
        this.penggunaan = penggunaan;
        this.saldoAwal = saldoAwal;
        this.saldoAkhir = saldoAkhir;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPenggunaan() {
        return penggunaan;
    }

    public void setPenggunaan(long penggunaan) {
        this.penggunaan = penggunaan;
    }

    public long getSaldoAwal() {
        return saldoAwal;
    }

    public void setSaldoAwal(long saldoAwal) {
        this.saldoAwal = saldoAwal;
    }

    public long getSaldoAkhir() {
        return saldoAkhir;
    }

    public void setSaldoAkhir(long saldoAkhir) {
        this.saldoAkhir = saldoAkhir;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
