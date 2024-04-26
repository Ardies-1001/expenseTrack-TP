
package com.controller;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class function {
    
    public class DatabaseManager {
    // Méthode pour établir la connexion à la base de données
        public static Connection getConnection() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/finance_wallet_tp_java";
            String user = "root";
            String password = "";

            // Tentative de connexion à la base de données
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, user, password);
                return connection;
            } catch (ClassNotFoundException | SQLException e) {
                // Gestion des exceptions
                throw new SQLException("Error connecting to the database: " + e.getMessage());
            }
        }
    }
    
    
    public class RandomIdGenerator {
    
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int ID_LENGTH = 8;

    public static String generateRandomId() {
            SecureRandom random = new SecureRandom();
            StringBuilder sb = new StringBuilder(ID_LENGTH);

            for (int i = 0; i < ID_LENGTH; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(randomIndex));
            }

            return sb.toString();
        }

        public static void main(String[] args) {
            // Générer un identifiant aléatoire
            String randomId = generateRandomId();
            System.out.println("Identifiant aléatoire: " + randomId);
        }
    }
    
}
