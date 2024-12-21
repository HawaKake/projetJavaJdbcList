package l3.data.repository.bd.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import l3.core.DataBaseImpl;
import l3.data.entity.Dette;
import l3.data.enums.EtatDette;
import l3.data.repository.bd.DetteRepoBD;

public class DetteRepoBDImpl  extends DataBaseImpl implements DetteRepoBD {



    @Override
    public boolean insert(Dette dette) {
        String sql = "INSERT INTO dette (montant, montant_verse, montant_restant, etat) VALUES (?, ?, ?, ?)";
        int nbre = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, dette.getMontant());
            stmt.setDouble(2, dette.getMontantVerse());
            stmt.setDouble(3, dette.getMontantRestant());
            stmt.setString(4, dette.getEtat().name());
            nbre = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la dette : " + e.getMessage());
        }    return nbre > 0;
    }

 

    @Override
    public  ArrayList<Dette> selectAll() {
        String sql = "SELECT * FROM dette";
        ArrayList<Dette> dettes = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Dette dette = new Dette();
                dette.setMontant(rs.getDouble("montant"));
                dette.setMontantVerse(rs.getDouble("montant_verse"));
                dette.setMontantRestant(rs.getDouble("montant_restant"));
                dette.setEtat(EtatDette.valueOf(rs.getString("etat")));
                dettes.add(dette);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des dettes : " + e.getMessage());
        }

        return dettes;
    }
}