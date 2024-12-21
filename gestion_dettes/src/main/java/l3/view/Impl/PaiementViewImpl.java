package l3.view.Impl;

import java.util.ArrayList;
import java.util.Scanner;


import l3.data.entity.Paiement;
import l3.view.PaiementView;

public class PaiementViewImpl implements PaiementView {
     Scanner scanner = new Scanner(System.in);

    @Override
    public Paiement saisie() {
        double montant;
       do {
        System.out.print("Entrez le montant du paiement : ");
        montant = scanner.nextDouble();
        
       } while (montant <= 0);

       return new Paiement(montant);
       


    }

    @Override
     public void affiche(ArrayList<Paiement> datas) {
      for (Paiement data : datas) {
           System.out.println(data);   
      }
    } 
}
