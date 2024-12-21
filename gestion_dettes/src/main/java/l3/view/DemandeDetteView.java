package l3.view;

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

public interface DemandeDetteView extends View <DemandeDeDette>{

  


    
public void listerDemandeDetteParEtat(ArrayList<DemandeDeDette> ddettes, EtatDemandeDette etat);
public   EtatDemandeDette saisieEtatDDette();




public int filtrerParEtat();

public int VoirlesArticlesDD();

public DemandeDeDette chercherDette(ArrayList<DemandeDeDette> datas);

public void relancerUneDd(ArrayList<DemandeDeDette> datas);


public void afficherlesArticlesDD( DemandeDeDette dd);


public int demandeValiderOuRefuseDD();

public int choixValiderOuRefuseDD();

public void ValiderOuRefuseDD(DemandeDeDette ddette, EtatDemandeDette etat);


}
