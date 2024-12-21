package l3.view;

import java.util.ArrayList;
import java.util.Scanner;
import l3.data.entity.Client;
import l3.data.entity.Dette;
import l3.data.entity.User;


public interface ClientView extends View <Client> {

    


    

   
     
    public int choixCreerCompte();

    public int choixfiltrerCompte();


    public int voir();

    public int choixVoir();


    public int demandefiltrer();
    public void afficheWithAccount(ArrayList<Client> datas);

    public void afficheWithoutAccount(ArrayList<Client> datas);
    public String SaisieTelephone(ArrayList<Client> datas);
   



       public void afficherParTel(ArrayList<Client> datas);


public Client ChercherClient(ArrayList<Client> datas);


  public Client choixClWithoutAccount(ArrayList<Client> datas);

}
