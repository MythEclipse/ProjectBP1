/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kelompok12.layout.admin;

import kelompok12.database.model.AdminModel;
import kelompok12.layout.user.Tarik;
import kelompok12.layout.user.User;
import kelompok12.projectbp1.Admin;
import kelompok12.projectbp1.Utama;

/**
 *
 * @author Fujitsu U938
 */
public class MenuAdmin extends javax.swing.JFrame {

    private static AdminModel session;

    /**
     * Creates new form Admin
     */
    public MenuAdmin(AdminModel loginSuccess) {
        MenuAdmin.session = loginSuccess;
        initComponents();
        Home();
    }

    public void Home() {
        DataAdmin admin = new DataAdmin(session);
        Konten.removeAll();
        Konten.add(admin.getContentPane(), java.awt.BorderLayout.CENTER);
        Konten.revalidate();
        Konten.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        Konten = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        HomeMenu = new javax.swing.JMenu();
        AdministrasiMenu = new javax.swing.JMenu();
        ListUserMenu = new javax.swing.JMenuItem();
        EditUserMenu = new javax.swing.JMenuItem();
        HapusUserMenu = new javax.swing.JMenuItem();
        TransaksiMenu = new javax.swing.JMenu();
        RiwayatTransaksiMenu = new javax.swing.JMenuItem();
        LaporanUserMenu = new javax.swing.JMenuItem();
        CetakLaporanMenu = new javax.swing.JMenuItem();
        LogoutMenu = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout KontenLayout = new javax.swing.GroupLayout(Konten);
        Konten.setLayout(KontenLayout);
        KontenLayout.setHorizontalGroup(
                KontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE));
        KontenLayout.setVerticalGroup(
                KontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 277, Short.MAX_VALUE));

        HomeMenu.setText("Home");
        HomeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeMenuActionPerformed(evt);
            }
        });
        jMenuBar1.add(HomeMenu);

        AdministrasiMenu.setText("Administrasi");

        ListUserMenu.setText("List User");
        ListUserMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListUserMenuActionPerformed(evt);
            }
        });
        AdministrasiMenu.add(ListUserMenu);

        EditUserMenu.setText("Edit User");
        EditUserMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditUserMenuActionPerformed(evt);
            }
        });
        AdministrasiMenu.add(EditUserMenu);

        HapusUserMenu.setText("Hapus User");
        AdministrasiMenu.add(HapusUserMenu);

        jMenuBar1.add(AdministrasiMenu);

        TransaksiMenu.setText("Transaksi");

        RiwayatTransaksiMenu.setText("Riwayat Transaksi");
        RiwayatTransaksiMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RiwayatTransaksiMenuActionPerformed(evt);
            }
        });
        TransaksiMenu.add(RiwayatTransaksiMenu);

        LaporanUserMenu.setText("Laporan User");
        TransaksiMenu.add(LaporanUserMenu);

        CetakLaporanMenu.setText("Cetak Laporan");
        TransaksiMenu.add(CetakLaporanMenu);

        jMenuBar1.add(TransaksiMenu);

        LogoutMenu.setText("Logout");
        LogoutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(LogoutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Konten, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Konten, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutMenuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_LogoutMenuMouseClicked
        // Terminate the current session
        session = null;
        // Navigate to the Utama screen
        setVisible(false);
        Utama utama = new Utama();
        utama.setVisible(true);
    }// GEN-LAST:event_LogoutMenuMouseClicked

    private void HomeMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_HomeMenuActionPerformed
        Home();
    }// GEN-LAST:event_HomeMenuActionPerformed

    private void EditUserMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_EditUserMenuActionPerformed
        EditUser editUser = new EditUser();
        Konten.removeAll();
        Konten.add(editUser.getContentPane(), java.awt.BorderLayout.CENTER);
        Konten.revalidate();
        Konten.repaint();
    }// GEN-LAST:event_EditUserMenuActionPerformed

    private void RiwayatTransaksiMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RiwayatTransaksiMenuActionPerformed
        RiwayatTransaksi riwayat = new RiwayatTransaksi();
        Konten.removeAll();
        Konten.add(riwayat.getContentPane(), java.awt.BorderLayout.CENTER);
        Konten.revalidate();
        Konten.repaint();
    }// GEN-LAST:event_RiwayatTransaksiMenuActionPerformed

    private void ListUserMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ListUserMenuActionPerformed
        ListUser listuser = new ListUser();
        Konten.removeAll();
        Konten.add(listuser.getContentPane(), java.awt.BorderLayout.CENTER);
        Konten.revalidate();
        Konten.repaint();
    }// GEN-LAST:event_ListUserMenuActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin(session).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AdministrasiMenu;
    private javax.swing.JMenuItem CetakLaporanMenu;
    private javax.swing.JMenuItem EditUserMenu;
    private javax.swing.JMenuItem HapusUserMenu;
    private javax.swing.JMenu HomeMenu;
    private javax.swing.JPanel Konten;
    private javax.swing.JMenuItem LaporanUserMenu;
    private javax.swing.JMenuItem ListUserMenu;
    private javax.swing.JMenu LogoutMenu;
    private javax.swing.JMenuItem RiwayatTransaksiMenu;
    private javax.swing.JMenu TransaksiMenu;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    // End of variables declaration//GEN-END:variables
}
