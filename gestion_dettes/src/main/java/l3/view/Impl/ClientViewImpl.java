package l3.view.Impl;

import java.util.ArrayList;
import java.util.Scanner;
import l3.data.entity.Client;
import l3.data.entity.Dette;
import l3.data.entity.User;
import l3.view.ClientView;


public class ClientViewImpl implements   ClientView {

    private Scanner scanner = new Scanner(System.in);
    private int choix;
    
    @Override
    public Client saisie() {
        System.out.print("Entrez le nom du client : ");
        String surname = scanner.nextLine();
        System.out.print("Entrez le numéro de téléphone du client : ");
        String telephone = scanner.nextLine();
        System.out.print("Entrez l'adresse du client : ");
        String adresse = scanner.nextLine();
        return new Client(surname, telephone, adresse);
    }
        

   
        


        public int choixCreerCompte(){
            do {
                System.out.println("vous voulez vous creer un compte: 1-oui 2-non");
                choix=scanner.nextInt();

            } while (choix>2 || choix<1);
             return(choix);
        };

        public int choixfiltrerCompte(){
            do {
                System.out.println("vous voulez filtrer par : 1-avec Compte 2-sans Compte");
                choix=scanner.nextInt();

            } while (choix>2 || choix<1);
             return(choix);
        };


        public int voir(){
            do {
                System.out.println("vous voulez voir  : 1-articles 2-payement 3-voir article et payement");
                choix=scanner.nextInt();

            } while (choix>3 || choix<1);
             return(choix);
        };

        public int choixVoir(){
            do {
                System.out.println("vous voulez voir les articles ou les compte: 1-oui 2-non");
                choix=scanner.nextInt();

            } while (choix>2 || choix<1);
             return(choix);
        };


        public int demandefiltrer(){
            do {
                System.out.println("vous voulez filtrer  : 1-oui 2-non");
                choix=scanner.nextInt();

            } while (choix>2 || choix<1);
             return(choix);
        };

    @Override
    public void affiche(ArrayList<Client> datas) {
      for (Client data : datas) {
           System.out.println(data);   
      }
    } 


    public void afficheWithAccount(ArrayList<Client> datas) {
        for (Client data : datas) {
            if (data.getUserCompte()!=null) {
                System.out.println(data);
                             }  
        }
      } 


      public void afficheWithoutAccount(ArrayList<Client> datas) {
        for (Client data : datas) {
            if (data.getUserCompte()==null) {
                System.out.println(data);
                             }  
        }
      }

     
       

      public String SaisieTelephone(ArrayList<Client> datas){
        String tel=null;
       
        do {

            System.out.println("entrer le numero de telephone du client");
            tel=scanner.nextLine();
            for (Client cl : datas) {
                     if (cl!=null && cl.getTelephone().compareTo(tel)==0) {
                        return(tel);  
                        }
           
            } 
        }while (tel==null);

        return(tel);
   }



       public void afficherParTel(ArrayList<Client> datas) {
          String tel=SaisieTelephone(datas);
          
          for (Client cl : datas) {
               if (cl!=null && cl.getTelephone().compareTo(tel)==0) {
                   System.out.println(cl);
          
          }
     }

}



public Client ChercherClient(ArrayList<Client> datas){
    String nom=null;
    do {

        System.out.println("entrer le nom du client");
        nom=scanner.nextLine();
        for (Client cl : datas) {
                 if (cl!=null && cl.getSurname().compareTo(nom)==0) {
                    return(cl);  
                    }
                  } 
    }while (nom==null);

    return(null);
}


  public Client choixClWithoutAccount(ArrayList<Client> datas){
        int choix;
        do {

            for (int i = 0; i < datas.size(); i++) {
                Client cl = datas.get(i);
                if (cl.getUserCompte()==null) { 
                System.out.println(  i+1 + "/ " + cl);
                    }   
            }
            System.out.println(" entrer le numero du client a qui tu creer le compte");
            choix=scanner.nextInt();
        }while (choix> datas.size() || choix<1 );
    
        return(datas.get(choix-1));
    }

}
