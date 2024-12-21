package l3.view;

import java.util.ArrayList;
import java.util.Scanner;

import l3.data.entity.Article;
import l3.data.entity.Client;
import l3.data.entity.Dette;
import l3.data.entity.Paiement;

public interface DetteView  extends View <Dette>{

  
  



public Dette chercherDette(ArrayList<Dette> datas);

public void listerDetteNomSoldeClient(Client cl);


public void listerDetteArticle(Client cl);


public void listerDettePaiement(Client cl);


public void listerDetteArticlePaiement(Client cl);


public void ArchiverDetteNonSolde(ArrayList<Dette> datas);


}
