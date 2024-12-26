/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package kelompok12.layout.login;

import kelompok12.database.model.UserModel;
import kelompok12.database.repo.UserRepository;
import kelompok12.projectbp1.Utama;

/**
 *
 * @author Fujitsu U938
 */
public class Register extends javax.swing.JFrame {
    static Utama utamaInstance;

    /*
     * Variabel Statis utamaInstance:
     * 
     * Ditambahkan variabel statis utamaInstance di kelas Register untuk menyimpan
     * referensi ke instance Utama yang sudah ada.
     * Konstruktor Register:
     * 
     * Konstruktor Register menerima parameter Utama dan menyimpan referensi ini ke
     * variabel statis utamaInstance.
     * Metode registerMouseClicked:
     * 
     * Ketika tombol register diklik, metode registerMouseClicked dipanggil.
     * Metode ini memanggil DaftarUser() untuk melakukan pendaftaran.
     * Setelah itu, jika utamaInstance tidak null, metode setKontenLogin() dipanggil
     * pada instance Utama yang sudah ada.
     * Modifikasi Utama:
     * 
     * Di kelas Utama, ketika menu Register diklik, instance Utama yang sudah ada
     * diteruskan ke konstruktor Register.
     * Ini memastikan bahwa instance Utama yang sama digunakan di kelas Register.
     * Dengan cara ini, kita dapat mengubah konten utama yang sudah ada tanpa
     * membuat instance baru dari Utama.
     */
    /** Creates new form Register */
    public Register(Utama utama) {
        initComponents();
        Register.utamaInstance = utama;
    }

    private void DaftarUser() {
        String nama = this.nama.getText();
        String alamat = this.alamat.getText();
        String password = this.pass.getText();
        String jenisKelamin = "";
        if (this.laki.isSelected()) {
            jenisKelamin = "L";
        } else if (this.perm.isSelected()) {
            jenisKelamin = "P";
        }

        if (nama.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong");
            return;
        }

        if (alamat.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Alamat tidak boleh kosong");
            return;
        }

        if (password.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Password tidak boleh kosong");
            return;
        }

        if (!this.laki.isSelected() && !this.perm.isSelected()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih jenis kelamin");
            return;
        }

        UserModel user = new UserModel(null, nama, password, jenisKelamin, alamat, 50000);
        UserRepository userRepository = new UserRepository();
        boolean isSuccess = userRepository.create(user);
        if (isSuccess) {
            javax.swing.JOptionPane.showMessageDialog(this, "Berhasil mendaftar");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal mendaftar");
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        alamat = new javax.swing.JTextField();
        laki = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        perm = new javax.swing.JRadioButton();
        nama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        register = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(227, 242, 253));

        jPanel1.setBackground(new java.awt.Color(227, 242, 253));

        laki.setBackground(new java.awt.Color(227, 242, 253));
        laki.setText("L");
        laki.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lakiMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Register Nasabah");

        perm.setBackground(new java.awt.Color(227, 242, 253));
        perm.setText("P");
        perm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                permMouseClicked(evt);
            }
        });

        jLabel2.setText("Nama");

        jLabel5.setText("Password");

        jLabel3.setText("Alamat");

        jLabel4.setText("Jenis Kelamin");

        register.setText("Register");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(laki)
                                .addGap(18, 18, 18)
                                .addComponent(perm))
                            .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(register, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel1)))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(laki)
                    .addComponent(perm))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(register)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_registerMouseClicked
        DaftarUser();
        if (utamaInstance != null) {
            utamaInstance.setKontenLogin();
        }
    }// GEN-LAST:event_registerMouseClicked

    private void lakiMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lakiMouseClicked
        perm.setSelected(false);
    }// GEN-LAST:event_lakiMouseClicked

    private void permMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_permMouseClicked
        laki.setSelected(false);
    }// GEN-LAST:event_permMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register(utamaInstance).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton laki;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField pass;
    private javax.swing.JRadioButton perm;
    private javax.swing.JButton register;
    // End of variables declaration//GEN-END:variables

}
