package l3.data.repository.bd.Impl;

import l3.core.DataBaseImpl;
import l3.data.entity.UserRole;
import l3.data.repository.bd.RoleRepoBd;
import l3.data.repository.bd.UserRepoBD;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleRepoBdImpl   extends  DataBaseImpl implements RoleRepoBd {
    

    @Override
    public boolean insert(UserRole role) {
        String sql = "INSERT INTO user_role (id, nom_role) VALUES (?, ?)";
        int nbre = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, role.getId());
            stmt.setString(2, role.getNomRole());
            nbre = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion du rôle utilisateur : " + e.getMessage());
        }

        return nbre > 0;
    }

    @Override
    public ArrayList<UserRole> selectAll() {
        String sql = "SELECT * FROM user_role";
        ArrayList<UserRole> roles = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UserRole role = new UserRole();
                role.setId(rs.getInt("id"));
                role.setNomRole(rs.getString("nom_role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des rôles utilisateur : " + e.getMessage());
        }

        return roles;
    }
}
