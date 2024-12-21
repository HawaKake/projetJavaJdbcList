package l3.service.impl;

import java.util.ArrayList;

import l3.core.Repository;
import l3.data.entity.DemandeDeDette;
import l3.service.DemandeDetteServ;
import lombok.Data;
@Data

public class DemandeDetteServImpl implements DemandeDetteServ{

    
    private Repository<DemandeDeDette> demandeDetteRepo;
    

    public DemandeDetteServImpl(Repository<DemandeDeDette> demandeDetteRepo) {
        this.demandeDetteRepo = demandeDetteRepo;
    }





    public DemandeDetteServImpl() {
    }


   


    @Override
    public ArrayList<DemandeDeDette> show() {
        return demandeDetteRepo.selectAll();  }


    @Override
    public void Create(DemandeDeDette ob) {
        demandeDetteRepo.insert(ob);
    }

  

}
