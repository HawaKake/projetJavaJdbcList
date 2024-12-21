package l3.data.repository.bd.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import l3.core.DataBaseImpl;
import l3.data.entity.DemandeDeDette;
import l3.data.enums.EtatDemandeDette;
import l3.data.repository.bd.DemandeDetteRepoBD;

public class DemandeDetteRepoBDImpl  extends DataBaseImpl implements DemandeDetteRepoBD{

    

    @Override
    public boolean insert(DemandeDeDette demande) {
        String sql = "INSERT INTO demande_dette (montant, etat) VALUES (?, ?)";
        int nbre = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, demande.getMontant());
            stmt.setString(2, demande.getEtat().name());
            nbre = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la demande de dette : " + e.getMessage());
        }

        return nbre > 0;
    }




     @Override
    public ArrayList<DemandeDeDette> selectAll() {
        String sql = "SELECT * FROM demande_dette";
        ArrayList<DemandeDeDette> demandes = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DemandeDeDette demande = new DemandeDeDette();
                demande.setMontant(rs.getDouble("montant"));
                demande.setEtat(EtatDemandeDette.valueOf(rs.getString("etat")));
                demandes.add(demande);
            }
        } catch (SQLException e) {System.err.println("Erreur lors de la récupération des demandes de dette : " + e.getMessage());
        }

        return demandes;
    }

    
}
