/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.kategoribarang;
/**
 *
 * @author fadil
 */
public class kategori extends javax.swing.JFrame {
    int baris =0;
    static Object [] kolom = {"id_kategori","nama_kategori"};
    DefaultTableModel tbl = new DefaultTableModel(kolom, baris);
    /**
     * Creates new form kategori
     */
    public kategori() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        fcari = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ktg = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fid = new javax.swing.JTextField();
        fnama = new javax.swing.JTextField();
        tedit = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        tcari = new javax.swing.JButton();
        thapus = new javax.swing.JButton();
        tupdate = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("/ KATEGORI /");

        tbl_ktg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_ktg);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("id_kategori");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("nama_kategori");

        tedit.setBackground(new java.awt.Color(255, 255, 255));
        tedit.setForeground(new java.awt.Color(0, 0, 0));
        tedit.setText("edit");
        tedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teditActionPerformed(evt);
            }
        });

        tambah.setBackground(new java.awt.Color(255, 255, 255));
        tambah.setForeground(new java.awt.Color(0, 0, 0));
        tambah.setText("tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        tcari.setBackground(new java.awt.Color(255, 255, 255));
        tcari.setForeground(new java.awt.Color(0, 0, 0));
        tcari.setText("cari");
        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });

        thapus.setBackground(new java.awt.Color(255, 255, 255));
        thapus.setForeground(new java.awt.Color(0, 0, 0));
        thapus.setText("hapus");
        thapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thapusActionPerformed(evt);
            }
        });

        tupdate.setBackground(new java.awt.Color(255, 255, 255));
        tupdate.setForeground(new java.awt.Color(0, 0, 0));
        tupdate.setText("simpan");
        tupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tupdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fid)
                            .addComponent(fnama))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tedit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tupdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tambah)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fcari, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tcari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tedit)
                        .addComponent(thapus)
                        .addComponent(tupdate))
                    .addComponent(tambah))
                .addContainerGap())
        );

        jMenu1.setForeground(new java.awt.Color(0, 102, 255));
        jMenu1.setText("data barang");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        data d = new data();
        this.setVisible(false);
        d.setLocationRelativeTo(this);
        d.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        kategoribarang obj = new kategoribarang();
        //get data tabel
        String [][] data = obj.getKategori();
        for(int i=0; i<data.length; i++){
        tbl.addRow(new Object[]{data[i][0],data[i][1]});
    }
        tbl_ktg.setModel(tbl);
    }//GEN-LAST:event_formComponentShown

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        kategoribarang obj1 = new kategoribarang();
        
        String kataKunci = fcari.getText();
        tbl.getDataVector().removeAllElements();
        
        String [][] data = obj1.CariDataKategori(kataKunci);
        for(int i=0; i<data.length; i++){
            int no = i + 1;
            tbl.addRow(new Object[]{data[i][0], data[i][1]});
        }
        tbl_ktg.setModel(tbl);
        fcari.setText("");
    }//GEN-LAST:event_tcariActionPerformed

    private void teditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teditActionPerformed
        kategoribarang obj = new kategoribarang();
        
        int Pilihbaris = tbl_ktg.getSelectedRow();
        if(tbl_ktg.isRowSelected(Pilihbaris)){
        String id_kategori = tbl.getValueAt(Pilihbaris, 0).toString();
        String nama_kategori = obj.getDataKategori(id_kategori);
        
        fid.setText(id_kategori);
        fid.setEditable(false);
        fnama.setText(nama_kategori);
        }else{
        JOptionPane.showMessageDialog(this, "Pilih Data Kategori Terlebih Dahulu", 
        "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_teditActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        kategoribarang obj = new kategoribarang();
        String KodeKategori = fid.getText();
        String KategoriBuku = fnama.getText();
        if(KodeKategori.isEmpty()){
            JOptionPane.showMessageDialog(this, "id kategori harus diisi",
                "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
        }else if(KategoriBuku.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nama kategori harus diisi",
                "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
        }else{
            obj.TambahDataKategori(KodeKategori, KategoriBuku);
            tbl.addRow(new Object[]{KodeKategori, KategoriBuku});
            tbl_ktg.setModel(tbl);
            fid.setText("");
            fnama.setText("");
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void thapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thapusActionPerformed
        kategoribarang obj = new kategoribarang();
        
        int Pilihbaris = tbl_ktg.getSelectedRow();
        if(tbl_ktg.isRowSelected(Pilihbaris)){
        String id_kategori = tbl.getValueAt(Pilihbaris, 0).toString();
        
        obj.HapusDataKategori(id_kategori);
        tbl.removeRow(Pilihbaris);
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus",
                "Pesan Keonfirmasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu",
                "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_thapusActionPerformed

    private void tupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tupdateActionPerformed
        kategoribarang obj = new kategoribarang();
        String id_kategori = fid.getText();
        String nm_kategori = fnama.getText();
        if(id_kategori.isEmpty() && nm_kategori.isEmpty()){
        JOptionPane.showMessageDialog(this, "edit data terlebih dahulu",
                "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);    
        }else{
        obj.UpdateDataKategori(id_kategori, nm_kategori);
        tbl.getDataVector().removeAllElements();
        
        //get data tabel
        String [][] data = obj.getKategori();
        for(int i=0; i<data.length; i++){
            tbl.addRow(new Object[]{data[i][0], data[i][1]});
        }
        tbl_ktg.setModel(tbl);
        JOptionPane.showMessageDialog(this, "Data berhasil diedit",
                "Pesan Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
        fid.setEditable(true);
        fid.setText("");
        fnama.setText("");        
        }
    }//GEN-LAST:event_tupdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kategori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fcari;
    private javax.swing.JTextField fid;
    private javax.swing.JTextField fnama;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tbl_ktg;
    private javax.swing.JButton tcari;
    private javax.swing.JButton tedit;
    private javax.swing.JButton thapus;
    private javax.swing.JButton tupdate;
    // End of variables declaration//GEN-END:variables
}
