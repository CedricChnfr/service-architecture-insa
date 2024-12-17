package fr.insa.app.userManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_070";
    private static final String USER = "projet_gei_070";
    private static final String PASSWORD = "Uloh9Ies";

    public static void main(String[] args) {
        try {
            // Connexion à la base
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
            
            // Exemple de requête SQL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");

            // Afficher les résultats
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("First Name: " + resultSet.getString("first_name"));
                System.out.println("Last Name: " + resultSet.getString("last_name"));
                System.out.println("Role: " + resultSet.getString("role"));
            }

            // Fermer la connexion
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
