package l3.service.impl;

import java.util.ArrayList;

import l3.core.Repository;
import l3.data.entity.Client;
import l3.data.entity.User;
import l3.service.UserServ;

public class UserServImpl implements UserServ {



      private Repository<User> userRepo;



    public UserServImpl(Repository<User> userRepo) {
        this.userRepo = userRepo;
    }



   

    @Override
    public void Create(User ob) {
        userRepo.insert(ob); }

    @Override
    public ArrayList<User> show() {
        return userRepo.selectAll();
        }
    
}
