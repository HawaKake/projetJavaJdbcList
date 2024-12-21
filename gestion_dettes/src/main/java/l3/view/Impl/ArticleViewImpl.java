package l3.view.Impl;

import java.util.ArrayList;
import java.util.Scanner;

import l3.data.entity.Article;
import l3.data.entity.Dette;
import l3.data.entity.Paiement;
import l3.data.enums.EtatArticle;
import l3.view.ArticleView;

public class ArticleViewImpl implements ArticleView {

    private Scanner scanner = new Scanner(System.in);
    private int choix;
    
    
    @Override
    public Article saisie() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom de l'article : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez la quantité en stock : ");
        int qteStock = scanner.nextInt();

        System.out.print("Entrez le prix de l'article : ");
        double prix = scanner.nextDouble();
        
        return new Article(nom, qteStock, prix);

    }

    public int saisieQteArticle() {
        Scanner scanner = new Scanner(System.in);
        int qte;
        do {
            System.out.print("Entrez la quantite : ");
             qte = scanner.nextInt();

            
        } while (qte<0);
        
       
        return qte;

    }


    @Override
    public void affiche(ArrayList<Article> datas) {
        for (Article data : datas) {
             System.out.println(data);   
        }
      } 

      public void afficheParDisponibilite(ArrayList<Article> datas) {
        for (Article data : datas) {
            if (data.getQteStock()!=0) {
                System.out.println(data);
                
            }
               
        }
      } 



       public Article chercherArticle(ArrayList<Article> datas){
        int choix;
        do {
    
           
            for (int i = 0; i < datas.size(); i++) {
                Article article = datas.get(i);
                System.out.println(  i+1 + "/ " + article);
            }
            System.out.println("le numero d'article a archiver");
           
            choix=scanner.nextInt();
        }while (choix> datas.size() || choix<1 );
    
        return(datas.get(choix-1));
    }

    

    
}
