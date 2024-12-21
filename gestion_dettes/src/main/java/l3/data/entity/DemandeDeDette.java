package l3.data.entity;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import l3.data.enums.EtatDemandeDette;

@Data



public class DemandeDeDette {
    private LocalDateTime dateDemande;         
    private double montant;                 
    private List<Article> articles;   
    private EtatDemandeDette etat;               
    private User client;

    public DemandeDeDette(double montant, EtatDemandeDette etat) {
        this.dateDemande = LocalDateTime.now();
        this.montant = montant;
        this.etat = etat;
    }
    

    public DemandeDeDette() {

    }





}
