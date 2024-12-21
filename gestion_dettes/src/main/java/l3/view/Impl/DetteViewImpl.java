package l3.view.Impl;

import java.util.ArrayList;
import java.util.Scanner;

import l3.data.entity.Article;
import l3.data.entity.Client;
import l3.data.entity.Dette;
import l3.data.entity.Paiement;
import l3.view.DetteView;

public class DetteViewImpl implements DetteView {

    Scanner scanner = new Scanner(System.in);

  
@Override
public Dette saisie() {
        double montantVerse;
        double montant;
        do {
            System.out.println("Saisir le montant total de la dette :");
            montant = scanner.nextDouble();
    
            System.out.println("Saisir le montant déjà versé :");
             montantVerse = scanner.nextDouble();
    
        } while (montantVerse > montant);
      
        Dette nouvelleDette = new Dette(montant, montantVerse);
        return nouvelleDette;
    }


    public Dette chercherDette(ArrayList<Dette> datas){
        int choix;
        do {
            for (int i = 0; i < datas.size(); i++) {
                Dette dette = datas.get(i);
                System.out.println(  i+1 + "/ " + dette);
            }
            System.out.println("le numero du client");
            choix=scanner.nextInt();
        }while (choix> datas.size() || choix<1 );
    
        return(datas.get(choix-1));
    }
  

 public void listerDetteNomSoldeClient(Client cl) { 
          for (Dette dette : cl.getDettes()) {
               if (dette.getMontantRestant()!=0) {
                   System.out.println(dette);

          }
     }
    }


    public void listerDetteArticle(Client cl) {
          
          
        for (Dette dette : cl.getDettes()) {
             if (dette.getMontantRestant()!=0) {
                 System.out.println(dette);
                 for (Article article : dette.getArticles()) {
                    System.out.println(article);
                    
                 }
                 
 
        
        }

   
   }
  }


  public void listerDettePaiement(Client cl) {
          
          
    for (Dette dette : cl.getDettes()) {
         if (dette.getMontantRestant()!=0) {
             System.out.println(dette);
             for (Paiement paiement : dette.getPaiements()) {
                System.out.println(paiement);
                
             }

    
    }


}
}


public void listerDetteArticlePaiement(Client cl) {
          
          
    for (Dette dette : cl.getDettes()) {
         if (dette.getMontantRestant()!=0) {
             System.out.println(dette);

             for (Article article : dette.getArticles()) {
                    System.out.println(article);
                    
                 }
                 for (Paiement paiement : dette.getPaiements()) {
                    System.out.println(paiement);
                    
                 }


    
    }


}
}



public void ArchiverDetteNonSolde(ArrayList<Dette> datas) { 
    for (Dette dette : datas) {
         if (dette.getMontantRestant()!=0) {
            dette.Archiver();

    }
}
}





@Override
public void affiche(ArrayList<Dette> datas) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'affiche'");
}



}
