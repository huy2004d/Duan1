/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SanPham;
import service.SPService;

/**
 *
 * @author 4bacu
 */
public class QLSP1 extends javax.swing.JDialog {

    /**
     * Creates new form QLSP1
     */
    List<SanPham> list = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<SanPham> lstsp = new ArrayList<>();
    private final SPService sps = new SPService();

    public QLSP1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Quản lý sản phẩm");
        Image icon = new ImageIcon(this.getClass().getResource("/vot.png")).getImage();
        this.setIconImage(icon);
        setSize(900, 700);
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tblsp.getModel();
        loadtotable();
        if (tblsp.getRowCount() > 0) {
            tblsp.setRowSelectionInterval(0, 0);
            showdetail();
        }
        this.filltable(sps.getall());
    }

    private void filltable(List<SanPham> list) {
        model = (DefaultTableModel) tblsp.getModel();
        model.setRowCount(0);
        for (SanPham Sp : list) {
            model.addRow(new Object[]{
                Sp.getId(),
                Sp.getTen(),
                Sp.getGiaban(),
                Sp.getMota(),
                Sp.isTrangthai() ? "Đang bán" : "Ngừng bán"
            });
        }
    }

    private void loadtotable() {
        model.setRowCount(0);
        ArrayList<SanPham> lstsp = sps.getall();

        for (SanPham sp : lstsp) {
            model.addRow(new Object[]{
                sp.getId(),
                sp.getTen(),
                sp.getGiaban(),
                sp.getMota(),
                sp.isTrangthai() ? "Đang bán" : "Ngừng bán"
            });
        }
    }

    private void showdetail() {
        int index = tblsp.getSelectedRow();
        txtmsp.setText(tblsp.getValueAt(index, 0).toString());
        txttensp.setText(tblsp.getValueAt(index, 1).toString());
        txtgia.setText(tblsp.getValueAt(index, 2).toString());
        txtmota.setText(tblsp.getValueAt(index, 3).toString());
        boolean gt = tblsp.getValueAt(index, 4).toString().equalsIgnoreCase("Đang bán") ? true : false;
        rddb.setSelected(gt);
        rdstop.setSelected(!gt);
    }

    private SanPham getSP() {
        SanPham sp = new SanPham();
        sp.setId(Integer.parseInt(txtmsp.getText()));
        sp.setTen(txttensp.getText());
        sp.setGiaban(Double.parseDouble(txtgia.getText()));
        sp.setMota(txtmota.getText());
        sp.setTrangthai(rddb.isSelected() ? true : false);
        return sp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmsp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttensp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtgia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtmota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rddb = new javax.swing.JRadioButton();
        rdstop = new javax.swing.JRadioButton();
        btnthem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txttim = new javax.swing.JTextField();
        btntim = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsp = new javax.swing.JTable();
        btnsua = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Mã sản phẩm");

        jLabel3.setText("Tên sản phẩm");

        jLabel4.setText("Giá bán");

        jLabel5.setText("Mô tả");

        jLabel6.setText("Trạng thái bán");

        rddb.setSelected(true);
        rddb.setText("Đang bán");
        rddb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rddbActionPerformed(evt);
            }
        });

        rdstop.setText("Ngừng bán");
        rdstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdstopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtmsp, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txttensp)
                                .addComponent(txtgia)
                                .addComponent(txtmota))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rddb)
                        .addGap(18, 18, 18)
                        .addComponent(rdstop)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rddb)
                    .addComponent(rdstop))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnthem.setText("Thêm sản phẩm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm sản phẩm");

        btntim.setText("Tìm kiếm");
        btntim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimActionPerformed(evt);
            }
        });

        tblsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên sản phẩm", "Giá bán", "Mô tả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsp);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnsua.setText("Sửa sản phẩm");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        jButton1.setText("Xóa Sản Phẩm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txttim))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btntim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnsua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnsua, jButton1});

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
    }// </editor-fold>//GEN-END:initComponents

    private void rddbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rddbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rddbActionPerformed

    private void rdstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdstopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdstopActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn add không?");
        if (hoi != JOptionPane.YES_OPTION) {
            return;
        }
        if (sps.validateForm(txtmsp.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Không được để trống ID");
            return;
        }
        if (sps.validateForm(txttensp.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên");
            return;
        }
        if (sps.validateForm(txtgia.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Không được để trống giá");
            return;
        }
        if (sps.checkSo(txtmsp.getText()) == false) {
            JOptionPane.showMessageDialog(this, "ID phải là số");
            return;
        }
        if (sps.validateSo(txtgia.getText()) == false) {
            JOptionPane.showMessageDialog(this, "giá phải là số");
            return;
        }
        if (sps.checkam(txtgia.getText()) == false) {
            JOptionPane.showMessageDialog(this, "giá phải là số dương");
            return;
        }

        if (sps.checkam(txtmsp.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Mã phải là số dương");
            return;
        }
        try {
            SanPham sp = getSP();

            if (sps.testTrung(sp.getId())) {
                JOptionPane.showMessageDialog(this, "Trùng Mã");
            }
            if (sps.add(sp) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loadtotable();
            } else {
                JOptionPane.showMessageDialog(this, "ko Thêm thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nút thêm");
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btntimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimActionPerformed
        // TODO add your handling code here:
        //        List<SanPham> id = sps.selectten(txttim.getText());
        //        loadtotable();
        String tim = txttim.getText();
        List<SanPham> list = sps.selectten(tim);
        if (!tim.trim().equals("")) {
            if (!list.isEmpty()) {
                this.filltable(list);
            } else {
                JOptionPane.showMessageDialog(this, "Không có sản phẩm nào tên " + tim);
            }
        } else {
            filltable(sps.getall());
            //            JOptionPane.showMessageDialog(this, "Bạn đang để trống ô tìm kiếm");
        }
    }//GEN-LAST:event_btntimActionPerformed

    private void tblspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblspMouseClicked
        // TODO add your handling code here:
        try {
            showdetail();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi click");
        }
    }//GEN-LAST:event_tblspMouseClicked

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn update không?");
        if (hoi != JOptionPane.YES_OPTION) {
            return;
        }
        if (sps.validateForm(txtmsp.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Không được để trống ID");
            return;
        }
        if (sps.validateForm(txttensp.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên");
            return;
        }
        if (sps.validateForm(txtgia.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Không được để trống giá");
            return;
        }
        if (sps.checkSo(txtmsp.getText()) == false) {
            JOptionPane.showMessageDialog(this, "ID phải là số");
            return;
        }
        if (sps.validateSo(txtgia.getText()) == false) {
            JOptionPane.showMessageDialog(this, "giá phải là số");
            return;
        }
        try {
            SanPham sp = getSP();
            sp.setId(Integer.parseInt(txtmsp.getText()));

            if (sps.update(sp) != null) {

                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loadtotable();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa ko thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nút sửa");
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Muốn Xóa Sản Phẩm Này Không");
        int index = tblsp.getSelectedRow();
        int id = (int) tblsp.getValueAt(index, 0);
        if(hoi==0){
            if(sps.xoaSP(id)!=0){
                JOptionPane.showMessageDialog(this, "Xóa Thành Công");
                filltable(sps.getall());
            }else{
                JOptionPane.showMessageDialog(this, "Xóa Thất Bại Vì Sản Phẩm Bạn Muốn Xóa Đã Có trong Bảng Sản Phẩm Chi Tiết");
            }
                  
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(QLSP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLSP1 dialog = new QLSP1(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btntim;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rddb;
    private javax.swing.JRadioButton rdstop;
    private javax.swing.JTable tblsp;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txtmota;
    private javax.swing.JTextField txtmsp;
    private javax.swing.JTextField txttensp;
    private javax.swing.JTextField txttim;
    // End of variables declaration//GEN-END:variables
}
