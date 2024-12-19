package kelompok12.database.model;

public class TransaksiModel {
    private String id; // varchar(36)
    private String type; // varchar(30)
    private long penggunaan; // bigint
    private long saldoAwal; // bigint
    private long saldoAkhir; // bigint

    // Constructor, getters, and setters
    public TransaksiModel() {
    }

    public TransaksiModel(String id, String type, long penggunaan, long saldoAwal, long saldoAkhir) {
        this.id = id;
        this.type = type;
        this.penggunaan = penggunaan;
        this.saldoAwal = saldoAwal;
        this.saldoAkhir = saldoAkhir;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
