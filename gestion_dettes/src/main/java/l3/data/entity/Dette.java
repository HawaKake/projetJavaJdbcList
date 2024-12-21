package l3.data.entity;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import l3.data.enums.EtatDette;
import lombok.Data;

@Data
public class Dette {
    private int id ;
    private LocalDateTime date;
    private double montant;
    private double montantVerse;
    private double montantRestant;
    private EtatDette etat;
    private Client client;
    private List<Article> articles;
    private List<Paiement> paiements;
    private List<Detail> detail;

    public Dette() {
    }

    public Dette(double montant, double montantVerse) {
        this.date =LocalDateTime.now() ;
        this.montant = montant;
        this.montantVerse = montantVerse;
        this.montantRestant = montant-montantVerse;
        this.etat = EtatDette.values()[1];
    }

    public void AddPaiement(Paiement paiement) {
        paiements.add(paiement);
    }


    public void Archiver() {
        this.etat=EtatDette.values()[0];
    }
}
