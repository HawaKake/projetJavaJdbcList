package l3.view.Impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import l3.data.entity.Article;
import l3.data.entity.Client;
import l3.data.entity.DemandeDeDette;
import l3.data.entity.Dette;
import l3.data.enums.EtatDemandeDette;
import l3.data.enums.EtatDette;
import l3.data.repository.bd.DemandeDetteRepoBD;
import l3.view.DemandeDetteView;

public class DemandeDetteViewImpl  implements DemandeDetteView{

  private Scanner scanner = new Scanner(System.in);


  @Override
  public DemandeDeDette saisie() {
     
        System.out.println("Entrez le montant de la demande : ");
        double montant = scanner.nextDouble();
      //
        System.out.println("Entrez l'état de la demande (ANNULEE ou ENCOURS) : ");
       
        EtatDemandeDette etat = saisieEtatDDette();
        return new DemandeDeDette( montant,  etat);
    }




    public void listerDemandeDetteParEtat(ArrayList<DemandeDeDette> ddettes, EtatDemandeDette etat) {
      for (DemandeDeDette ddette : ddettes) {
          if (ddette.getEtat() == etat) { 
              System.out.println(ddette);
          }
      }
  }
  


   

  @Override
  public void affiche(ArrayList<DemandeDeDette> datas) {
  for (DemandeDeDette ddette  : datas) {
   
        System.out.println(ddette);
       
        
    
}

}



public   EtatDemandeDette saisieEtatDDette(){
    int etatChoice;
    do {
      for (EtatDemandeDette  etat :EtatDemandeDette.values()) {
        System.out.println((etat.ordinal()+1)+"-"+etat.name());    
      }
      System.out.println("Veuillez selectionnez une filiere ");
      etatChoice=scanner.nextInt();
     } while (etatChoice<=0 || etatChoice>EtatDemandeDette.values().length);  
    
      return EtatDemandeDette.values()[etatChoice-1];
}




public int filtrerParEtat(){
  int choix;
  do {
      System.out.println("vous voulez vous filtrer par etat: 1-oui 2-non");
      choix=scanner.nextInt();

  } while (choix>2 || choix<1);
   return(choix);
};

public int VoirlesArticlesDD(){
  int choix;
  do {
      System.out.println("vous voulez vous voir les articles d'une dette: 1-oui 2-non");
      choix=scanner.nextInt();

  } while (choix>2 || choix<1);
   return(choix);
};

public DemandeDeDette chercherDette(ArrayList<DemandeDeDette> datas){
  int choix;
  do {

     
      for (int i = 0; i < datas.size(); i++) {
          DemandeDeDette dd = datas.get(i);
          System.out.println(  i+1 + "/ " + dd);
      }
      System.out.println("entrer le numero correspondant a la demande de dette");
      choix=scanner.nextInt();
  }while (choix> datas.size() || choix<1 );

  return(datas.get(choix-1));
}



public void relancerUneDd(ArrayList<DemandeDeDette> datas){
  int choix;
  DemandeDeDette dd;
  do {

     
      for (int i = 0; i < datas.size(); i++) {
          dd = datas.get(i);
          if (dd.getEtat()==EtatDemandeDette.ANNULEE) {
            System.out.println(  i+1 + "/ " + dd);
          }
         
      }
      System.out.println("entrer le numero correspondant a la demande de dette Annuler que tu veux relancer");
      choix=scanner.nextInt();
  }while (choix> datas.size() || choix<1 );

  datas.get(choix-1).setEtat(EtatDemandeDette.ENCOURS);
}



public void afficherlesArticlesDD( DemandeDeDette dd){
  int choix;
  for (Article article: dd.getArticles()) {
    System.out.println(article);
    
  }
};


public int demandeValiderOuRefuseDD(){
  int choix;
  do {
      System.out.println("vous voulez valider ou refuser une demande de dette ? : 1-oui 2-non");
      choix=scanner.nextInt();

  } while (choix>2 || choix<1);
   return(choix);
};

public int choixValiderOuRefuseDD(){
  int choix;
  do {
      System.out.println("vous voulez vous ? : 1-valider  2-refuser");
      choix=scanner.nextInt();

  } while (choix>2 || choix<1);
   return(choix);
};





public void ValiderOuRefuseDD(DemandeDeDette ddette, EtatDemandeDette etat){
  ddette.setEtat(etat);

}










}
