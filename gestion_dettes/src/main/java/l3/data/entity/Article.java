package l3.data.entity;

import java.util.List;
import l3.data.enums.EtatArticle;
import lombok.Data;

@Data

public class Article {
    private String nom;
    private int qteStock;
    private double prix;
    private EtatArticle etat;
    private List<Detail> detail;
    private User admin;

    public Article(String nom, int qteStock, double prix) {
        this.nom = nom;
        this.qteStock = qteStock;
        this.prix = prix;
        this.etat = EtatArticle.values()[0];
    }
    
    public Article() {
    }



}
