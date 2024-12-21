package l3.data.repository.bd.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import l3.core.DataBaseImpl;
import l3.data.entity.Client;
import l3.data.repository.bd.ClientRepoBD;

public class ClientRepoBDImpl  extends DataBaseImpl implements ClientRepoBD {

      @Override
    public boolean insert(Client client) {
        String sql = "INSERT INTO client (surname, telephone, address) VALUES (?, ?, ?)";
        int nbre = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, client.getSurname());
            stmt.setString(2, client.getTelephone());
            stmt.setString(3, client.getAddress());
            nbre = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion du client : " + e.getMessage());
        }

        return nbre > 0;
    }

   
   
    

 @Override
    public ArrayList<Client> selectAll() {
        String sql = "SELECT * FROM client";
        ArrayList<Client> clients = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Client client = new Client();
                client.setSurname(rs.getString("surname"));
                client.setTelephone(rs.getString("telephone"));
                client.setAddress(rs.getString("address"));
                clients.add(client);
            }
        } catch (SQLException e) {  System.err.println("Erreur lors de la récupération des clients : " + e.getMessage());
        }

        return clients;
    }
    


}
