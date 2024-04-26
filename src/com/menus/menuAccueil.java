/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.menus;

import com.controller.function;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VORTEX
 */
public class menuAccueil extends javax.swing.JInternalFrame {

    private String UserId;
    public menuAccueil(String UserId) {
        this.UserId = UserId;
        System.out.println(this.UserId);
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        refreshTableData();
    }

    private void refreshTableData() {
    try {
        // Connexion à la base de données
        Connection con = function.DatabaseManager.getConnection();
        Statement st = con.createStatement();
        
        // Exécution de la requête SQL pour récupérer les données de la table "depenses"
        String query = "SELECT * FROM `depenses` WHERE id_users = '" + this.UserId + "'";
        ResultSet rs = st.executeQuery(query);

        // Nettoyage du modèle de la jTable1 avant de charger de nouvelles données
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        // Ajout des données de la table "depenses" dans le modèle de la jTable1
        while (rs.next()) {
            String id = rs.getString("id_depense");
            String objet = rs.getString("objet");
            String montant = rs.getString("montant");
            String date = rs.getString("date_depense");
            model.addRow(new Object[]{id, objet, montant, date});
        }

        // Récupérer le solde de l'utilisateur connecté
        String soldeQuery = "SELECT solde FROM users WHERE id = '" + this.UserId + "'";
        ResultSet soldeRs = st.executeQuery(soldeQuery);
        if (soldeRs.next()) {
            double solde = soldeRs.getDouble("solde");
            // Convertir le solde en entier
            int soldeEntier = (int) solde;
            // Mettre à jour le texte du JLabel avec le solde récupéré
            soldeRestant.setText(String.valueOf(soldeEntier));
        }

        // Requête SQL pour obtenir la somme des montants des dépenses de l'utilisateur
        String depenseQuery = "SELECT SUM(montant) AS total FROM depenses WHERE id_users = '" + this.UserId + "'";
        ResultSet depenseRs = st.executeQuery(depenseQuery);
        if (depenseRs.next()) {
            // Récupérer la somme des montants de dépenses
            double depenseTotal = depenseRs.getDouble("total");
            // Convertir la somme en entier
            int depenseEntier = (int) depenseTotal;
            // Mettre à jour le texte du JLabel avec la somme des montants de dépenses récupérée
            this.depenseTotal.setText(String.valueOf(depenseEntier));
        }

        // Requête SQL pour obtenir la somme des montants des recharges de l'utilisateur
        String rechargeQuery = "SELECT SUM(montant) AS total FROM recharges WHERE id_users = '" + this.UserId + "'";
        ResultSet rechargeRs = st.executeQuery(rechargeQuery);
        if (rechargeRs.next()) {
            // Récupérer la somme des montants de recharges
            double rechargeTotal = rechargeRs.getDouble("total");
            // Convertir la somme en entier
            int rechargeEntier = (int) rechargeTotal;
            // Mettre à jour le texte du JLabel avec la somme des montants de recharges récupérée
            this.rechargeTotal.setText(String.valueOf(rechargeEntier));
        }

        // Fermeture de la connexion à la base de données
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }
}



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        rechargeTotal = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        depenseTotal = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        soldeRestant = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        majBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(690, 470));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 156, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "OBJET", "MONTANT", "DATE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 640, 170));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Listes des dépenses");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 160, -1));

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("RECHARGE TOTAL");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 120, -1));

        rechargeTotal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rechargeTotal.setForeground(new java.awt.Color(255, 255, 255));
        rechargeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rechargeTotal.setText("200000");
        jPanel7.add(rechargeTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 170, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("FCFA");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 170, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8-merchant-account-24.png"))); // NOI18N
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 30, 30));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 170, 120));

        jPanel5.setBackground(new java.awt.Color(0, 204, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DEPENSE TOTAL");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        depenseTotal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        depenseTotal.setForeground(new java.awt.Color(255, 255, 255));
        depenseTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        depenseTotal.setText("200000");
        jPanel5.add(depenseTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 170, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("FCFA");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 170, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8-line-24.png"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 170, 120));

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SOLDE RESTANT");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 20));

        soldeRestant.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        soldeRestant.setForeground(new java.awt.Color(255, 255, 255));
        soldeRestant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        soldeRestant.setText("200000");
        jPanel6.add(soldeRestant, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 170, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("FCFA");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8-sales-balance-24.png"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 120));

        majBtn.setBackground(new java.awt.Color(255, 153, 0));
        majBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        majBtn.setForeground(new java.awt.Color(255, 255, 255));
        majBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/assets/icon/icons8-restart-20.png"))); // NOI18N
        majBtn.setText("Mettre à jour !");
        majBtn.setIconTextGap(30);
        majBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                majBtnActionPerformed(evt);
            }
        });
        getContentPane().add(majBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 330, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void majBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majBtnActionPerformed
        // TODO add your handling code here:
        refreshTableData();
    }//GEN-LAST:event_majBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int rowIndex = jTable1.getSelectedRow();

        // Vérifiez si une ligne est sélectionnée
        if (rowIndex != -1) {
            // Obtenez les valeurs de la ligne sélectionnée
            String id = jTable1.getValueAt(rowIndex, 0).toString();
            String objetValue = jTable1.getValueAt(rowIndex, 1).toString();
            String montantValue = jTable1.getValueAt(rowIndex, 2).toString();
            String dateValue = jTable1.getValueAt(rowIndex, 3).toString();
           
            // Ici c'est de rafraîchir les données de la table ici si nécessaire
            refreshTableData();
        } else {
            // Si aucune ligne n'est sélectionnée, nous effaçons les champs
            
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel depenseTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton majBtn;
    private javax.swing.JLabel rechargeTotal;
    private javax.swing.JLabel soldeRestant;
    // End of variables declaration//GEN-END:variables
}
