package l3.core.factory;

import l3.data.entity.Article;
import l3.data.entity.Client;
import l3.data.entity.DemandeDeDette;
import l3.data.entity.Detail;
import l3.data.entity.Dette;
import l3.data.entity.Paiement;
import l3.data.entity.User;
import l3.data.entity.UserRole;

public class EntityFacto {


    public EntityFacto() {
      
    }

    
    public Client getInstanceClient() {
        return new Client();
    }

    
    public Article getInstanceArticle() {
        return new Article();

    }
    


    public DemandeDeDette getInstanceDemandeDeDette() {
            return new DemandeDeDette();
             }

    public Detail getInstanceDetail() {
                return new Detail();
                 }


    public Dette getInstanceDette() {
                    return new Dette();
                     }


    public Paiement getInstancePaiement() {
        return new Paiement();
             }



    public User getInstanceUser() {
        return new User();
         }


    public UserRole getInstanceUserRoler() {
        return new UserRole();
        }
}
