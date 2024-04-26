
package com.menus;

import com.controller.function;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class menuDepense extends javax.swing.JInternalFrame {

    private final String UserId;
    
    public menuDepense(String UserId) {
        initComponents();
        update.setEnabled(false);
        
        this.UserId = UserId;
        System.out.println(this.UserId);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        // Charger les catégories dès que la fenêtre est ouverte
        //categorieListeActionPerformed(null);
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
                String description = rs.getString("description");
                String categorie = rs.getString("categorie");
                String date = rs.getString("date_depense");
                model.addRow(new Object[]{id, objet, montant,categorie, description, date});
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
        categorie.setText("");
        montant.setText("");
        description.setText("");
        date_depense.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        categorie = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        restore = new javax.swing.JButton();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        montant = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        date_depense = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        objet = new javax.swing.JTextField();
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

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 163, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Objet de la dépense");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        categorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorieActionPerformed(evt);
            }
        });
        jPanel3.add(categorie, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 240, 30));

        jLabel17.setText("Catégorie");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 100, -1));

        restore.setBackground(new java.awt.Color(0, 0, 255));
        restore.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        restore.setForeground(new java.awt.Color(255, 255, 255));
        restore.setText("Restaurer");
        restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreActionPerformed(evt);
            }
        });
        jPanel3.add(restore, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 100, -1));

        save.setBackground(new java.awt.Color(0, 204, 0));
        save.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Enregistrer");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel3.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 100, -1));

        update.setBackground(new java.awt.Color(255, 153, 0));
        update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Modifier");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 100, -1));

        delete.setBackground(new java.awt.Color(255, 0, 0));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Supprimer");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 100, -1));

        montant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montantActionPerformed(evt);
            }
        });
        jPanel3.add(montant, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 190, 30));

        jLabel7.setText("Montant de la dépense");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 140, -1));

        date_depense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_depenseActionPerformed(evt);
            }
        });
        jPanel3.add(date_depense, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 190, 30));

        jLabel8.setText("Date de dépense");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, -1));

        description.setColumns(20);
        description.setRows(5);
        jScrollPane2.setViewportView(description);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 240, 70));

        jLabel18.setText("Description");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 100, -1));

        objet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objetActionPerformed(evt);
            }
        });
        jPanel3.add(objet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 170));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "OBJET", "MONTANT", "CATEGORIE", "DESCRIPTION", "DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jLabel2.setText("Rechercher des dépenses");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 170, -1));

        jPanel5.setBackground(new java.awt.Color(153, 0, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DEPENSE TOTAL");
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

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 170, 120));

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

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 170, 120));
        getContentPane().add(searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 320, 30));

        search.setText("Rechercher");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 130, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Listes des dépenses");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categorieActionPerformed

    private void restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreActionPerformed
        // TODO add your handling code here:
        clearFields();
        refreshTableData();
    }//GEN-LAST:event_restoreActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (montant.getText().isEmpty() || description.getText().isEmpty() || date_depense.getText().isEmpty() || objet.getText().isEmpty() || categorie.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs avant de soumettre le formulaire.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection con = function.DatabaseManager.getConnection();
            Statement st = con.createStatement();
            String randomId = function.RandomIdGenerator.generateRandomId();

            // Récupérer le solde actuel de l'utilisateur
            String querySolde = "SELECT solde FROM users WHERE id = '" + this.UserId + "'";
            ResultSet rs = st.executeQuery(querySolde);
            if (rs.next()) {
                double soldeUtilisateur = rs.getDouble("solde");

                // Vérifier si le solde est suffisant pour effectuer la dépense
                double montantDepense = Double.parseDouble(montant.getText());
                if (soldeUtilisateur >= montantDepense) {
                    // Insérer la dépense dans la base de données
                    String queryInsert = "INSERT INTO depenses (id_depense, objet, description, montant, categorie, id_users, date_depense, created_at) " +
                       "VALUES ('" + randomId + "','" + categorie.getText() + "','" + description.getText() + "','" + montant.getText() + "','" + categorie.getText() + "','" + this.UserId + "', '" + date_depense.getText() + "', NOW())";
                    st.executeUpdate(queryInsert);

                    // Mettre à jour le solde de l'utilisateur en soustrayant le montant de la dépense
                    double nouveauSolde = soldeUtilisateur - montantDepense;
                    String queryUpdate = "UPDATE users SET solde = " + nouveauSolde + " WHERE id = '" + this.UserId + "'";
                    st.executeUpdate(queryUpdate);

                    clearFields();
                    JOptionPane.showMessageDialog(this, "La dépense a été ajoutée avec succès.");

                    refreshTableData();
                } else {
                    JOptionPane.showMessageDialog(this, "Le solde de l'utilisateur est insuffisant pour effectuer cette dépense.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }

            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement des données de dépense: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // Obtenez l'index de la ligne sélectionnée
        int rowIndex = jTable1.getSelectedRow();

        // Vérifiez si une ligne est sélectionnée
        if (rowIndex != -1) { 
            // Obtenez l'ID de la ligne sélectionnée
            String id = jTable1.getValueAt(rowIndex, 0).toString(); // Suppose que l'ID est dans la première colonne

            try {
                if (montant.getText().isEmpty() || description.getText().isEmpty() || date_depense.getText().isEmpty() || objet.getText().isEmpty() || categorie.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs avant de soumettre le formulaire.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Connection con = function.DatabaseManager.getConnection();
                Statement st = con.createStatement();

                // Mettre à jour la dépense dans la base de données
                String queryUpdate = "UPDATE depenses SET objet = '" + objet.getText() + "', description = '" + description.getText() + "', montant = '" + montant.getText() + "', categorie = '" + categorie.getText() + "', date_depense = '" + date_depense.getText() + "' WHERE id_depense = '" + id + "'";
                st.executeUpdate(queryUpdate);

                clearFields();
                JOptionPane.showMessageDialog(this, "La dépense a été mise à jour avec succès.");

                refreshTableData();

                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour des données de dépense: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Si aucune ligne n'est sélectionnée, affichez un message d'erreur
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à mettre à jour.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // Obtenez l'index de la ligne sélectionnée
        int rowIndex = jTable1.getSelectedRow();

        // Vérifiez si une ligne est sélectionnée
        if (rowIndex != -1) { 
            // Obtenez l'ID de la dépense à supprimer
            String id = jTable1.getValueAt(rowIndex, 0).toString(); // Suppose que l'ID est dans la première colonne

            int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer cette dépense ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                try {
                    Connection con = function.DatabaseManager.getConnection();
                    Statement st = con.createStatement();

                    // Requête SQL pour supprimer la dépense de la base de données
                    String queryDelete = "DELETE FROM depenses WHERE id_depense = '" + id + "'";
                    st.executeUpdate(queryDelete);

                    JOptionPane.showMessageDialog(this, "La dépense a été supprimée avec succès.");

                    refreshTableData();

                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de la suppression de la dépense: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            // Si aucune ligne n'est sélectionnée, affichez un message d'erreur
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int rowIndex = jTable1.getSelectedRow();

        // Vérifiez si une ligne est sélectionnée
        if (rowIndex != -1) {
            // Obtenez les valeurs de la ligne sélectionnée
            String id = jTable1.getValueAt(rowIndex, 0).toString();
            String objetValue = jTable1.getValueAt(rowIndex, 1).toString();
            String montantValue = jTable1.getValueAt(rowIndex, 2).toString();
            String categorieValue = jTable1.getValueAt(rowIndex, 3).toString();
            String descriptionValue = jTable1.getValueAt(rowIndex, 4).toString();
            String dateValue = jTable1.getValueAt(rowIndex, 5).toString();

            // Affichez les valeurs dans les champs correspondants
            montant.setText(montantValue);
            date_depense.setText(dateValue);
            objet.setText(objetValue);
            description.setText(descriptionValue);
            categorie.setText(categorieValue);

            // Activer le bouton de mise à jour
            update.setEnabled(true);

            // Rafraîchir les données de la table ici si nécessaire
            refreshTableData();
        } else {
            // Si aucune ligne n'est sélectionnée, effacez les champs
            clearFields();

            // Désactiver le bouton de mise à jour
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
            String query = "SELECT * FROM depenses WHERE id_users = '" + this.UserId + "' AND (id_depense LIKE '%" + searchTerm + "%' OR objet LIKE '%" + searchTerm + "%'OR description LIKE '%" + searchTerm + "%'OR montant LIKE '%" + searchTerm + "%'OR categorie LIKE '%" + searchTerm + "%' OR date_depense LIKE '%" + searchTerm + "%')";
            ResultSet rs = st.executeQuery(query);

            // Créer un nouveau modèle de tableau pour stocker les résultats de recherche
            DefaultTableModel filteredModel = new DefaultTableModel();
            filteredModel.setColumnIdentifiers(new String[]{"ID", "OBJET", "MONTANT", "CATEGORIE","DESCRIPTION", "DATE"});

            // Ajouter les résultats de la recherche au modèle de tableau
            while (rs.next()) {
                String id = rs.getString("id_depense");
                String objet = rs.getString("objet");
                String montant = rs.getString("montant");
                String categorie = rs.getString("categorie");
                String description = rs.getString("description");
                String date = rs.getString("date_depense");
                filteredModel.addRow(new Object[]{id, objet, montant,categorie, description, date});
            }

            // Mettre à jour le modèle de votre tableau avec les données filtrées
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

    private void montantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montantActionPerformed

    private void date_depenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_depenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_depenseActionPerformed

    private void objetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categorie;
    private javax.swing.JTextField date_depense;
    private javax.swing.JButton delete;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField montant;
    private javax.swing.JTextField objet;
    private javax.swing.JLabel rechargeTotal;
    private javax.swing.JButton restore;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchText;
    private javax.swing.JLabel solde;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
