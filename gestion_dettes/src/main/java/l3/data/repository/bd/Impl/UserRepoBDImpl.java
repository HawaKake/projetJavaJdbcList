package l3.data.repository.bd.Impl;

import l3.core.DataBaseImpl;
import l3.data.entity.User;
import l3.data.enums.StatutUser;
import l3.data.repository.bd.UserRepoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepoBDImpl  extends  DataBaseImpl  implements UserRepoBD {
 

    @Override
    public boolean insert(User user) {
        String sql = "INSERT INTO user (login, email, password, role_id, statut_user) VALUES (?, ?, ?, ?, ?)";
        int nbre = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getRole().getId()); // Suppose que le rôle a un ID
            stmt.setString(5, user.getStatutUser().name());
            nbre = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de l'utilisateur : " + e.getMessage());
        }

        return nbre > 0;
    }

    @Override
    public ArrayList<User> selectAll() {
        String sql = "SELECT * FROM user";
        ArrayList<User> users = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setStatutUser(StatutUser.valueOf(rs.getString("statut_user")));
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }

        return users;
    }
}
