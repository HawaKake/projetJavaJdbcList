package l3;

import java.util.ArrayList;
import java.util.Scanner;

import l3.core.Repository;
import l3.data.entity.Article;
import l3.data.entity.Client;
import l3.data.entity.DemandeDeDette;
import l3.data.entity.Dette;
import l3.data.entity.Paiement;
import l3.data.entity.User;
import l3.data.entity.UserRole;
import l3.data.enums.EtatDemandeDette;
import l3.data.enums.StatutUser;
import l3.data.repository.list.impl.ArticleRepoListImpl;
import l3.data.repository.list.impl.ClientRepoListImpl;
import l3.data.repository.list.impl.DemandeDetteRepolistImpl;
import l3.data.repository.list.impl.DetteRepoListImpl;
import l3.data.repository.list.impl.PaiementRepoListImpl;
import l3.data.repository.list.impl.RoleRepoListImpl;
import l3.data.repository.list.impl.UserRepoListImpl;
import l3.service.impl.ClientservImpl;
import l3.service.ArticleServ;
import l3.service.ClientServ;
import l3.service.UserServ;
import l3.service.DemandeDetteServ;
import l3.service.DetteServ;
import l3.service.PaiementServ;



import l3.service.impl.ArticleServImpl;
import l3.service.impl.DemandeDetteServImpl;
import l3.service.impl.DetteServImpl;
import l3.service.impl.PaiementServImpl;
import l3.service.impl.UserServImpl;
import l3.view.ArticleView;
import l3.view.ClientView;
import l3.view.DemandeDetteView;
import l3.view.DetteView;
import l3.view.PaiementView;
import l3.view.UserView;
import l3.view.Impl.ArticleViewImpl;
import l3.view.Impl.ClientViewImpl;
import l3.view.Impl.DemandeDetteViewImpl;
import l3.view.Impl.DetteViewImpl;
import l3.view.Impl.PaiementViewImpl;
import l3.view.Impl.UserViewImpl;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int choixConnexion;
        int choixAd;
        int choixCl;
        int choix;
        int choix2;
        int choix3;
        int choix4;


        

        Repository<UserRole> roleRepoListImpl=new RoleRepoListImpl();
        ArrayList<UserRole> data=roleRepoListImpl.selectAll();
        Repository<User> userRepo=new UserRepoListImpl();
        Repository<Client> clientRepo=new ClientRepoListImpl();
        Repository<Dette> detteRepo =new DetteRepoListImpl();
        Repository<Paiement> paiementRepo =new PaiementRepoListImpl();
        Repository<Article> articleRepo =new ArticleRepoListImpl();
        Repository<DemandeDeDette> ddetteRepo =new DemandeDetteRepolistImpl();



        ArticleView  articleView= new ArticleViewImpl ();
        ClientView clientView= new ClientViewImpl();
        UserView userView = new UserViewImpl();
        DetteView detteView = new DetteViewImpl();
        PaiementView paiementView=new PaiementViewImpl();
        DemandeDetteView ddetteView =new DemandeDetteViewImpl();


        ArticleServ articleServ= new ArticleServImpl( articleRepo);
        ClientServ clientServ= new ClientservImpl( clientRepo);
        UserServ userServ= new UserServImpl(userRepo);
        DetteServ detteServ=new DetteServImpl(detteRepo);
        PaiementServ paiementServ= new PaiementServImpl(paiementRepo );
        DemandeDetteServ ddetteServ=new DemandeDetteServImpl(ddetteRepo);
        



        


        Article article = new Article();
        Client cl=new Client();
        User user=new User();
        Dette dette=new Dette();
        Paiement paiement=new Paiement();
        DemandeDeDette ddette=new DemandeDeDette();



        EtatDemandeDette etat = EtatDemandeDette.values()[1];
        EtatDemandeDette etat2 = EtatDemandeDette.values()[0];


    do {
        choixConnexion = menuConnexion(); 
        switch (choixConnexion) {
            case 1:
        
                    do {
                        choix=  menuBoutiquier() ;
                        switch (choix) {
                            case 1:cl=clientView.saisie();
                                    System.out.println(cl);
                                    choix2=clientView.choixCreerCompte();
                                    if (choix2==1) {
                                        user=userView.saisie(data.get(0));
                                        cl.setUserCompte(user);
                                        user.setUser(user);
                                        userServ.Create(user);
                                        
                                    } 
                                    clientServ.Create(cl);
                                    
                            break;
                            case 2: clientView.affiche(clientServ.show());
                                        choix3=clientView.demandefiltrer();
                                        if (choix3==1) {
                                            choix4=clientView.choixfiltrerCompte();
                                            if (choix4==1) {
                                                clientView.afficheWithAccount(clientServ.show());
                                            } else {
                                                clientView.afficheWithoutAccount(clientServ.show());
                                            }  
                                        } 
                                    
                            break;
                            case 3:    clientView.afficherParTel(clientServ.show()); 
                            break;
                            case 4:cl=clientView.ChercherClient(clientServ.show());
                                        dette=detteView.saisie();
                                        cl.AddDette(dette);
                                        dette.setClient(cl);
                                    detteServ.Create(dette);
                        
                            break;
                            case 5:dette=detteView.chercherDette(detteServ.show());
                                    paiement=paiementView.saisie();
                                    dette.AddPaiement(paiement);
                                    paiement.setDette(dette);
                                    paiementServ.Create(paiement);
                            break;


                            case 6:cl=clientView.ChercherClient(clientServ.show());
                                    detteView.listerDetteNomSoldeClient(cl);
                                    choix3=clientView.choixVoir();
                                    if (choix3==1) {
                                        choix4=clientView.voir();
                                        if (choix4==1) {
                                            detteView.listerDetteArticle(cl);
                                            
                                        }else if (choix4==2) {
                                            detteView.listerDettePaiement(cl);
                                            
                                        } else{
                                            detteView.listerDetteArticlePaiement(cl);

                                        }
                                    }
                        break;

                        case 7:
                        ddetteView.listerDemandeDetteParEtat(ddetteServ.show(), etat );
                        choix=ddetteView.filtrerParEtat();
                        if (choix==1){
                            etat=ddetteView.saisieEtatDDette();
                            ddetteView.listerDemandeDetteParEtat(ddetteServ.show(), etat);

                        }

                        choix=ddetteView.VoirlesArticlesDD();
                        if (choix==1){
                            ddette=ddetteView.chercherDette(ddetteRepo.selectAll());
                            ddetteView.afficherlesArticlesDD(ddette);

                        }

                        choix=ddetteView.demandeValiderOuRefuseDD();
                        if (choix==1){
                            ddette=ddetteView.chercherDette(ddetteRepo.selectAll());
                            choix2=ddetteView.choixValiderOuRefuseDD();

                            if(choix2==1){
                            
                                ddetteView.ValiderOuRefuseDD(ddette, etat);


                            }else{
                                ddetteView.ValiderOuRefuseDD(ddette, etat2);

                            }
                        
                            

                        }
                        
                        
                        
                break;


                        }
                    }while(choix!=8);
                    
                    break;
            case 2:

                do {
                    UserRole userRoleCl=new UserRole(1,"Client");
                    UserRole userRoleAd=new UserRole(2,"Admin");
                    UserRole userRoleBou=new UserRole(2,"Boutiquier");
                    choixAd = menuAdmin(); 
                    switch (choixAd) {
                        case 1:
                        cl=clientView.choixClWithoutAccount(clientRepo.selectAll());
                        user=userView.saisie(userRoleCl);
                            cl.setUserCompte(user);
                            //reviens sur ce User
                            user.setUser(user);
                            userServ.Create(user);
                            break;
        
                        case 2:
                            choix=userView.saisieChoix();
                            if (choix==1) {
                                user=userView.saisie(userRoleBou);
                                user.setUser(user);
                                userServ.Create(user);
                                
                            } else {
                                user=userView.saisie(userRoleAd);
                            user.setUser(user);
                            userServ.Create(user);
                            }
                       

                        
                          
                            break;
        
                        case 3:
                         user=userView.chercherCompteUser(userRepo.selectAll());
                         choix=userView.saisieChoixActiveDesactive();
                         if (choix==1) {
                            user.activerCompteUtilisateur();
                            
                         }else{
                            user.desactiverCompteUtilisateur();

                         }
                            break;
        
                        case 4:

                        userView.afficheParStatutUser(userRepo.selectAll(), StatutUser.values()[0]);
                            System.out.println("Afficher les comptes utilisateurs actifs ou par rôle");
                            
                            break;

                        case 5:
                            choix=userView.saisieChoixRole();
                            if (choix==1) {
                                userView.afficheParRole(userRepo.selectAll(), userRoleBou);
                            
                                
                            } else {
                                if (choix==2) {
                                    userView.afficheParRole(userRepo.selectAll(), userRoleAd);
                                    
                                } else {
                                    userView.afficheParRole(userRepo.selectAll(), userRoleCl);
                                }
                                
                            }
                            break;
        
                        case 6:
                            article=articleView.saisie(); 
                            articleServ.Create(article);
                            break;
                        
                        case 7:
                            articleView.affiche(articleRepo.selectAll());
                            break;


                        case 8:
                            articleView.afficheParDisponibilite(articleRepo.selectAll());
                            break;
        
                        case 9:
                        article=articleView.chercherArticle(articleRepo.selectAll());
                        int qte=articleView.saisieQteArticle();

                        article.setQteStock(qte);
                            break;
        
                        case 10:
                           detteView.ArchiverDetteNonSolde(detteRepo.selectAll());
                            break;
                    }
                } while (choixAd != 11);  
                    
                break;

            case 3:
                do {
                    choixCl = menuClient(); // Affiche le menu client et récupère le choix de l'utilisateur
                    switch (choixCl) {
                        case 1:
                                cl=clientView.ChercherClient(clientServ.show());
                                detteView.listerDetteNomSoldeClient(cl);
                                choix3=clientView.choixVoir();
                                if (choix3==1) {
                                    choix4=clientView.voir();
                                    if (choix4==1) {
                                        detteView.listerDetteArticle(cl);
                                        
                                    }else if (choix4==2) {
                                        detteView.listerDettePaiement(cl);
                                        
                                    } else{
                                        detteView.listerDetteArticlePaiement(cl);

                                    }
                                }
                                 break;
                        case 2:
                            ddette=ddetteView.saisie();
                            ddetteServ.Create(ddette);
                            break;
        
                        case 3:
                        ddetteView.affiche(ddetteServ.show() );
                        choix=ddetteView.filtrerParEtat();
                        if (choix==1){
                            etat=ddetteView.saisieEtatDDette();
                            ddetteView.listerDemandeDetteParEtat(ddetteServ.show(), etat);

                        }
                            break;
        
                        case 4:
                            ddetteView.relancerUneDd(ddetteServ.show());
                            break;
        
                       
                    }
                } while (choixCl!= 5);
                    break;

            }
        } while (choixConnexion!= 4);

     
                }




 

    public static int menuBoutiquier() {
        System.out.println("1- Créer  un client avec ou sans compte");
        System.out.println("2- lister les clients  et avoir la possibilité de filtrer ceux qui ont des comptes ou pas ");
        System.out.println("3- rechercher client par telephone");
        System.out.println("4- creer une dette pour un client");
        System.out.println("5- Enregistrer un paiement pour une dette saisie le payement et je met une fonction dans la classe client ki ajoute payement");
        System.out.println("6-Lister les dettes non soldées d’un client avec l’option de voir les articles ou les paiements");
        System.out.println("7-Lister les demandes de dette en cours avec l’option de filtrer par état,  voir les articles, enfin valider ou refuser la dette.");
        System.out.println("8- Quitter");
        return scanner.nextInt();
    }


    public static int menuAdmin() {
        System.out.println("1- Créer un compte utilisateur à un client n’ayant pas de compte");
        System.out.println("2- Créer un compte utilisateur avec un rôle Boutiquier ou  Admin ");
        System.out.println("3- Désactiver/Activer  un compte utilisateur  ");
        System.out.println("4- Afficher les comptes utilisateurs  actifs ");
        System.out.println("5- Afficher les comptes utilisateurs  par rôle");
        System.out.println("6- Créer des articles ");
        System.out.println("7- lister  des articles ");
        System.out.println("8-  filtrer les articles  par disponibilité ");
        System.out.println("9- Mettre à jour la qté en stock d’un article");
        System.out.println("10- Archiver les dettes soldées");
        System.out.println("11- Quitter");
        return scanner.nextInt();
    }

    public static int menuClient() {
        System.out.println("1- Lister  dettes non soldées d’un client avec l’option de voir les articles ou les paiements");
        System.out.println("2- faire une demande de dette");
        System.out.println("3- Lister ses demandes de dette avec l’option de filtrer par état");
        System.out.println("4-Envoyer une relance pour une  demande de dette annuler");
        System.out.println("5- Quitter");
        return scanner.nextInt();
    }

    public static int menuConnexion() {
        System.out.println("1- Admin");
        System.out.println("2- Client");
        System.out.println("3- Client");
        System.out.println("4- Quitter");
        System.out.print("Veuillez entrer votre choix : ");
        return scanner.nextInt();
    }


}