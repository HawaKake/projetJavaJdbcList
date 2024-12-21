package l3.data.entity;
import java.util.ArrayList;

import l3.data.enums.StatutUser;
import lombok.Data;
@Data


public class User { 
    private int id;
    private String login;
    private String email;
    private String password; 
    private UserRole role;
    private StatutUser statutUser;
    private User user;
    private ArrayList<User>Users;
    private   ArrayList<DemandeDeDette> demandeDeDettes;
    private  ArrayList<Paiement> paiements;
    private ArrayList<Article>listArticle;
    private ArrayList<Dette>dettes;
  
    public User() {
    }


    public User(String login, String email, String password, UserRole role) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.statutUser =StatutUser.ACTIF;
    }
 
  

    public void desactiverCompteUtilisateur() {
        this.statutUser=StatutUser.values()[1];
    }

    public void activerCompteUtilisateur() {
        this.statutUser=StatutUser.values()[0];
    }
    


  }