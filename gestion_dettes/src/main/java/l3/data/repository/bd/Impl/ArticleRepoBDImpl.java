package l3.data.repository.bd.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import l3.core.DataBaseImpl;
import l3.data.entity.Article;
import l3.data.enums.EtatArticle;
import l3.data.repository.bd.ArticleRepoBD;

public class ArticleRepoBDImpl  extends DataBaseImpl implements ArticleRepoBD{
    @Override
    public boolean insert(Article article) {
        String sql = "INSERT INTO article (nom, qte_stock, prix, etat) VALUES (?, ?, ?, ?)";
        int nbre=0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Remplir les paramètres de la requête préparée
            stmt.setString(1, article.getNom());
            stmt.setInt(2, article.getQteStock());
            stmt.setDouble(3, article.getPrix());
            stmt.setString(4, article.getEtat().name()); // Convertit l'état enum en chaîne de caractères

            stmt.executeUpdate(); // Exécute l'insertion
            System.out.println("Article inséré avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de l'article : " + e.getMessage());
        }

        return nbre==0;
    }



    @Override
    public ArrayList<Article> selectAll() {
        String sql = "SELECT * FROM article";
        ArrayList<Article> articles = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Parcourt les résultats
            while (rs.next()) {
                Article article = new Article();
                article.setNom(rs.getString("nom"));
                article.setQteStock(rs.getInt("qte_stock"));
                article.setPrix(rs.getDouble("prix"));
                article.setEtat(EtatArticle.valueOf(rs.getString("etat"))); 
                articles.add(article); 
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des articles : " + e.getMessage());
        }

        return articles;
    }
    
}
