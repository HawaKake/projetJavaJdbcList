package l3.view.Impl;

import java.util.ArrayList;
import java.util.Scanner;

import l3.data.entity.Client;
import l3.data.entity.Dette;
import l3.data.entity.User;
import l3.data.entity.UserRole;
import l3.data.enums.StatutUser;
import l3.view.UserView;


public class UserViewImpl implements UserView {
private Scanner scanner = new Scanner(System.in);


@Override
public User saisie(UserRole role) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le login:");
        String login = scanner.nextLine();

        System.out.println("Entrez l'email:");
        String email = scanner.nextLine();

        System.out.println("Entrez le mot de passe:");
        String password = scanner.nextLine();


        return new User(login, email, password, role);
    }

   
    
    
    
    public int saisieChoix(){
        int choix;
        do {
            System.out.println("vous voulez creer un compte : 1-Boutiquier 2-Admin");
            choix=scanner.nextInt();
        } while (choix>2 || choix<1);
         return(choix);
    };

     public User chercherCompteUser(ArrayList<User> datas){
        int choix;
        do {
    
           
            for (int i = 0; i < datas.size(); i++) {
                User user= datas.get(i);
                System.out.println(  i+1 + "/ " + user);
            }
            System.out.println("le numero du compte a activer ou desactiver");
            choix=scanner.nextInt();
        }while (choix> datas.size() || choix<1 );
    
        return(datas.get(choix-1));
    }

    public int saisieChoixActiveDesactive(){
        int choix;
        do {
            System.out.println("vous voulez  : 1-activer 2-desactiver");
            choix=scanner.nextInt();
        } while (choix>2 || choix<1);
         return(choix);
    };

    public void affiche (ArrayList<User> datas, StatutUser statut ) {
      for (User data : datas) {
           System.out.println(data);   
      }
     }

     public void afficheParStatutUser(ArrayList<User> datas, StatutUser statut ) {
        for (User data : datas) {
            if (data.getStatutUser()==statut) {

                System.out.println(data);   

            }

        }
       }


       public void afficheParRole(ArrayList<User> datas, UserRole role) {
        for (User data : datas) {
            if (data.getRole()==role) {

                System.out.println(data);   

            }

        }
       }

       public int saisieChoixRole(){
        int choix;
        do {
            System.out.println("vous voulez creer un compte : 1-Boutiquier 2-Admin 3-Client");
            choix=scanner.nextInt();
        } while (choix>3 || choix<1);
         return(choix);
    }





    @Override
    public User saisie() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saisie'");
    }





    @Override
    public void affiche(ArrayList<User> datas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'affiche'");
    }





    
    
  

   
   
    

    
     

}
