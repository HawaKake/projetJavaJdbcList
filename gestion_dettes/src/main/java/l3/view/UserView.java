package l3.view;

import java.util.ArrayList;
import java.util.Scanner;

import l3.data.entity.Client;
import l3.data.entity.Dette;
import l3.data.entity.User;
import l3.data.entity.UserRole;
import l3.data.enums.StatutUser;


public interface UserView extends View<User> {

public  User saisie(UserRole role );

 
public int saisieChoix();

public int saisieChoixActiveDesactive();

public User chercherCompteUser(ArrayList<User> datas);

public void afficheParStatutUser(ArrayList<User> datas, StatutUser statut );

public void afficheParRole(ArrayList<User> datas, UserRole role);

public int saisieChoixRole();

}
