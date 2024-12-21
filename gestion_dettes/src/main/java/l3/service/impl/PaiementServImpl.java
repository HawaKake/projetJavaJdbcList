package l3.service.impl;

import java.util.ArrayList;

import l3.core.Repository;
import l3.data.entity.Client;
import l3.data.entity.Dette;
import l3.data.entity.Paiement;
import l3.service.ClientServ;
import l3.service.PaiementServ;

public class PaiementServImpl implements PaiementServ{

    private Repository<Paiement> detteRepo;

    public PaiementServImpl(Repository<Paiement> detteRepo) {
        this.detteRepo = detteRepo;
    }

    @Override
    public void Create(Paiement ob) {
        detteRepo.insert(ob);
    }

    @Override
    public ArrayList<Paiement> show() {
        return detteRepo.selectAll();
    }
    
}
