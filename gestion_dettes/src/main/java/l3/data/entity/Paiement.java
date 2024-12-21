package l3.data.entity;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
@Data
public class Paiement {
    private LocalDateTime datePaiement;
    private double montant;
    private User boutiquier;
    private Dette dette;
    
    public Paiement() {
    }

    public Paiement( double montant) {
        this.datePaiement = LocalDateTime.now();
        this.montant = montant;
    }


}
