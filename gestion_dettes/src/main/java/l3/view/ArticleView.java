package l3.view;

import java.util.ArrayList;


import l3.data.entity.Article;
import l3.data.entity.Dette;


public interface ArticleView extends View <Article> {

    public int saisieQteArticle();


    public Article chercherArticle(ArrayList<Article> datas);
    public void afficheParDisponibilite(ArrayList<Article> datas);
    
}
