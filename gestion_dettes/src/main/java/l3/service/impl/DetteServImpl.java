package l3.service.impl;

import java.util.ArrayList;

import l3.core.Repository;
import l3.data.entity.Client;
import l3.data.entity.Dette;
import l3.service.DetteServ;

public class DetteServImpl implements DetteServ {
    private Repository<Dette> detteRepo;

    public DetteServImpl(Repository<Dette> detteRepo) {
        detteRepo = detteRepo;
    }

    @Override
    public void Create(Dette ob) {
       detteRepo.insert(ob);
    }

    @Override
    public ArrayList<Dette> show()  {
        return detteRepo.selectAll();
        }
    
}
