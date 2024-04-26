/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.dashboard;

import com.controller.function;
import com.auth.login;
import com.auth.register;
import com.menus.menuAccueil;
import com.menus.menuRecharge;
import com.menus.menuCategorie;
import com.menus.menuDepense;
import java.awt.Color;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author VORTEX
 */
public class accueil extends javax.swing.JFrame {

    /**
     * Creates new form accueil
     */
    Color DefaultColor, ClickedColor;
    private String UserId;
    public accueil(String UserId)  {
        this.UserId = UserId;
        initComponents();
        DefaultColor = new Color(242,242,242);
        ClickedColor = new Color(204,0,0);
        
        try {
        Connection con = function.DatabaseManager.getConnection();
        Statement st = con.createStatement();

        // Requête SQL pour récupérer le nom et le prénom de l'utilisateur
        String query = "SELECT nom, prenom FROM users WHERE id = '" + this.UserId + "'";
        ResultSet rs = st.executeQuery(query);

        // Vérifiez si le résultat de la requête est non vide
        if (rs.next()) {
            // Récupérez le nom et le prénom de l'utilisateur à partir du résultat de la requête
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");

            // Affichez le nom et le prénom dans le JLabel "name"
            username.setText(nom + " " + prenom);
        } else {
            // Si aucun résultat n'est retourné, affichez un message d'erreur
            username.setText("Nom Prénom");
        }

        con.close();
    } catch (SQLException ex) {
        // En cas d'erreur lors de la récupération des données depuis la base de données, affichez un message d'erreur
        System.out.println("Erreur lors de la récupération du nom et du prénom : " + ex.getMessage());
    }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        MenuHistorique = new javax.swing.JPanel();
        menu4 = new javax.swing.JLabel();
        MenuAccueil = new javax.swing.JPanel();
        menu1 = new javax.swing.JLabel();
        MenuDepense = new javax.swing.JPanel();
        menu2 = new javax.swing.JLabel();
        MenuCategorie = new javax.swing.JPanel();
        menu3 = new javax.swing.JLabel();
        MenuRecharge = new javax.swing.JPanel();
        menu5 = new javax.swing.JLabel();
        PanelAccueil = new javax.swing.JDesktopPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Expense Track v0.1.0 - Tableau de bord");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EXPENSE TRACK");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 180, 40));

        jButton7.setBackground(new java.awt.Color(204, 0, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8_user_20px_1.png"))); // NOI18N
        jButton7.setText("Déconnexion");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 160, 30));

        MenuHistorique.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuHistoriqueMousePressed(evt);
            }
        });
        MenuHistorique.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8-ledger-20.png"))); // NOI18N
        menu4.setText("Historique");
        MenuHistorique.add(menu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 30));

        jPanel2.add(MenuHistorique, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 180, 30));

        MenuAccueil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAccueilMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuAccueilMousePressed(evt);
            }
        });
        MenuAccueil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8-hub-20.png"))); // NOI18N
        menu1.setText("Accueil");
        MenuAccueil.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 30));

        jPanel2.add(MenuAccueil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, 30));

        MenuDepense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuDepenseMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuDepenseMousePressed(evt);
            }
        });
        MenuDepense.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8-budget-20.png"))); // NOI18N
        menu2.setText("Dépense");
        MenuDepense.add(menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 30));

        jPanel2.add(MenuDepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, 30));

        MenuCategorie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuCategorieMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuCategorieMousePressed(evt);
            }
        });
        MenuCategorie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8-historical-20.png"))); // NOI18N
        menu3.setText("Catégorie");
        MenuCategorie.add(menu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 30));

        jPanel2.add(MenuCategorie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 180, 30));

        MenuRecharge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuRechargeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuRechargeMousePressed(evt);
            }
        });
        MenuRecharge.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8-sales-balance-20.png"))); // NOI18N
        menu5.setText("Recharge");
        MenuRecharge.add(menu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 30));

        jPanel2.add(MenuRecharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 180, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 510));

        PanelAccueil.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(PanelAccueil, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 690, 470));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, 30));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bienvenue !");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 120, 30));

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8_user_20px_1.png"))); // NOI18N
        jPanel3.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 690, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAccueilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAccueilMouseClicked
        // TODO add your handling code here:
        menuAccueil MenuAccueil = new menuAccueil(this.UserId);
        PanelAccueil.removeAll();
        PanelAccueil.add(MenuAccueil).setVisible(true);
    }//GEN-LAST:event_MenuAccueilMouseClicked

    private void MenuAccueilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAccueilMousePressed
        // TODO add your handling code here:
        MenuAccueil.setBackground(ClickedColor);        
        MenuDepense.setBackground(DefaultColor);         
        MenuRecharge.setBackground(DefaultColor);     
        MenuCategorie.setBackground(DefaultColor);
        MenuHistorique.setBackground(DefaultColor);
    }//GEN-LAST:event_MenuAccueilMousePressed

    private void MenuDepenseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDepenseMousePressed
        MenuAccueil.setBackground(DefaultColor);        
        MenuDepense.setBackground(ClickedColor);       
        MenuRecharge.setBackground(DefaultColor);       
        MenuCategorie.setBackground(DefaultColor);
        MenuHistorique.setBackground(DefaultColor);        // TODO add your handling code here:
    }//GEN-LAST:event_MenuDepenseMousePressed

    private void MenuCategorieMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCategorieMousePressed
        // TODO add your handling code here:
        MenuAccueil.setBackground(DefaultColor);        
        MenuDepense.setBackground(DefaultColor);       
        MenuRecharge.setBackground(DefaultColor);       
        MenuCategorie.setBackground(ClickedColor);
        MenuHistorique.setBackground(DefaultColor);
    }//GEN-LAST:event_MenuCategorieMousePressed

    private void MenuHistoriqueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuHistoriqueMousePressed
        // TODO add your handling code here
        MenuAccueil.setBackground(DefaultColor);        
        MenuDepense.setBackground(DefaultColor);       
        MenuRecharge.setBackground(DefaultColor);        
        MenuCategorie.setBackground(DefaultColor);
        MenuHistorique.setBackground(ClickedColor);
    }//GEN-LAST:event_MenuHistoriqueMousePressed

    private void MenuDepenseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDepenseMouseClicked
        // TODO add your handling code here:
        menuDepense MenuDepense = new menuDepense(this.UserId);
        PanelAccueil.removeAll();
        PanelAccueil.add(MenuDepense).setVisible(true);
    }//GEN-LAST:event_MenuDepenseMouseClicked

    private void MenuCategorieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCategorieMouseClicked
        // TODO add your handling code here:        
        menuCategorie MenuCategorie = new menuCategorie(this.UserId);
        PanelAccueil.removeAll();
        PanelAccueil.add(MenuCategorie).setVisible(true);
    }//GEN-LAST:event_MenuCategorieMouseClicked

    private void MenuRechargeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuRechargeMouseClicked
        // TODO add your handling code here:        
        menuRecharge MenuRecharge = new menuRecharge(this.UserId);
        PanelAccueil.removeAll();
        PanelAccueil.add(MenuRecharge).setVisible(true);
    }//GEN-LAST:event_MenuRechargeMouseClicked

    private void MenuRechargeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuRechargeMousePressed
        MenuAccueil.setBackground(DefaultColor);        
        MenuDepense.setBackground(DefaultColor);       
        MenuRecharge.setBackground(ClickedColor);     
        MenuCategorie.setBackground(DefaultColor); 
        MenuHistorique.setBackground(DefaultColor);         // TODO add your handling code here:
    }//GEN-LAST:event_MenuRechargeMousePressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir vous déconnecter ?", "Déconnexion", JOptionPane.YES_NO_OPTION);
        
        if (confirmation == JOptionPane.YES_OPTION) {           
            login loginPage = new login();
            loginPage.setVisible(true);
            this.dispose(); // Ferme la fenêtre actuelle
        }
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accueil("userId").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuAccueil;
    private javax.swing.JPanel MenuCategorie;
    private javax.swing.JPanel MenuDepense;
    private javax.swing.JPanel MenuHistorique;
    private javax.swing.JPanel MenuRecharge;
    private javax.swing.JDesktopPane PanelAccueil;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel menu1;
    private javax.swing.JLabel menu2;
    private javax.swing.JLabel menu3;
    private javax.swing.JLabel menu4;
    private javax.swing.JLabel menu5;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
