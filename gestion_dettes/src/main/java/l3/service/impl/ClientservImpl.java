package l3.service.impl;

import java.util.ArrayList;
import java.util.List;

import l3.core.Repository;
import l3.data.entity.Client;
import l3.service.ClientServ;

public class ClientservImpl implements ClientServ{
    

      private Repository<Client> clientRepo;



    public ClientservImpl (Repository<Client> clientRepo) {
        this.clientRepo = clientRepo;
    }



    @Override
    public void Create(Client ob) {
        clientRepo.insert(ob);
    }


    @Override
    public ArrayList<Client> show() {
        return clientRepo.selectAll();
    }
}
