/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.menus;

import com.controller.function;
import com.auth.register;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
/*
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/
/**
 *
 * @author VORTEX
 */
public class menuRecharge extends javax.swing.JInternalFrame {

    private String UserId;
    public menuRecharge(String UserId) {
        initComponents();
        // Désactiver le bouton de mise à jour
        update.setEnabled(false);
        
        this.UserId = UserId;
        System.out.println(this.UserId);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        /*
        // Nous avions penser à un timer de 5 seconde, mais ce sera mal puisqu'il pompera les ressorce
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTableData();
            }
        });
        timer.start();
        */
        refreshTableData();

    }
    
    private void refreshTableData() {
        try {
            // Connexion à la base de données
            Connection con = function.DatabaseManager.getConnection();
            Statement st = con.createStatement();

            // Exécution de la requête SQL pour récupérer les données de la table "recharges"
            String query = "SELECT * FROM `recharges` WHERE id_users = '" + this.UserId + "'";
            ResultSet rs = st.executeQuery(query);

            // Nettoyage du modèle de la jTable1 avant de charger de nouvelles données
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            // Ajout des données de la table "recharges" dans le modèle de la jTable1
            while (rs.next()) {
                String id = rs.getString("id_recharge");
                String montant = rs.getString("montant");
                String date = rs.getString("date_recharge");
                model.addRow(new Object[]{id, montant, date});
            }
            
            // Récupérer le solde de l'utilisateur connecté
            String soldeQuery = "SELECT solde FROM users WHERE id = '" + this.UserId + "'";
            ResultSet soldeRs = st.executeQuery(soldeQuery);
            if (soldeRs.next()) {
                double solde = soldeRs.getDouble("solde");
                // Convertir le solde en entier
                int soldeEntier = (int) solde;
                // Mettre à jour le texte du JLabel avec le solde récupéré
                this.solde.setText(String.valueOf(soldeEntier));
            }
            
            // Requête SQL pour obtenir la somme des montants des recharges
            String sommeQuery = "SELECT SUM(montant) AS total FROM recharges WHERE id_users = '" + this.UserId + "'";
            ResultSet sommeRs = st.executeQuery(sommeQuery);

            // Vérifier s'il y a des résultats dans le ResultSet
            if (sommeRs.next()) {
                // Récupérer la somme des montants
                double somme = sommeRs.getDouble("total");

                // Convertir la somme en entier
                int sommeEntier = (int) somme;

                // Mettre à jour le texte du JLabel avec la somme récupérée
                rechargeTotal.setText(String.valueOf(sommeEntier));
            }

            // Fermeture de la connexion à la base de données
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        montant.setText("");
        date_recharge.setText("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        montant = new javax.swing.JTextField();
        date_recharge = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        restore = new javax.swing.JButton();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        rechargeTotal = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        solde = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(690, 470));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 163, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Montant");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));

        montant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montantActionPerformed(evt);
            }
        });
        jPanel3.add(montant, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 30));

        date_recharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_rechargeActionPerformed(evt);
            }
        });
        jPanel3.add(date_recharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 190, 30));

        jLabel17.setText("Date de recharge");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 100, -1));

        restore.setBackground(new java.awt.Color(0, 0, 255));
        restore.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        restore.setForeground(new java.awt.Color(255, 255, 255));
        restore.setText("Restaurer");
        restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreActionPerformed(evt);
            }
        });
        jPanel3.add(restore, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 100, -1));

        save.setBackground(new java.awt.Color(0, 204, 0));
        save.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Enregistrer");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel3.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, -1));

        update.setBackground(new java.awt.Color(255, 153, 0));
        update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Modifier");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 100, -1));

        delete.setBackground(new java.awt.Color(255, 0, 0));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Supprimer");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 100, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 460, 140));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "MONTANT", "DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 460, 160));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Rechercher des recharges");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, -1));

        jPanel5.setBackground(new java.awt.Color(153, 0, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("RECHARGE TOTAL");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        rechargeTotal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rechargeTotal.setForeground(new java.awt.Color(255, 255, 255));
        rechargeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rechargeTotal.setText("200000");
        jPanel5.add(rechargeTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 170, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("FCFA");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 170, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 170, 120));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SOLDE RESTANT");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 20));

        solde.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        solde.setForeground(new java.awt.Color(255, 255, 255));
        solde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        solde.setText("200000");
        jPanel6.add(solde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 170, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("FCFA");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 170, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 170, 120));
        getContentPane().add(searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 320, 30));

        search.setText("Rechercher");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 130, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Listes des recharges");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void montantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montantActionPerformed

    private void date_rechargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_rechargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_rechargeActionPerformed

    private void restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreActionPerformed
        // TODO add your handling code here:
        clearFields();
        refreshTableData();
    }//GEN-LAST:event_restoreActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // Vérifier si les champs sont remplis
        if (montant.getText().isEmpty() || date_recharge.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs avant de soumettre le formulaire.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return; // Arrêter l'exécution de la méthode
        }

        try {
            // Établir une connexion à la base de données
            Connection con = function.DatabaseManager.getConnection();
            Statement st = con.createStatement();
            String randomId = function.RandomIdGenerator.generateRandomId();

            // Requête SQL pour l'insertion des données de recharge
            String query = "INSERT INTO recharges (id_recharge, montant, id_users, date_recharge, created_at) " +
                           "VALUES ('" + randomId + "','" + montant.getText() + "','" + this.UserId + "','" + date_recharge.getText() + "',NOW())";

            // Exécuter la requête SQL
            st.executeUpdate(query);

            // Mise à jour du solde de l'utilisateur dans la table "users"
            // Récupérer le solde actuel de l'utilisateur
            String getBalanceQuery = "SELECT solde FROM users WHERE id = '" + this.UserId + "'";
            ResultSet rs = st.executeQuery(getBalanceQuery);
            double currentBalance = 0;
            if (rs.next()) {
                currentBalance = rs.getDouble("solde");
            }

            // Ajouter le montant de recharge au solde actuel
            double rechargeAmount = Double.parseDouble(montant.getText());
            double newBalance = currentBalance + rechargeAmount;

            // Requête SQL pour mettre à jour le solde de l'utilisateur
            String updateBalanceQuery = "UPDATE users SET solde = " + newBalance + " WHERE id = '" + this.UserId + "'";
            st.executeUpdate(updateBalanceQuery);

            // Nettoyage les champs de saisie après l'insertion 😂
            clearFields();

            // Afficher un message de succès
            String newBalanceString = String.format("%.0f", newBalance); // Formater le nouveau solde sans virgules
            JOptionPane.showMessageDialog(this, "Le montant a été ajouté avec succès. Nouveau solde : " + newBalanceString);
            //JOptionPane.showMessageDialog(this, "Le montant a été ajouté avec succès. Nouveau solde : " + newBalance);
                
             refreshTableData();
            // Fermer la connexion à la base de données
            con.close();
        } catch (SQLException e) {
            // Gérer les exceptions liées à l'insertion des données de recharge
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement des données de recharge: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // Obtenez l'index de la ligne sélectionnée
        int rowIndex = jTable1.getSelectedRow();

        // Vérifiez si une ligne est sélectionnée
        if (rowIndex != -1) { 
            // ID de la ligne sélectionnée
            String id = jTable1.getValueAt(rowIndex, 0).toString(); // Suppose que l'ID est dans la première colonne
            System.out.println("ID : " + id);
            // Les nouvelles valeurs des champs
            String newMontantValue = montant.getText();
            String newDateValue = date_recharge.getText();

            try {
                if (newMontantValue.isEmpty() || newDateValue.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs avant de soumettre le formulaire.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return; // Arrêtez l'exécution de la méthode
                }

                // Connexion à la base de données
                Connection con = function.DatabaseManager.getConnection();
                Statement st = con.createStatement();

                // Requête SQL pour mettre à jour les données de la ligne sélectionnée
                String updateQuery = "UPDATE recharges SET montant = '" + newMontantValue + "', date_recharge = '" + newDateValue + "' WHERE id_recharge = '" + id + "'";

                // Exécution de la requête SQL
                st.executeUpdate(updateQuery);

                // Afficher un message de succès
                JOptionPane.showMessageDialog(this, "Les données ont été mises à jour avec succès.");
                
                clearFields();
                // Actualiser la table pour refléter les modifications
                refreshTableData();
                // Fermeture de la connexion à la base de données
                con.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour des données: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Si aucune ligne n'est sélectionnée, affichez un message d'erreur
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à mettre à jour.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        // Obtenez l'index de la ligne sélectionnée
        int rowIndex = jTable1.getSelectedRow();

        // Vérifiez si une ligne est sélectionnée
        if (rowIndex != -1) {
            try {
                // Connexion à la base de données
                Connection con = function.DatabaseManager.getConnection();
                Statement st = con.createStatement();

                // Obtenez l'ID de la ligne sélectionnée
                String id = jTable1.getValueAt(rowIndex, 0).toString();

                // Requête SQL pour supprimer la ligne sélectionnée
                String deleteQuery = "DELETE FROM recharges WHERE id_recharge = '" + id + "'";

                // Exécutez la requête SQL
                st.executeUpdate(deleteQuery);
                
                clearFields();
                // Actualiser la table pour refléter les modifications
                refreshTableData();
                // Fermeture de la connexion à la base de données
                con.close();

                // Affichez un message de succès
                JOptionPane.showMessageDialog(this, "La ligne sélectionnée a été supprimée avec succès.");

                // Mettez à jour les données de la table pour refléter la suppression
                refreshTableData();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erreur lors de la suppression de la ligne : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Si aucune ligne n'est sélectionnée, affichez un message d'erreur
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // refreshTableData();
        // Obtenez l'index de la ligne sélectionnée
        int rowIndex = jTable1.getSelectedRow();

        // Vérifiez si une ligne est sélectionnée
        if (rowIndex != -1) {
            // Obtenez les valeurs de la ligne sélectionnée
            String id = jTable1.getValueAt(rowIndex, 0).toString();
            String montantValue = jTable1.getValueAt(rowIndex, 1).toString();
            String dateValue = jTable1.getValueAt(rowIndex, 2).toString();

            // Affichez les valeurs dans les champs correspondants
            montant.setText(montantValue);
            date_recharge.setText(dateValue);

            // Le bouton de mise à jour est actif à ce niveau
            update.setEnabled(true);

            // Rafraîchissement les données de la table ici si nécessaire
            // refreshTableData();
        } else {
            // Si aucune ligne n'est sélectionnée, effacez les champs
            clearFields();
            
            // Ici c'est la désactivation du bouton de mise à jour
            update.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // Obtenir le terme de recherche saisi par l'utilisateur
        String searchTerm = searchText.getText().trim();

        try {
            // Connexion à la base de données
            Connection con = function.DatabaseManager.getConnection();
            Statement st = con.createStatement();

            // Requête SQL pour rechercher dans la base de données
            String query = "SELECT * FROM recharges WHERE id_users = '" + this.UserId + "' AND (id_recharge LIKE '%" + searchTerm + "%' OR montant LIKE '%" + searchTerm + "%' OR date_recharge LIKE '%" + searchTerm + "%')";
            ResultSet rs = st.executeQuery(query);

            //Un nouveau modèle de tableau pour stocker les résultats de recherche
            DefaultTableModel filteredModel = new DefaultTableModel();
            filteredModel.setColumnIdentifiers(new String[]{"ID", "MONTANT", "DATE"});

            // Les résultats de la recherche au modèle de tableau
            while (rs.next()) {
                String id = rs.getString("id_recharge");
                String montant = rs.getString("montant");
                String date = rs.getString("date_recharge");
                filteredModel.addRow(new Object[]{id, montant, date});
            }

            // Mise à jour le modèle de du tableau avec les données filtrées
            jTable1.setModel(filteredModel);

            // Fermeture de la connexion à la base de données
            con.close();

            // Afficher un message si aucune occurrence n'est trouvée
            if (filteredModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucune occurrence trouvée pour le terme de recherche.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la recherche: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date_recharge;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField montant;
    private javax.swing.JLabel rechargeTotal;
    private javax.swing.JButton restore;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchText;
    private javax.swing.JLabel solde;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
