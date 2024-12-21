package l3.data.repository.bd.Impl;

import l3.core.DataBaseImpl;
import l3.data.entity.Paiement;
import l3.data.repository.bd.PaiementRepoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaiementRepoBDImpl extends DataBaseImpl implements PaiementRepoBD {
   

    @Override
    public boolean insert(Paiement paiement) {
        String sql = "INSERT INTO paiement (montant, date_paiement, boutiquier_id, dette_id) VALUES (?, ?, ?, ?)";
        int nbre = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, paiement.getMontant());
            stmt.setTimestamp(2, Timestamp.valueOf(paiement.getDatePaiement()));
            stmt.setInt(3, paiement.getBoutiquier().getId()); // Suppose que le boutiquier a un ID
            stmt.setInt(4, paiement.getDette().getId());       // Suppose que la dette a un ID
            nbre = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion du paiement : " + e.getMessage());
        }

        return nbre > 0;
    }

    @Override
    public ArrayList<Paiement> selectAll() {
        String sql = "SELECT * FROM paiement";
        ArrayList<Paiement> paiements = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Paiement paiement = new Paiement();
                paiement.setMontant(rs.getDouble("montant"));
                paiement.setDatePaiement(rs.getTimestamp("date_paiement").toLocalDateTime());
                paiements.add(paiement);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des paiements : " + e.getMessage());
        }

        return paiements;
    }
}
